package Labs.Lab14;
/*
 *
 * DaysPerMonth.java
 *
 * This program takes two command line arguments if they are given. If they aren't given the program asks the user to type
 * in string values that match the filepaths for a file to read and another file to write to. the program reads every
 * line of the input file and splits the line on "," then it reads the values it gets from splitting the line as ints.
 * it handles any exception if it comes up by writing to the output file what went wrong
 *
 * Sam Taylor
 * 4/28/2021
 * CMSC 255
 *
 */

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DaysPerMonth {
    public static void main(String[] args){
        if (args.length == 2) {                             //see if the amount of command line arguments is right
            File inputFile = new File(args[0]);
            File outputFile = new File(args[1]);
            processFile(inputFile, outputFile);
        } else {                                            //ask the user to make their own arguments
            Scanner scan = new Scanner(System.in);
            File inputFile = new File(scan.nextLine());
            File outputFile = new File(scan.nextLine());
            scan.close();

            processFile(inputFile, outputFile);
        }
    }

    public static void processFile(File inputFile, File outputFile){
        try {                                                           //for a FileNotFoundException
            Scanner scan = new Scanner(inputFile);                      //if inputFile is wrong FileNotFoundException
            PrintWriter writer = new PrintWriter(outputFile);           //if outputFile is wrong FileNotFoundException

            while(scan.hasNextLine()){
                String[] data = scan.nextLine().split(",");       //split each line on ,

                try{                                                    //try to parse the numbers
                    int mon = Integer.parseInt(data[0]);        //anything thats not an int gives NumberFormatException
                    int yr = Integer.parseInt(data[1]);

                    if(mon > 12 || mon < 1){                            //!(0 > mon > 12)
                        writer.println("Month must be between 1 and 12");
                    }
                    else if(yr < 0){                                    //neg year
                        writer.println("Year cannot be negative");
                    } else {                                            //no exceptions have happened
                        int days = getDays(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
                        writer.println("There are " + days + " days in this month.");
                    }
                } catch (NumberFormatException n) {
                    writer.println("Not an integer");
                }
            }
            scan.close();                                               //close everything and wrap up
            writer.close();
        } catch(FileNotFoundException e) {
            System.out.println("Bad File Name");
        }
    }

    /**
     * method to determine the days for the given month and year
     **/

    //import java.time.YearMonth
    //YearMonth obj = YearMonth.of(year, month);
    //return obj.lengthOfMonth();

    private static int getDays(int mon, int yr) {
        int numDays = 0;

        switch(mon) {
            case 2: // February
                numDays = 28;
                if (yr % 4 == 0) {
                    numDays = 29;
                    if (yr % 100 == 0 && yr % 400 != 0) {
                        numDays = 28;
                    }
                }
                break;

            case 4:   // April
            case 9:   // September
            case 6:   // June
            case 11:  // November
                numDays = 30;
                break;

            default: numDays = 31;  // all the rest
        }
        return numDays;
    }
}
