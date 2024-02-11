/*
 *
 * Apartment.java
 *
 * This program defines a class called Apartment with several instance variables, three of them being enums. it has
 * parameterized and default constructors and getters and setters for each instance variable. It also has a toString
 * method that outputs information about the apartment
 *
 * Sam Taylor
 * 4/22/2021
 * CMSC 255
 *
 */

package projects.project6;

public class Apartment {
    //instance variables
    private int locationNumber;
    private double squareFootage;
    private double price;
    private Bedrooms bedrooms;
    private Baths baths;
    private Status status;

    //constructors
    public Apartment(int aLocationNumber, double aSquareFootage, double aPrice, Bedrooms aBedrooms, Baths aBaths, Status aStatus){
        locationNumber = aLocationNumber;
        squareFootage = aSquareFootage;
        price = aPrice;
        bedrooms = aBedrooms;
        baths = aBaths;
        status = aStatus;
    }
    public Apartment(){
        locationNumber = 1;
        squareFootage = 500.00;
        price = 400.00;
        bedrooms = Bedrooms.values()[0];
        baths = Baths.values()[0];
        status = Status.values()[0];
    }

    //getters and setters
    public int getLocationNumber(){
        return locationNumber;
    }
    public void setLocationNumber(int aLocationNumber){
        locationNumber = aLocationNumber;
    }

    public double getSquareFootage(){
        return squareFootage;
    }
    public void setSquareFootage(double aSquareFootage){
        squareFootage = aSquareFootage;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double aPrice){
        price = aPrice;
    }

    public Bedrooms getBedrooms(){
        return bedrooms;
    }
    public void setBedrooms(Bedrooms aBedrooms){
        bedrooms = aBedrooms;
    }
    
    public Baths getBaths(){
        return baths;
    }
    public void setBaths(Baths aBath_Nums){
        baths = aBath_Nums;
    }

    public Status getStatus(){
        return status;
    }
    public void setStatus(Status aFilled){
        status = aFilled;
    }

    //apartment info
    public String toString(){
        return ("\n\t" + locationNumber + "\n\t" + squareFootage + "\n\t" + price + "\n\t" + bedrooms + "\n\t" + baths + "\n\t" + status + "\n");
    }
}