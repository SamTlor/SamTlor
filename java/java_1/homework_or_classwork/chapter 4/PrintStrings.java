/* 
* PrintStrings.java
* 
* asks the user for two words and then sorts them based on which one comes first in the alphabet
* 
* Sam Taylor
* 2/24/21
* CMSC 255
*/

import java.util.Scanner;

public class PrintStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter two words:");
        String word1 = scan.nextLine();
        String word2 = scan.nextLine();

        // compareTo() results in a negative number if the first letter comes before the word that is in the ( )
        if (word1.compareTo(word2) < 0){
            System.out.println("the words in alphabetical order are: " + word1 + " " + word2);
        } else{
            System.out.println("The words in alphabetical order are: " + word2 + " " + word1);
        }

        scan.close();
    }
}