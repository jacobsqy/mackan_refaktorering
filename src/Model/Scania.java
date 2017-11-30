package Model;

import java.awt.*;
import java.awt.geom.Point2D;

public class Scania extends Car {

    /** Constructor */
    public Scania() {
        super(2, 500, Color.YELLOW, "SCANIA666", new Point2D.Double(1,200));
        this.trailerAngle = 70;
    }

    /** The trailers angle */
    private int trailerAngle;

    /** @return trailerAngle */
    public int getTrailerAngle() {
        return trailerAngle;
    }

    /**  Increases trailer angle */
    public void raiseTrailer() {
        trailerAngle = Math.min(trailerAngle + 1, 70);
    }

    /**  Decreases trailer angle */
    public void lowerTrailer() {
        if (getCurrentSpeed() == 0) {
            trailerAngle = Math.max(trailerAngle - 1, 0);
        }
    }

    /**  Resets trailer angle */
    public void resetTrailer() {
        while (trailerAngle < 70) {
            raiseTrailer();
        }
    }

    /** How much the truck can accelerate */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.002;
    }

    /** Sets currentSpeed */
    @Override
    public void startEngine(){
        if (trailerAngle == 70) {
            setCurrentSpeed(0.1);
        }
    }
}
