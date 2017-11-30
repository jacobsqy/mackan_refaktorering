import Model.BigFactory;
import Model.BigTruck;
import org.junit.Test;

import static org.junit.Assert.*;

public class BigTruckTest {
    @Test
    public void lowerRamp() throws Exception {
        BigTruck truck = (BigTruck) BigFactory.createBigTruck();
        truck.raiseRamp();
        truck.lowerRamp();
        assertTrue(!truck.getIsUp());
    }

    @Test
    public void raiseRamp() throws Exception {
        BigTruck truck = (BigTruck) BigFactory.createBigTruck();
        truck.lowerRamp();
        truck.raiseRamp();
        assertTrue(truck.getIsUp());
    }
}