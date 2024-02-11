/*
* 
* PhoneSelection.java
* 
* This program tells the user the digit on a telephone that corresponds with a letter that the user types in
* 
* Sam Taylor
* 2/17/2021
* CMSC 255
* 
*/

import java.util.Scanner;

public class PhoneSelection {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ.";

        System.out.println("Enter a single letter, and I will tell you what the corresponding digit is on the telephone");
        char result = scan.next().charAt(0);
        char letter = Character.toUpperCase(result);
        int letterIndex = alphabet.indexOf(letter);


        if (letterIndex < 3){
            System.out.println("The digit " + 2 + " corresponds to the letter " + letter + " on the telephone.");
        } else if (letterIndex < 6){
            System.out.println("The digit " + 3 + " corresponds to the letter " + letter + " on the telephone.");
        } else if (letterIndex < 9){
            System.out.println("The digit " + 4 + " corresponds to the letter " + letter + " on the telephone.");
        } else if (letterIndex < 12){
            System.out.println("The digit " + 5 + " corresponds to the letter " + letter + " on the telephone.");
        } else if (letterIndex < 15){
            System.out.println("The digit " + 6 + " corresponds to the letter " + letter + " on the telephone.");
        } else if (letterIndex < 19){
            System.out.println("The digit " + 7 + " corresponds to the letter " + letter + " on the telephone.");
        } else if (letterIndex < 22){
            System.out.println("The digit " + 8 + " corresponds to the letter " + letter + " on the telephone.");
        } else if (letterIndex < 27){
            System.out.println("The digit " + 9 + " corresponds to the letter " + letter + " on the telephone.");
        }
    }
}