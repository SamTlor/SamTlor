/*
 *
 * Fan.java
 *
 * This program defines a class called Fan that has four different types of private instance variables
 * it also has methods to set and methods to get those instance variables. it has a parameterized and a
 * no-arg constructor. Finally, it has a method that describes the class
 *
 * Sam Taylor
 * 3/29/2021
 * CMSC 255
 *
 */

package Labs.Lab10;

public class Fan {
    // set speeds for fan
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    // set up default values
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    // set up the setter methods
    public void setSpeed(int newSpeed){
        speed = newSpeed;
    }
    public void setOn(boolean newOn){
        on = newOn;
    }
    public void setRadius(double newRadius){
        radius = newRadius;
    }
    public void setColor(String newColor){
        color = newColor;
    }

    // set up the getter methods
    public int getSpeed(){
        return speed;
    }
    public boolean isOn(){
        return on;
    }
    public double getRadius(){
        return radius;
    }
    public String getColor(){
        return color;
    }

    // parameterized constructor
    public Fan(int theSpeed, boolean theOn, double theRadius, String theColor){
        this.speed = theSpeed;
        this.on = theOn;
        this.radius = theRadius;
        this.color = theColor;
    }
    // no arg constructor
    public Fan(){
        this(Fan.SLOW, false, 5, "blue");
    }

    // final descriptor method
    public String toString(){
        if (on){
            return ("fan is " + speed + ", " + color + ", and size " + radius);
        } else {
            return "fan is off";
        }
    }
}