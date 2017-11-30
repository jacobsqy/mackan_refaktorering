package Model;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Vehicle implements Movable {

    /** Superconstructor
     * @param enginePower is the power of the engine
     * @param color is the color of the car
     * @param modelName is the model of the car
     * @param position is the vehicles current position in the world
     */
    public Vehicle(double enginePower, Color color, String modelName, Point2D.Double position) {
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.position = position;
    }

    public Vehicle() {}

    /** Engine power of the car */
    private double enginePower;

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    /** The current speed of the car */
    private double currentSpeed;

    /** Color of the car */
    private Color color;

    /** The car model name */
    private String modelName;

    /** The cars position in the world */
    private Point2D.Double position;

    /** Directions */
    private enum Directions {NORTH, SOUTH, WEST, EAST}

    public Directions getDir() {
        return dir;
    }

    /** Variable holding the direction */
    private Directions dir = Directions.EAST;

    /** Current location */
    private double[] currentP = {0,0};

    /** @return position */
    public Point2D.Double getPosition() { return position; }

    public void setPosition(Point2D.Double position) {
        this.position = position;
    }

    /** @return enginePower */
    public double getEnginePower(){
        return enginePower;
    }

    /** @return currentSpeed */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /** @return color */
    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    /** Sets currentSpeed */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /** Sets currentSpeed */
    public void stopEngine(){
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    /** Sets currentSpeed depending on speedFactor and amount of gas
     * @param amount is a multiplier */
    private void incrementSpeed(double amount) {
        if (currentSpeed > 0) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        }
    }

    /** Sets currentSpeed depending on speedFactor and amount of break
     * @param amount is a multiplier */
    private void decrementSpeed(double amount) {
        if (currentSpeed >= 0.1) {
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0.1);
        }
    }

    /** @param amount decides how much we accelerate the vehicle*/
    public void gas(double amount) {
        if (amount >= 0 || amount <= 1) {
            incrementSpeed(amount);
        }
    }

    /** @param amount decides how much we retard the vehicle*/
    public void brake(double amount) {
        if (amount >= 0 || amount <= 1) {
            decrementSpeed(amount);
        }
    }

    /** Moves the vehicle in the current direction */
    public void move() {
        switch (dir){
            case NORTH:
                position.setLocation(getPosition().x, getPosition().y + currentSpeed);
                //setPosition(new Point2D.Double(getPosition().x, getPosition().y + currentSpeed));
                break;
            case SOUTH:
                position.setLocation(getPosition().x, getPosition().y - currentSpeed);
                //setPosition(new Point2D.Double(getPosition().x, getPosition().y - currentSpeed));
                break;
            case EAST:
                position.setLocation(getPosition().x + currentSpeed, getPosition().y);
                //setPosition(new Point2D.Double(getPosition().x + currentSpeed, getPosition().y));
                break;
            case WEST:
                position.setLocation(getPosition().x - currentSpeed, getPosition().y);
                //setPosition(new Point2D.Double(getPosition().x - currentSpeed, getPosition().y));
                break;
            default:
                break;
        }
    }

    /** Logic for turning vehicle left */
    public void turnLeft() {
        switch (dir){
            case NORTH:
                dir = Directions.WEST;
                break;
            case SOUTH:
                dir = Directions.EAST;
                break;
            case EAST:
                dir = Directions.NORTH;
                break;
            case WEST:
                dir = Directions.SOUTH;
                break;
            default:
                break;
        }
    }

    /** Logic for turning vehicle right */
    public void turnRight() {
        switch (dir){
            case NORTH:
                dir = Directions.EAST;
                break;
            case SOUTH:
                dir = Directions.WEST;
                break;
            case EAST:
                dir = Directions.SOUTH;
                break;
            case WEST:
                dir = Directions.NORTH;
                break;
            default:
                break;
        }
    }



    private boolean hit(int maxHeight, int maxWidth, int x, int y, Vehicle car) {
        return y >= maxHeight - 60 || y < 0 || x >= maxWidth - 120 - car.getCurrentSpeed()
                || x < 0 + car.getCurrentSpeed();
    }

    public void hitBoundaries(int maxHeight, int maxWidth, int x, int y, Vehicle car) {
        if (hit(maxHeight, maxWidth, x, y, car)) {
            car.stopEngine();
            car.turnLeft();
            car.turnLeft();
            car.startEngine();
        }
    }
}
