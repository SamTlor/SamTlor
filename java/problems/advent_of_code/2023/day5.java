import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class day5 {
    public static void main(String[] args) {
   
        // read and store the input line by line in a list
        List<String> seeds = new ArrayList<>();
        List<String> input = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("day8.txt"))) {

            instuctions = br.readLine();
            br.readLine();                              //ignore space between line 1 and 3

            String line;
            while ((line = br.readLine()) != null) {
                
                // add the countPairs to the line so that you don't need to look it up later
                input.add(line);
            }
        } catch (IOException e) {}

        System.out.println("sldkjfsld");
    }

    static class The_Range {
        
        // instance variables
        private int start;
        private int endin;

        // constructors
        public The_Range(int theStart, int theEndin) {
            this.start = theStart;
            this.endin = theEndin;
        }

        // getters 
        public int getStart() {
            return start;
        }

        public int getEndin() {
            return endin;
        }
    }   
}