package projects;

public class House{
    //all of the instance variables. private not set to static
    private String location;
    private double squareFootage;
    private double price;
    private double disToCenter;

    //all of the setters
    public void setLocation(String newLocation){
        location = newLocation;
    }
    public void setSquareFootage(double newSquareFootage){
        squareFootage = newSquareFootage;
    }
    public void setPrice(double newPrice){
        price = newPrice;
    }
    public void setDisToCenter(double newDisToCenter){
        disToCenter = newDisToCenter;
    }

    //all of the getters
    public String getLocation(){
        return location;
    }
    public double getSquareFootage(){
        return squareFootage;
    }
    public double getPrice(){
        return price;
    }
    public double getDisToCenter(){
        return disToCenter;
    }

    //parameterized constructor
    public House(String theLocation, double theSquareFootage, double thePrice, double theDisToCenter){
        this.location = theLocation;
        this.squareFootage = theSquareFootage;
        this.price = thePrice;
        this.disToCenter = theDisToCenter;
    }
    //no-arg constructor
    public House(){
        this("", 0,0,0);
    }

    //return string
    public String toString(){
        return(location + " " + squareFootage + " " + price + " " + disToCenter);
    }
}
