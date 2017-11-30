package Model;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Car extends Vehicle {

    public Car(int nrDoors, double enginePower, Color color, String modelName, Point2D.Double position) {
        super(enginePower, color, modelName, position);
        this.nrDoors = nrDoors;
    }

    /** Number of doors on the car */
    private int nrDoors;

    /** @return nrDoors */
    public int getNrDoors(){
        return nrDoors;
    }

    /** car is on trailer/boat */
    private boolean loaded = false;

    /** @return loaded */
    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    /** Sets currentSpeed */
    @Override
    public void startEngine(){
        if (!loaded) { setCurrentSpeed(0.1); }
    }

}
