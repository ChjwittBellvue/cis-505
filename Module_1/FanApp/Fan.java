/*
 * Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_1.FanApp;

public class Fan {
    // Constants
    static int STOPPED = 0;
    static int SLOW = 1;
    static int MEDIUM = 2;
    static int FAST = 3;

    // Variables
    private int speed;
    private boolean fanTurnedOn;
    private double radius;
    private String color;

    // Constructors
    public Fan() {
        this.speed = STOPPED;
        this.fanTurnedOn = false;
        this.radius = 6;
        this.color = "White";
    }

    public Fan(int speed, boolean fanTurnedOn, double radius, String color) {
        this.speed = speed;
        this.fanTurnedOn = fanTurnedOn;
        this.radius = radius;
        this.color = color;
    }

    // Mutators
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isFanTurnedOn() {
        return fanTurnedOn;
    }

    public void setFanTurnedOn(boolean fanTurnedOn) {
        this.fanTurnedOn = fanTurnedOn;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /*
     * toString override
     * 
     * This method will determine the status of the fan and update the toString to
     * reflect whether it is on or off and return a different string based on that
     * data.
     */
    @Override
    public String toString() {
        if (fanTurnedOn) {
            return "The fan speed is set to " + speed
                    + " with a color of " + color
                    + " and a radius of " + radius + "."
                    + System.lineSeparator();
        } else {
            return "The fan is " + color
                    + " with a radius of " + radius
                    + " and the fan is off."
                    + System.lineSeparator();
        }
    }
}
