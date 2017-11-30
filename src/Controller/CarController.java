package Controller;

import Model.Saab95;
import Model.Scania;
import Model.Vehicle;
import View.CarView;

import java.util.ArrayList;
import java.util.List;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
*/

public class CarController {
    // member fields:
    // A list of cars, modify if needed
    private List<Vehicle> cars = new ArrayList<>();

    public void setCars(List<Vehicle> cars) {
        this.cars = cars;
    }

    public List<Vehicle> getCars() {
        return cars;
    }

    //methods:
    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }
    // Calls the startEngine method for each car
    public void startEngines() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }
    // Calls the stopEngine method for each car
    public void stopEngines() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }
    // Calls the brake method for each car
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    public void turboOn() {
        for (Vehicle car : cars) {
            if (car.getClass().getName().equals("Model.Saab95")) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (Vehicle car : cars) {
            if (car.getClass().getName().equals("Model.Saab95")) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    public void lowerTrailer() {
        for (Vehicle car : cars) {
            if (car.getClass().getName().equals("Model.Scania")) {
                ((Scania) car).lowerTrailer();
            }
        }
    }

    public void raiseTrailer() {
        for (Vehicle car : cars) {
            if (car.getClass().getName().equals("Model.Scania")) {
                ((Scania) car).resetTrailer();
            }
        }
    }

}