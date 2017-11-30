package Model;

import java.awt.geom.Point2D;
import java.util.Deque;
import java.util.List;

public class Cargo {

    public boolean isUp() {
        return isUp;
    }

    /** ramp state */
    private boolean isUp;

    public void lowerRamp(double currentSpeed) {
        if (currentSpeed == 0) {
            isUp = false;
        }
    }

    public void raiseRamp() { isUp = true; }

    /* METHODS FOR BOAT */
    /** @param car is the car being loaded onto the boat
     *  @param carList is a list of cars
     *  @param pos is the current position of the boat
     *  @param MAX_CARS is the max amount of cars to be loaded
     *  @param MAX_DISTANCE is the max distance between car and boat*/
    public void loadCar(Car car, List<Car> carList, Point2D.Double pos, int MAX_CARS, double MAX_DISTANCE) {
        boolean isSpace = !(carList.size() == MAX_CARS);
        boolean same_pos_x = pos.x <= car.getPosition().x - MAX_DISTANCE;
        boolean same_pos_y = pos.y <= car.getPosition().y - MAX_DISTANCE;

        if (same_pos_x && same_pos_y && isSpace && !isUp) {
            carList.add(car);  //pushes car onto boat
            car.setPosition(pos); //sets cars position to boats position
            car.setLoaded(true);
            car.stopEngine();
        }
    }

    public void unloadCar(List<Car> carList, Point2D.Double pos) {
        Car c;
        if (!isUp) {
            c = carList.get(0);
            carList.remove(0);
            c.setPosition(new Point2D.Double(pos.x - 1, pos.y));
            c.setLoaded(false);
        }
    }

    /* METHODS FOR TRUCK */
    /** @param car is the car being loaded onto the boat
     *  @param carStack is a stack of cars
     *  @param pos is the current position of the boat
     *  @param MAX_CARS is the max amount of cars to be loaded
     *  @param MAX_DISTANCE is the max distance between car and truck*/
    public void loadCar(Car car, Deque<Car> carStack, Point2D.Double pos, int MAX_CARS, double MAX_DISTANCE) {
        boolean validCar = !(car instanceof Scania); //checks that the car isn't a truck
        boolean isSpace = !(carStack.size() == MAX_CARS); //checks if the trailer is full
        boolean same_pos_x = pos.x <= car.getPosition().x - MAX_DISTANCE;
        boolean same_pos_y = pos.y <= car.getPosition().y - MAX_DISTANCE;

        if (same_pos_x && same_pos_y && validCar && isSpace && !isUp) {
            carStack.push(car);  //pushes car onto trailer
            car.setPosition(pos); //sets cars position to trailers position
        }
    }



    /** to unload cars from the trailer */
    public void unloadCar(Deque<Car> carStack, Point2D.Double pos) {
        Car c;
        if (!isUp) {
            c = carStack.pop();
            c.setPosition(new Point2D.Double(pos.x - 1, pos.y));
        }
    }
}
