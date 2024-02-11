/*
* 
* NestedLoopTriangle.java
* 
* This program prints a two triangles of asterisks "*" based on the number that the user types. Each line having an odd number of asterisks
* one with spaces and one without spaces
* one with while loops and one with for loops (just cuz)
* 
* Sam Taylor
* 3/2/2021
* CMSC 255
* 
*/

import java.util.Scanner;

public class NestedLoopTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("how many lines do you want to print?");
        int num = scan.nextInt();

        int i = 0;
        while (i < num + 1){
            String line = "";
            
            int j = 1;
            while(j < i * 2){
                line += "*";
                j++;
            }

            System.out.println(line);
            i++;
        }



        for (int a = 0; a < num + 1; a++){
            String line = "";

            for (int spaces = num - a; spaces > 0; spaces--){
                line += " ";
            }
            for (int b = 1; b < a*2; b++){
                line += "*";
            }
            System.out.println(line);
        }



    }
}