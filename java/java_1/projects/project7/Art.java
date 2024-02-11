/*
 *
 * Art.java
 *
 * This program creates an Art class that will be used in ArtAnalysis.java. It has constructors, getters, setters, a
 * toString method, and an equals method that returns if any Object has the same name and creator as the Art object
 *
 * Sam Taylor
 * 5/5/2021
 * CMSC 255
 *
 */

package projects.project7;

public class Art {
    //instance vars
    private String name;
    private String creator;
    private double value;
    private String location;

    //constructors
    public Art(){
        name = "";
        creator = "";
        value = 0;
        location = "";
    }
    public Art(String aName, String aCreator, double aValue, String aLocation){
        name = aName;
        creator = aCreator;
        value = aValue;
        location = aLocation;
    }

    //getters and setters
    public String getName(){
        return name;
    }
    public void setName(String aName){
        name = aName;
    }
    public String getCreator(){
        return creator;
    }
    public void setCreator(String aCreator){
        creator = aCreator;
    }
    public double getValue(){
        return value;
    }
    public void setValue(double aValue){
        value = aValue;
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(String aLocation){
        location = aLocation;
    }

    //instance vars plus spaces
    public String toString(){
        return name + " " + creator + " " + value + " " + location;
    }
    public boolean equals(Object obj){
        if (obj == null){                   //makes sure obj isn't null
            return false;
        } else if (obj == this) {           //makes sure obj isn't the same as this
            return true;
        } else if (obj instanceof Art){     //makes sure obj is an art object
            Art anArt = (Art) obj;          //makes sure obj can be compared to this

            // compareTo is the only thing that works == makes symmetric error
            return ((anArt.name.compareTo(this.name) == 0) && (anArt.creator.compareTo(this.creator) == 0));
        } else {                            //if true hasn't been returned yet
            return false;
        }
    }
}