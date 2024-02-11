import java.util.*;

public class  GuessMyPhoneNumber {
    final static int NUM_DIGITS = 10;
    public static void main(String[] args) {

        List<String> myPhoneNumber = new ArrayList<>();

        myPhoneNumber.add("7");
        myPhoneNumber.add("0");
        myPhoneNumber.add("3");
        myPhoneNumber.add("8");
        myPhoneNumber.add("6");
        myPhoneNumber.add("7");
        myPhoneNumber.add("5");
        myPhoneNumber.add("3");
        myPhoneNumber.add("0");
        myPhoneNumber.add("9");

        
        //check if the number of digits is right
        if (args.length != NUM_DIGITS){
            System.out.println("need to guess " + NUM_DIGITS + " digits");
        }

        //initialize phone number List
        List<String> guess = new ArrayList<>(myPhoneNumber);
        for (int i = 0; i < NUM_DIGITS; i++){
            guess.add(args[i]);
        }

        //convert from string array to a List of integers
        List<String> temp = new ArrayList<>(myPhoneNumber);
        int numCorrect = 0; 
        for (int i = 0; i < NUM_DIGITS; i++){
            if(  temp.remove( guess.get(i) )  ){        //remove() returns true if an element is removed from the list
                numCorrect++;
            }
        }


        //find number of digits that were correctly guessed
        //find the digits in the guess that are in the correct location
        //display results to user
        System.out.println(numCorrect + " digit(s) correctly included in your guess");
    }
}