package Model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Boat extends Vehicle {

    /** constructor */
    public Boat() {
        super(200, Color.WHITE, "Boaty", new Point2D.Double(0,0));
    }

    private Cargo cargo = new Cargo();

    /** Max amount of cars stored */
    private static final int MAX_CARS = 25;

    /** Max distance from ramp */
    private static final double MAX_DISTANCE = 1.0;

    public List<Car> getLoadedCars() {
        return loadedCars;
    }

    /** List of loaded cars */
    private List<Car> loadedCars = new ArrayList<>();

    public void lowerRamp() {
        cargo.lowerRamp(getCurrentSpeed());
    }

    public void raiseRamp() {
        cargo.raiseRamp();
    }

    /** @param c is the car to be loaded */
    public void loadCar(Car c) {
        cargo.loadCar(c, loadedCars, getPosition(), MAX_CARS, MAX_DISTANCE);
    }

    public void unloadCar() {
        cargo.unloadCar(loadedCars, getPosition());
    }

    /** How much the boat can accelerate */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.02;
    }

    /** Sets currentSpeed */
    @Override
    public void startEngine(){
        if (cargo.isUp()) {
            setCurrentSpeed(0.1);
        }
    }
}
