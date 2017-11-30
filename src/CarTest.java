import Model.Car;
import Model.Saab95;
import Model.Volvo240;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class CarTest {
    @Test
    public void startEngine() throws Exception {
        Car saab95 = new Saab95();
        saab95.startEngine();
        assertTrue(saab95.getCurrentSpeed() > 0);
    }

    @Test
    public void stopEngine() throws Exception {
        Car volvo240 = new Volvo240();
        volvo240.stopEngine();
        assertTrue(volvo240.getCurrentSpeed() == 0);
    }

    @Test
    public void speedFactor() throws Exception {
        Car volvo240 = new Volvo240();
        assertTrue(volvo240.speedFactor() == 1.25);
    }

    @Test
    public void incrementSpeed() throws Exception {
        Car saab95 = new Saab95();
        saab95.startEngine();
        saab95.gas(0);
        assertTrue(saab95.getCurrentSpeed() == 0.1);
        saab95.gas(1);
        assertTrue(saab95.getCurrentSpeed() == 1.35);
    }

    @Test
    public void decrementSpeed() throws Exception {
        Car saab95 = new Saab95();
        saab95.startEngine();
        saab95.gas(1);
        saab95.brake(1);
        assertTrue(saab95.getCurrentSpeed() >= 0.1 && saab95.getCurrentSpeed() < 0.11);

        saab95.gas(1);
        saab95.brake(0);
        assertTrue(saab95.getCurrentSpeed() != 0.1);
    }

    @Test
    public void gas() throws Exception {
        Car volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.gas(1);
        assertTrue(volvo240.getCurrentSpeed() == 1.35);
    }

    @Test
    public void brake() throws Exception {
        Car volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.gas(1);
        volvo240.brake(1);
        assertTrue(volvo240.getCurrentSpeed() >= 0.1 && volvo240.getCurrentSpeed() < 0.11);
    }

    @Test
    public void move() throws Exception {
        Car c = new Volvo240();
        Point2D.Double old_pos = new Point2D.Double(c.getPosition().x, c.getPosition().y);
        c.startEngine();
        c.move();
        assertTrue(old_pos != c.getPosition());
    }

    @Test
    public void turnLeft() throws Exception {
        Car c = new Volvo240();
        c.turnLeft();
    }

    @Test
    public void turnRight() throws Exception {
        Car c = new Volvo240();
        c.turnRight();
    }
}