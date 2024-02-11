/*
 *
 * Building.java
 *
 * This program defines a building class that is a subclass of the Apartment class. It has several private instance
 * variables and an ArrayList that stores Apartment objects. it has a default and a parameterized constructor and
 * getters and setters for all of the instance variables. It also has a method to add to the ArrayList. Finally it has
 * a toString method that outputs information about the building and calls the Apartment toString method to output
 * information about all of the apartments in the building
 *
 * Sam Taylor
 * 4/22/2021
 * CMSC 255
 *
 */

package projects.project6;

import java.util.ArrayList;

public class Building extends Apartment{
    //instance variables
    private String location;
    private String owner;
    private String contactPhone;
    private int maxNumberOfUnits;
    private ArrayList<Apartment> apartments = new ArrayList<Apartment>();

    //constructors
    public Building(String aLocation, String anOwner, String aContactPhone, int aMaxNumberOfUnits){
        location = aLocation;
        owner = anOwner;
        contactPhone = aContactPhone;
        maxNumberOfUnits = aMaxNumberOfUnits;
    }
    public Building(){
        location = "";
        owner = "";
        contactPhone = "";
        maxNumberOfUnits = 0;
    }

    //getters and setters
    public String getLocation(){
        return location;
    }
    public void setLocation(String theLocation){
        location = theLocation;
    }

    public String getOwner(){
        return owner;
    }
    public void setOwner(String theOwner){
        owner = theOwner;
    }

    public String getContactPhone(){
        return contactPhone;
    }
    public void setContactPhone(String theContactPhone){
        contactPhone = theContactPhone;
    }

    public int getMaxNumberOfUnits(){
        return maxNumberOfUnits;
    }
    public void setMaxNumberOfUnits(int theMaxNumberOfUnits){
        maxNumberOfUnits = theMaxNumberOfUnits;
    }

    public void addApartment(Apartment theApartment){
        apartments.add(theApartment);
    }
    public int getNumApartments(){
        return apartments.size();
    }
    public ArrayList<Apartment> getApartments(){
        return apartments;
    }
    public String toString(){
        //building info
        String end = location + "\n" + owner + "\n" + contactPhone + "\n" + maxNumberOfUnits + "\nApartments:\n";

        //apartment info
        for (int i = 0; i < apartments.size(); i++){
            end += apartments.get(i).toString();
        }
        return end;
    }
}