/*
 *
 * Card.java
 *
 * This program defines a superclass named Card and several subclasses for it. Every class contains a default
 * constructor, a parameterized constructor, and a toString method that prints out the values of the instance variables
 * in the class
 *
 * Sam Taylor
 * 4/14/2021
 * CMSC 255
 *
 */

package Labs.Lab12;

public class Card {
    private String name;

    public Card(){
        name = "";
    }
    public Card(String aName){
        name = aName;
    }
    public String toString(){
        return ("Card Holder: " + name);
    }
}
