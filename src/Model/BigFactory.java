package Model;

public class BigFactory {
    public static Vehicle createBigTruck() {
        return new BigTruck();
    }

    public static Vehicle createBoat() {
        return new Boat();
    }

    public static Vehicle createSaab95() {
        return new Saab95();
    }

    public static Vehicle createVolvo240() {
        return new Volvo240();
    }

    public static Vehicle createScania() {
        return new Scania();
    }
}
