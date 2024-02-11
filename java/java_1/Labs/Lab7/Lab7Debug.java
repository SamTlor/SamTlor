/*
 *
 * Lab7Debug.java
 *
 * This program accepts two numbers from the user and finds the greatest common denominator
 * that the two numbers share
 *
 * Sam Taylor
 * 3/10/2021
 * CMSC 255
 *
 */

package Labs.Lab7;

import java.util.Scanner;

public class Lab7Debug {

    public static void main(String[] args){
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter two integers
        System.out.print("Enter first integer: ");
        int n1 = input.nextInt();
        System.out.print("Enter second integer: ");
        int n2 = input.nextInt();

        int gcd = GCD(n1,n2);//invoke function

        System.out.println("The greatest common divisor for " + n1 + " and " + n2 + " is " + gcd);
    }

    public static int GCD(int num1, int num2){

        int gcd = 1;                                //if they don't have any other gcd, then the gcd is 1
        int k = 2;                                  //gcd is already equal to one we don't need to test 1
        while (k <= num1 && k <= num2) {            //can't have a gcd higher than one of the nums
            if (num1 % k == 0 && num2 % k == 0) {   //if this passes we've found a common denominator
                gcd = k;                            //setting this to num1 means we can't access k, the real gcd
            }
            k++;
        }
        return gcd;
    }
}