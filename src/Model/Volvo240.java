package Model;

import java.awt.*;
import java.awt.geom.Point2D;

public class Volvo240 extends Car {

    /** Volvo speed multiplier */
    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(4, 100, Color.black, "Model.Volvo240", new Point2D.Double(1,1));
        stopEngine();
    }

    /** How much the car can accelerate */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
