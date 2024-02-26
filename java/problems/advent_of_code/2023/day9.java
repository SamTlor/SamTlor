import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day9 {

    
    public static void main(String[] args) {

        List<String> input = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("day9.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                
                // add the countPairs to the line so that you don't need to look it up later
                input.add(line);
            }
        } catch (IOException e) {}


        System.out.println(part1(input));
        System.out.println(part2(input));
        
    }



    static int part1(List<String> input){

        int ans = 0; 

        for (String line : input){

            String[] numbersAsStrings = line.split("\\s+");
            int[] numbers = new int[numbersAsStrings.length];
            for (int i = 0; i < numbersAsStrings.length; i++) {
                numbers[i] = Integer.parseInt(numbersAsStrings[i]);
            }

            
            ans += numbers[numbers.length - 1] + helper_function(numbers);
        }

        

        return ans;
    }



    static int helper_function(int[] numbers){

        int[] next_line = new int[numbers.length - 1];
        for (int i = 0; i < numbers.length - 1; i++){
            next_line[i] = numbers[i + 1] - numbers[i];
        }


        // int foo = helper_function(next_line);
        if (all_same(next_line)) {
            return next_line[next_line.length - 1];
        } else {
            // System.out.println(next_line[next_line.length - 1] + helper_function(next_line));
            return next_line[next_line.length - 1] + helper_function(next_line);
        }



    }



    static boolean all_same(int[] next_line){
        int first = next_line[0];
        for (int i = 1; i < next_line.length; i++){
            if (next_line[i] != first){
                return false;
            }
        }

        return true;
    }








    static int part2(List<String> input){

        int ans = 0;

        for (String line : input){

            String[] numbersAsStrings = line.split("\\s+");
            int[] numbers = new int[numbersAsStrings.length];
            for (int i = 0; i < numbersAsStrings.length; i++) {
                numbers[i] = Integer.parseInt(numbersAsStrings[i]);
            }
            
            ans += numbers[0] - helper_function2(numbers);
        }

        return ans;
    }

    

    static int helper_function2(int[] numbers){

        int[] next_line = new int[numbers.length - 1];
        for (int i = 0; i < numbers.length - 1; i++){
            next_line[i] = numbers[i + 1] - numbers[i];
        }


        // int foo = helper_function(next_line);
        if (all_same(next_line)) {
            return next_line[next_line.length - 1];
        } else {
            // System.out.println(next_line[next_line.length - 1] + helper_function(next_line));
            return next_line[0] - helper_function2(next_line);
        }



    }
}
