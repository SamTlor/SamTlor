import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;




public class day7 {

    // the main function
    public static void main(String[] args) {

        // store the input line by line in a list
        List<String> input = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("day7.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                
                // add the countPairs to the line so that you don't need to look it up later
                String hand = line.split(" ")[0];
                input.add(line + " " + countPairs(hand) + " " + countPairs2(hand));
            }
        } catch (IOException e) {}
        
        
        
        
        
        // use custom comparator and calculate final return
        Collections.sort(input, new GameComparator("23456789TJQKA", 2));
        int part1 = 0;
        for (int i = 0; i < input.size(); i++){
            part1 += (i + 1) * Integer.parseInt(input.get(i).split(" ")[1]);
        }
        
        
        
        // use custom comparator 2 and calculate final return
        Collections.sort(input, new GameComparator("J23456789TQKA", 3));
        int part2 = 0;
        for (int i = 0; i < input.size(); i++){
            part2 += (i + 1) * Integer.parseInt(input.get(i).split(" ")[1]);
        }



        System.out.println(part1);
        System.out.println(part2);
    }







    // the custom comparator
    static class GameComparator implements Comparator<String>{

        // use this to find bigger among two chars
        private final String sequence;
        private final int countPairsIndex;

        // constructor so that i can have the two different versions of comparator
        public GameComparator(String sequence, int countPairsIndex) {
            this.sequence = sequence;
            this.countPairsIndex = countPairsIndex;
        }



        @Override
        public int compare(String s1, String s2){

            // strings start out as whole line but we only need the part before the space
            String input1 = s1.split(" ")[0];
            String input2 = s2.split(" ")[0];

            // count pairs in each string
            int p1 = Integer.parseInt(s1.split(" ")[countPairsIndex]);
            int p2 = Integer.parseInt(s2.split(" ")[countPairsIndex]);

            // if theres a difference in amount of pairs then return that
            int comparePairs = Integer.compare(p1, p2);
            if (comparePairs != 0) {
                return comparePairs;
            }
            
            // otherwise compare based on starting character
            for (int i = 0; i < 5; i++){
                char c1 = input1.charAt(i);
                char c2 = input2.charAt(i);

                // get the index of each letter in sequence
                int index1 = sequence.indexOf(c1);
                int index2 = sequence.indexOf(c2);

                // so that whichever index is smaller is the string with the higher hand
                if (index1 != index2) {
                    return Integer.compare(index1, index2);
                }
            }

            // this will never be reached because the inputs are distinct
            return 0;
        }
    }   







    // Part 1 method
    public static int countPairs(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        //three of the same card
        boolean three = false;
        //two of the same card
        int pairs = 0;

        // loop through unique cards in hand
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {

            if (entry.getValue() == 5) {                //five of a kind
                return 6;
            } else if (entry.getValue() == 4) {         //four of a kind
                return 5;
            } else if (entry.getValue() == 3) {         
                three = true;
            } else if (entry.getValue() == 2) {         
                pairs++;
            }
        }

        if (three && pairs > 0) {                       //full house
            return 4;
        } else if (three) {                             //three of a kind
            return 3;
        } else {                                        //2 pair, 1 pair, or 0 pair
            return pairs;
        }
    }







    // Part 2 method
    public static int countPairs2(String s) {
        
        // dictionary of character -> amount of that character
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        // find the highest valued card so that the j's can be added to it
        Map.Entry<Character, Integer> highest = null;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            
            // ignore jokers cuz they'll be added to the highest later
            if (entry.getKey() == 'J'){
                continue;
            }

            if (highest == null || (entry.getValue()) > highest.getValue()){
                highest = entry;
            }
        }
        
        // add jokes to the most common card
        int jokes = countMap.getOrDefault('J', 0);        
        if (highest != null) {
            countMap.put(highest.getKey(), highest.getValue() + jokes);
        } else {
            // JJJJJ edge case
            return 6;
        }      
        

        

        
        if (highest.getValue() == 5) {                  // five of a kind
            return 6;
        } else if (highest.getValue() == 4) {           // four of a kind
            return 5;
        } 
        

        // three of the same card
        boolean three = false;

        // two of the same card
        int pairs = 0;

        // loop through unique cards in hand
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {

            // ignore jokers cuz they've already been added to highest
            if (entry.getKey() == 'J'){
                continue;
            }
            
            // four and five of a kind have already been tested for
            // this is for three, fullhouse, and pairs
            if (entry.getValue() == 3) {
                three = true;
            } else if (entry.getValue() == 2) {
                pairs++;
            }
        }

        if (three && pairs > 0) {                       // full house
            return 4;
        } else if(three) {                              // three of a kind
            return 3;
        } else {                                        // two pair, one pair, or zero pair
            return pairs;
        }
    }
}