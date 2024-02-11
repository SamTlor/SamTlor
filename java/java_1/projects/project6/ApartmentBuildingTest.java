/*
 *
 * ApartmentBuildingTest.java
 *
 * This program creates two building objects and populates them with Apartment objects. Then it calls the buildings'
 * toString() method and crashes. But if you comment out the addApartment() method calls it works with the default constructor
 *
 * Sam Taylor
 * 4/15/2021
 * CMSC 255
 *
 */

package projects.project6;

public class ApartmentBuildingTest {
    public static void main(String[] args) {
        //creating two Building objects with the values from the project 06 instructions
        Building TallHouse1 = new Building("456 Granite Lane", "Caroline Budwell", "804-555-1212", 20);
        Building TallHouse2 = new Building("129 Resolve St", "Zach Whitten", "804-555-2121", 100);

        //two Apartment objects that won't work
        Apartment LotsOfRooms1 = new Apartment(101, 634.52, 754.99, Bedrooms.TWO_BEDROOM, Baths.TWO, Status.OCCUPIED);
        Apartment LotsOfRooms2 = new Apartment(42,1340.05,3000.50,Bedrooms.THREE_BEDROOM,Baths.TWO,Status.OCCUPIED);

        //trying to add the apartments to the building
        TallHouse1.addApartment(LotsOfRooms1);
        TallHouse2.addApartment(LotsOfRooms2);

        //the toStrings for the building objects
        System.out.println(TallHouse1.toString());
        System.out.println(TallHouse2.toString());
    }
}
