package Model;

import java.awt.*;
import java.awt.geom.Point2D;

public class Saab95 extends Car {

    /** Saab speed multiplier, can be set on/off */
    private boolean turboOn;

    public Saab95(){
        super(2, 125, Color.red, "Model.Saab95", new Point2D.Double(1,100));
        turboOn = false;
        stopEngine();
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    /** How much the car can accelerate */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
