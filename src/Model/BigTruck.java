package Model;

import java.lang.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class BigTruck extends Scania {

    /** Constructor */
    BigTruck() {
        super();
    }

    private Cargo cargo = new Cargo();

    /** Max amount of cars stored */
    private static final int MAX_CARS = 10;

    /** Max distance from ramp */
    private static final double MAX_DISTANCE = 1.0;

    /** Stack of loaded cars */
    private Deque<Car> carStack = new ArrayDeque<>();

    public boolean getIsUp() {
        return cargo.isUp();
    }

    public void lowerRamp() {
        cargo.lowerRamp(getCurrentSpeed());
    }

    public void raiseRamp() {
        cargo.raiseRamp();
    }

    public void loadCar(Car c) {
        cargo.loadCar(c, carStack, getPosition(), MAX_CARS, MAX_DISTANCE);
    }

    public void unloadCar(Car c) {
        cargo.unloadCar(carStack, getPosition());
    }

    /** How much the truck can accelerate */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.05;
    }

    /** Sets currentSpeed */
    @Override
    public void startEngine(){
        if (cargo.isUp()) {
            setCurrentSpeed(0.1);
        }
    }
}
