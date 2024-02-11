/*
* NumberSum.java
* 
* This program asks a user to if they want to have a number randomly generated then multiplies the first digit by 5, the second digit by 4,
* the third digit by 3, etc. Then it asks the user if they want to know if the sum of the multiplied numbers is divisible by 6, 9, or 11
* and outputs if it is true or not
*
* Sam Taylor
* 2/18/2021
* CMSC 255
*/
import java.util.Scanner;

public class NumberSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to randomly enter a number (1) or enter it yourself (2)?");
        int response = scan.nextInt();
        scan.nextLine();

        int[] number = new int[5];
        if (response == 1){
            for (int i = 0; i < 5; i++){
                number[i] = (int) (Math.random() * 10);
            }
            System.out.println("Your number is: " + number[0] + number[1] + number[2] + number[3] + number[4]);
        } else if (response == 2){
            System.out.println("Enter a 5-digit number.");
            String yourOwn = scan.nextLine();

            for (int i = 0; i < 5; i++){
                number[i] = yourOwn.charAt(i)-'0';
            }
        } else{
            System.out.println("Incorrect input");
        }

        int dividend = 0;
        for (int k = 0, j = 5; j > 0; j--, k++){//the actual multiplication
            dividend += (number[k] * j);//starts with number[0] * 5, next it goes to number[1] * 4, then number[2] * 3
        }
        
        System.out.println("Would you like to see if this number is divisible by 11, 9 or 6? Enter the number you would like to divide this number by. ");
        int intResponse = scan.nextInt();

        if (intResponse == 6 || intResponse == 9 || intResponse == 11){
            if (dividend % intResponse == 0){
                System.out.println("" + number[0] + number[1] + number[2] + number[3] + number[4] + " is divisible by " + intResponse + ".");
            } else{
                System.out.println("" + number[0] + number[1] + number[2] + number[3] + number[4] + " is not divisible by " + intResponse + ".");//i hate typing out every element from the array. I could do that in python with one [:]
            }
        } else{
            System.out.println("Incorrect input");
        }
    }
}