/*
* 
* CountLoop.java
* 
* This program asks the user for a a number. Then it calculates the sum of all of the positive integers below it using three different types of loops
* 
* Sam Taylor
* 3/2/2021
* CMSC 255
* 
*/

import java.util.Scanner;

public class CountLoop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("type the last number: ");
        int num = scan.nextInt();

        int for_sum = 0;
        for (int i = 0; i < num+1; i++){
            for_sum += i;
        }

        int j = 0;
        int while_sum = 0;
        while(j < num + 1){
            while_sum += j;
            j++;
        }

        int k = 0;
        int do_sum = 0;
        do{
            do_sum += k;
            k++;
        }while (k < num + 1);

        System.out.println("for_sum: " + for_sum);
        System.out.println("while_sum: " + while_sum);
        System.out.println("do_sum: " + do_sum);
    }
}