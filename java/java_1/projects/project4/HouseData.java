/*
 *
 * HouseData.java
 *
 * This program prints the results of different functions that all take arrays as parameters
 *
 * Sam Taylor
 * 3/17/2021
 * CMSC 255
 *
 */

package project4;

import java.util.Scanner;
import java.util.Arrays;

public class HouseData {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //These are the arrays i'll be using
        String[] locations = {"304 Oak Ave", "209 Main Dr", "27 River St", "65 Park Pl", "21 Yew Rd", "52 Franklin Dr", "100 Baltic Ave", "200 Maple Dr"};
        double[] square_footage = {2634.23, 2434.67, 2790.53, 5893.12, 3490, 2355.78, 7900, 4356.54};
        double[] assessed_price = {90456.78, 345678.23, 892274.90, 804392.43, 784211.47, 823757.02, 1453897.44, 342190.65};
        double[] distance = {6.4, 7.3, 1.9, 7.9, 1.2, 3.9, 7.5, 10.7};

        //This is me invoking all of the functions
        System.out.println("The average square footage is: " + String.format("%.2f", calcAvg(square_footage)));
        System.out.println("The average assessed price is: " + String.format("%.2f", calcAvg(assessed_price)));
        System.out.println("The highest assessed price is: " + String.format("%.2f", findHighest(assessed_price)));
        System.out.println("The lowest distance is: " + String.format("%.2f", findLowest(distance)));

        System.out.println("The highest three square footage houses are: ");
        String[] highestValues = findHighestValues(locations, square_footage);  //array variable to hold the result of the function
        for (int i = 0; i < highestValues.length; i++) {                        //go through that array
            System.out.println(findHighestValues(locations, square_footage)[i]);                               //number the results
        }

        System.out.println("The lowest three distances are: ");
        String[] bar = findLowestValues(locations, distance);                   //array variable to hold the result of the function
        for (int i = 0; i < bar.length; i++) {                                  //go through that array
            System.out.println(bar[i]);                                         //number the results
        }

        System.out.println("Enter the city:");
        String searchLocations = scan.nextLine();
        if (verifyHouseLocation(locations, searchLocations)){                   //invoke function
            System.out.println(searchLocations + " is a house in the array.");
        } else{
            System.out.println(searchLocations + " is not a house in the array.");
        }
    }

    public static double calcAvg(double[] values) {
        double sum = 0;
        int i;
        for (i = 0; i < values.length; i++) {
            sum += values[i];                                       //sum all the numbers in the array
        }
        return (sum / i);                                           //i = values.length
    }

    public static double findHighest(double[] values) {
        double high = values[0];                            //can't compare to an empty variable
        for (int i = 1; i < values.length; i++) {           // go through the values
            if (values[i] > high) {                         // compare each one to the current highest
                high = values[i];                           // set the new highest
            }
        }
        return (high);
    }

    public static double findLowest(double[] values) {
        double low = values[0];                             //can't compare to an empty variable
        for (int i = 1; i < values.length; i++) {           // go through the values
            if (values[i] < low) {                          // compare each one to the current lowest
                low = values[i];                            // set the new lowest
            }
        }
        return (low);
    }

    public static String[] findHighestValues(String[] locations, double[] values) {
        /*
        String[] ending = new String[3];                                        //final return value string array
        double[] copy = new double[values.length];                              //copy of "double values[]" string parameter

        System.arraycopy(values, 0, copy, 0, values.length);  // found on https://www.geeksforgeeks.org/system-arraycopy-in-java/
                                                                            // And also was suggested by intelliJ
        Arrays.sort(values);                                                //sorted original array string parameter

        int var = 0;                                                    //i'll need this later
        for(int j = values.length - 1; j >= values.length - 3; j--){    // j = starting at the end of the sorted array going down only three
            for (int k = 0; k < values.length; k++){                    // k = going through the copy
                if (values[j] == copy[k]){                              // to find the id of the column which will lead us to
                    ending[var] = locations[k];                         // the location street address string, appended to the final return array
                    var++;                                              // get the next number for the final array
                }
            }
        }
        return(ending);

         */

        String[] newLocation = new String[3];
        double max1 = values[0];
        double max2 = values[0];
        double max3 = values[0];
        int x = 0;
        int y = 0;
        int z = 0;
        for (int i = 0; i < values.length; i++){
            if(values[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = values[i];
                x = i;
            } else if (values[i] > max2){
                max3 = max2;
                max2 = values[i];
                y = i;
            } else if(values[i] > max3){
                max3 = values[i];
                z = i;
            }
        }
        newLocation[0] = locations[x];
        newLocation[1] = locations[y];
        newLocation[2] = locations[z];

        return newLocation;
    }

    public static String[] findLowestValues(String[] locations, double[] values) {
        String[] ending = new String[3];                                //final return value string array
        double[] copy = new double[values.length];                      //copy of "double values[]" string parameter

        System.arraycopy(values, 0, copy, 0, values.length);
        Arrays.sort(values);                                            //sorted original array string parameter

        int var = 0;                                                    // i'll need this later
        for(int j = 0; j < 3; j++){                                     // j = starting at the beginning of the sorted array going up only three
            for (int k = 0; k < values.length; k++){                    // k = going through the copy
                if (values[j] == copy[k]){                              // to find the id of the column which will lead us to
                    ending[var] = locations[k];                         // the location street address string, appended to the final return array
                    var++;                                              // get the next number for the final array
                }
            }
        }
        return(ending);
    }

    public static boolean verifyHouseLocation(String[] locations, String searchLocation) {
        for (String location : locations) {                         //go through the locations
            if (searchLocation.equals(location)) {                  //if the location is the same as the user's input
                return true;
            }
        }
        return false;                                               //"else"
    }
}