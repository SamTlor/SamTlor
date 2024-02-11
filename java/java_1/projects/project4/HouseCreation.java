/*
 *
 * HouseCreation.java
 *
 * This program creates a class called House and then creates multiple House objects. then it uses a couple different methods to
 * search through the house objects
 *
 * Sam Taylor
 * 4/1/2021
 * CMSC 255
 *
 */

package projects;

public class HouseCreation {
    public static void main(String[] args){
        //all of the objects that will be used for the methods later
        House test1 = new House("304 Oak Ave", 2634.23, 90456.78, 6.4);
        House test2 = new House("209 Main Dr", 2434.67, 345678.23, 7.3);
        House test3 = new House();

        //calling the setter methods for test3
        test3.setLocation("27 River St");
        test3.setSquareFootage(2790.53);
        test3.setPrice(892274.9);
        test3.setDisToCenter(1.9);

        //create an array for the eventual return array
        House[] var = {test1, test2, test3};
        House[] returnArray = findHomes(var, true, 2500, "sqFootage");

        //print out the result from findHomes()
        for(int i = 0; i < returnArray.length; i++){
            if (returnArray[i] != null) {
                System.out.println(returnArray[i]);
            }
        }
    }

    public static House[] findHomes(House[] houses, boolean isOver, double aValue, String searchCriteria){
        House[] ending = new House[houses.length];          //initialize final return array

        double[] holding = new double[houses.length];       //place to store just the numbers that will be searched
        switch(searchCriteria) {                            //set the type of search to go do
            case "sqFootage":
                for (int i = 0; i < houses.length; i++) {
                    holding[i] = houses[i].getSquareFootage();
                }
                break;
            case "price":
                for (int i = 0; i < houses.length; i++) {
                    holding[i] = houses[i].getPrice();
                }
                break;
            case "distance":
                for (int i = 0; i < houses.length; i++) {
                    holding[i] = houses[i].getDisToCenter();
                }
                break;
        }

        int endingCounter = 0;                          //I don't know how many numbers will pass the search
        if (isOver){                                    //over or under
            for (int i = 0; i < holding.length; i++){   //go through the numbers that i've already gotten
                if(holding[i] > aValue){                //if its over aValue
                    ending[endingCounter] = houses[i];  //add it to ending
                    endingCounter++;                    //because I made this before we learned about ArrayList
                }
            }
        } else {                                        //the bizarro over
            for (int i = 0; i < holding.length; i++){
                if(holding[i] <= aValue){
                    ending[endingCounter] = houses[i];
                    endingCounter++;
                }
            }
        }
        House[] real_ending = new House[endingCounter]; //this is ugly and very bad
        for(int i = 0; i < endingCounter; i++){         //makes sure the final return array has the right
            real_ending[i] = ending[i];                 //amount of elements
        }
        return real_ending;
    }

    public static void displayHouses(House[] houses){
        for (House i: houses){                          //#for i in houses:
            System.out.println(i.toString());           //#    print(i.method)
        }
    }
}

