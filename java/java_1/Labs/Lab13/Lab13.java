/*
 *
 * Lab13.java
 *
 * This program takes two txt files as command line arguments and then uses a loop to find from the first txt file the
 * most and least goals scored, the names of the teams that got those goals respectively, and the average amount of
 * shots taken. Then it writes that information into the second txt file
 *
 * Sam Taylor
 * 4/21/2021
 * CMSC 255
 *
 */
package Labs.Lab13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab13 {
    public static void main(String[] args) {
        try {
            File inputFilePath = new File(args[0]);
            File outputFilePath = new File(args[1]);

            processFile(inputFilePath, outputFilePath);
        } catch (FileNotFoundException e){
            System.out.println("didn't work");
        }
    }

    public static void processFile(File inputFile, File outputFile) throws FileNotFoundException{
        Scanner scan = new Scanner(inputFile);

        String maxName = "";
        String minName = "";
        int maxGoals = 0;
        int minGoals = 99999;
        double average = 0;

        int i = 0;
        while(scan.hasNextLine()){
            String var = scan.nextLine();
            String[] line= var.split(",");

            if(Double.parseDouble(line[1]) > maxGoals){
                maxGoals = Integer.parseInt(line[1]);
                maxName = line[0];
            } else if(Double.parseDouble(line[1]) < minGoals){
                minGoals = Integer.parseInt(line[1]);
                minName = line[0];
            }
            average += Double.parseDouble(line[2]);
            i++;
        }
        scan.close();
        average /= i;

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(outputFile);
            writer.println("Maximum goals Scored: " + maxName + " " + maxGoals);
            writer.println("Minimum goals Scored: " + minName + " " + minGoals);
            writer.printf("Average shots per game: " + String.format("%.3f", average));
        } catch(FileNotFoundException e){
            System.out.println("didn't work");
        } finally {
            writer.close();
        }
    }
}
