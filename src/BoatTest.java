import Model.Boat;
import Model.Car;
import Model.Volvo240;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoatTest {
    @Test
    public void loadCar() throws Exception {
        Car volvo = new Volvo240();
        Boat b = new Boat();
        b.lowerRamp();
        b.loadCar(volvo);
        assertTrue(b.getPosition() == volvo.getPosition());
    }

    @Test
    public void unloadCar() throws Exception {
        Car volvo = new Volvo240();
        Boat b = new Boat();
        b.lowerRamp();
        b.loadCar(volvo);

        b.raiseRamp();
        b.startEngine();
        b.move();

        b.stopEngine();
        b.lowerRamp();
        b.unloadCar();

        assertTrue(b.getLoadedCars().size() == 0);
    }

}