import Model.Scania;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScaniaTest {
    @Test
    public void raiseTrailer() throws Exception {
        Scania scania = new Scania();
        scania.stopEngine();
        scania.raiseTrailer();
        assertTrue(scania.getTrailerAngle() > 0);
    }

    @Test
    public void lowerTrailer() throws Exception {
        Scania scania = new Scania();
        scania.stopEngine();
        scania.raiseTrailer();
        scania.lowerTrailer();
        assertTrue(scania.getTrailerAngle() == 0);

        scania.lowerTrailer();
        assertTrue(scania.getTrailerAngle() == 0);
    }

    @Test
    public void resetTrailer() throws Exception {
        Scania scania = new Scania();
        for (int i = 0; i < 50; i++) {
            scania.raiseTrailer();
        }
        scania.resetTrailer();

        assertTrue(scania.getTrailerAngle() == 0);
    }

    @Test
    public void speedFactor() throws Exception {
        Scania scania = new Scania();
        assertTrue(scania.speedFactor() == 1);
    }

}