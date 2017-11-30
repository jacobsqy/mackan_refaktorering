import Model.BigFactory;
import Model.Vehicle;
import Controller.CarController;
import View.CarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) { new Main().createCar(); }

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // Instance of this class
    private CarController cc = new CarController();
    // List of cars
    private List<Vehicle> carList = new ArrayList();
    // The frame that represents this instance View of the MVC pattern
    private CarView frame;

    private void createCar() {

        carList.add(BigFactory.createSaab95());
        carList.add(BigFactory.createVolvo240());
        carList.add(BigFactory.createScania());

        cc.setCars(carList);

        // Start a new view and send a reference of self
        frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        timer.start();

    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : carList) {
                car.move();
                int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());
                car.hitBoundaries(CarView.getMaxHeight(), CarView.getMaxWidth(), x, y, car);
            }
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }
    }
}
