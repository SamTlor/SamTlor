/*
 *
 * ArtAnalysis.java
 *
 * This program reads data from a text file and parses it. it has methods to find the highest
 * value in the lines and the average etc
 *
 * Sam Taylor
 * 5/5/2021
 * CMSC 255
 *
 */
package projects.project7;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ArtAnalysis {
    public static void main(String[] args){
        try{//good data. takes in args from command line and works
            File input = new File(args[0]);
            File output = new File(args[1]);

            myMethod(input, output);
        } catch (FileNotFoundException e){//Bad data. creates scanner so user will enter filepath
            System.out.println("Incorrect input filename");
            Scanner scan = new Scanner(System.in);

            File input = new File(scan.nextLine());
            File output = new File(scan.nextLine());
            scan.close();

            try {
                myMethod(input, output);
                System.out.println("Input File correct");
            } catch (FileNotFoundException a){              //if the output file is bad. This will literally never run
                Scanner newScan = new Scanner(System.in);

                File newOutput = new File(newScan.nextLine());
                newScan.close();
                try {
                    myMethod(input, newOutput);
                } catch (FileNotFoundException q){
                    System.out.println("hey hey");
                }
            }
        }
    }

    public static void myMethod(File input, File output) throws FileNotFoundException {
        //vars that will be used in the output section
        //readFile, parseData, calcValueAvg, findHighValue, findHighestArtByValue, findArt
        ArrayList<String> artString = readFile(input);
        ArrayList<Art> parsed = parseData(artString);
        double ResultCalcValueAvg = calcValueAvg(parsed);
        double ResultFindHighValue = findHighValue(parsed);
        ArrayList<Art> ResultFindHighestArtByValue = findHighestArtByValue(parsed, ResultCalcValueAvg);
        boolean ResultFindArt = findArt(parsed, parsed.get(6));


        try{//output
            PrintWriter writer = new PrintWriter(output);

            writeOutData("The average value is: ", ResultCalcValueAvg, writer);
            writeOutData("The highest value is: ", ResultFindHighValue, writer);
            writeOutData("The art above the average value are: ", ResultFindHighestArtByValue, writer);
            writeOutData("Is David by Donatello in the data? ", ResultFindArt, writer);

            writer.close();
        } catch(FileNotFoundException e){
            System.out.println("Incorrect output filename");
            throw new FileNotFoundException();
        }
    }

    public static ArrayList<String> readFile(File input) throws FileNotFoundException{
        Scanner scan = new Scanner(input);                  //scanner using input file
        ArrayList<String> lines = new ArrayList<String>();  //ending
        while (scan.hasNextLine()){                         //while file has lines
            lines.add(scan.nextLine());                     //add to ending
        }
        return lines;                                       //end
    }

    public static ArrayList<Art> parseData(ArrayList<String> lines){
        ArrayList<Art> ending = new ArrayList<Art>();           //ending
        for (String i : lines){
            String[] temp = i.toString().split("\t");       //break up line to the values i want
            double theValue;                                      //set this first because the scope is set to { }
            try{
                theValue = Double.parseDouble(temp[2]);           //parse the number
                if(theValue < 0){                                 //self explanatory
                    theValue = 0;
                }
            } catch (NumberFormatException e){                    //if parsing the number fails
                theValue = 0;
            }
            ending.add(new Art(temp[0], temp[1], theValue, temp[3]));      //add to ending
        }
        return ending;                                                     //end
    }

    public static double calcValueAvg(ArrayList<Art> artworks){
        double avg = 0;                                             //to add to later
        int i = 0;                                                  //to divide by later
        for(; i < artworks.size(); i++){
            avg += artworks.get(i).getValue();                      //add to avg now
        }
        return avg / i;                                             //divide by i now
    }

    public static double findHighValue(ArrayList<Art> artworks){
        double highest = artworks.get(0).getValue();                      //first value in the list
        for (int i = 1; i < artworks.size(); i++){                        //everything except the first one
            if (artworks.get(i).getValue() > highest){                    //if its bigger than the highest
                highest = artworks.get(i).getValue();                     //it is now the highest
            }
        }
        return highest;                                                   //return the highest
    }

    public static ArrayList<Art> findHighestArtByValue(ArrayList<Art> artworks, double avg){
        ArrayList<Art> ending = new ArrayList<Art>();                      //ending
        for(Art i : artworks){                                             //go through the list
            if(i.getValue() > avg){                                        //if its number is bigger than the param
                ending.add(i);                                             //add it to the ending
            }
        }
        return ending;                                                     //end
    }

    public static boolean findArt(ArrayList<Art> artworks, Art art){
        for(Art i : artworks){                                              //go through the list
            if(art.equals(i)){                                              //if they're the same
                return true;                                                //true
            }
        }
        return false;                                                       //if true hasn't been returned yet
    }

    public static void writeOutData(String outputMessage, ArrayList<Art> artworks, PrintWriter out){
        String ending = outputMessage + "\n";                               //every line has a blank line underneath it
        for(Art i : artworks){                                              //go through the list
            ending += "\t" + i.toString() + "\n";                           //each one needs a tab in front?
        }
        out.println(ending);                                                //write to file
    }

    public static void writeOutData(String outputMessage, double value, PrintWriter out){
        out.printf(outputMessage + "%.2f\n\n", value);           //one \n for the first line. one for the line below it
    }

    public static void writeOutData(String outputMessage, boolean value, PrintWriter out){
        out.println(outputMessage + value + "\n");                          //write the thing and add a blank line
    }
}