/*
 *
 * Lab7.java
 *
 * This program accepts a title, first, and last name from the user. It outputs "Dear title, first, and
 * last name" then it asks the user to enter two numbers and finds the sum of the integers between
 * those two numbers

 *
 * Sam Taylor
 * 3/10/2021
 * CMSC 255
 *
 */

package Labs.Lab7;

import java.util.Scanner;

public class Lab7{

    public static void main(String[] args) {
        // variable declarations for part 1
        String title;
        String firstName;
        String lastName;
        Scanner in = new Scanner(System.in);

        // prompt for input for part 1
        System.out.print("Enter a title:");
        title = in.next();
        System.out.print("Enter your first name:");
        firstName = in.next();
        System.out.print("Enter a your last name:");
        lastName = in.next();

        // call the method for part 1
        greeting(title, firstName, lastName);

        // variable declarations for part 2
        int number1;
        int number2;

        // user prompts for part 2
        System.out.print("Enter first number:");
        number1 = in.nextInt();
        System.out.print("Enter second number:");
        number2 = in.nextInt();

        // call the methods max and sumTo inside the println statement
        System.out.println("The largest number is " + max(number1, number2));
        System.out.println("The sum of the numbers is " + sumTo(number1, number2));
    }// end of main method

    /******************** greeting method goes here*********************/
    public static void greeting(String title, String first, String last){
        System.out.println();                                                   //needs a blank line
        System.out.println("Dear " + title + " " + first + " " + last + ",");   //'dear', spaces and a comma
        System.out.println();                                                   //blank line
    }
    /***********************end of method*************************/

    /******************** max method goes here*********************/
    public static int max(int number1, int number2){
        return(Math.max(number1, number2));                             //Is this not allowed?
        /*
        if (number1 > number2){
            return (number1);
        } else{
            return (number2);
        }
         */
    }
    /***********************end of method*************************/

    /******************** sumTo method goes here*********************/
    public static int sumTo(int number1, int number2){
        int sum = 0;                                        //last return value
        if (number1 < number2) {                            // do I count up or down
            for (int i = number1; i < number2 + 1; i++) {   // if it's up
                sum += i;
            }
        } else{
            for (int i = number1; i >= number2; i--){       //if it's down
                sum += i;
            }
        }
        return(sum);
    }
    /***********************end of method*************************/
}