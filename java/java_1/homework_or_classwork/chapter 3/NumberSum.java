/*
* NumberSum.java
* 
* This program asks a user if they want to have a number randomly generated or input their own then multiplies the first digit of the 
* number by 5, the second digit by 4,the third digit by 3, etc. Then it asks the user if they want to know if the sum of the multiplied
* numbers is divisible by 6, 9, or 11 and outputs if it is or not
*
* Sam Taylor
* 2/18/2021
* CMSC 255
*/
import java.util.Scanner;

public class NumberSum {
    public static void main(String[] args) {
        int lightswitch = 0;
        int number;
        Scanner scan = new Scanner(System.in);                                      //sets up a Scanner variable

        //asks the user if they want a number made for them or if they want to use their own
        System.out.println("Would you like to randomly enter a number (1) or enter it yourself (2)?");
        int response = scan.nextInt();
        
        if (response == 1){                                                         //if the user wants a number made for them
            number = (int) (Math.random() * 90000) + 10000;                         //random number in the range 0-89999 then add 10000 so the real range is 10000-99999
            System.out.println(number);                                             //outputing to the user
            lightswitch = 1;
        } else if (response == 2){                                                  //if the user wants to type in their own number
            System.out.println("Enter a 5-digit number.");                          //asks the user to type in their 5 digit number
            number = scan.nextInt();

            if (number < 10000 || number > 99999){                                  //makes sure the user's number has 5 digits
                System.out.println("Incorrect input");
            } else{
                lightswitch = 1;
            }
        } else {                                                                   //invalid response to do you want a number made for you
            System.out.println("Incorrect input");
            number = 0;
        }

        if (lightswitch == 1){
            int original = number;

            int sum = 0;                                    //i'll be adding to this later so we have to define sum as 0 right now
            for (int i = 1; i < 6; i++){            //the most beautiful piece of code ever written
                sum += (number % 10) * i;           //gets the last digit of the number and multiplies it by i. starting at 1 ending at 5
                number /= 10;                       //takes off the last digit of the number
            }

            //asks the user what they want to divide by
            System.out.println("Would you like to see if this number is divisible by 11, 9 or 6? Enter the number you would like to divide this number by. ");
            int intResponse = scan.nextInt();

            if (intResponse == 6 || intResponse == 9 || intResponse == 11){             //makes sure the user's response is correct

//PURPOSE OF THE PROGRAM: sees if the sum of the digits multiplied by their respective numbers is divisible by the number that was chosen
                if (sum % intResponse == 0){
                    System.out.println(original + " is divisible by " + intResponse + ".");
                } else{
                    System.out.println(original + " is not divisible by " + intResponse + ".");
            }
            } else {                                                                    //if the user's response isn't correct
                System.out.println("Incorrect input");
            }
        }
    }
}