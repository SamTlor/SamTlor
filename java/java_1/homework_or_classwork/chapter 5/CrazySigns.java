/*
* 
* CrazySigns.java
* 
* This program asks the user to enter the number sides of a polygon with equally lengthed sides, then it asks how long the sides are, then it asks for a string to put on the sign
* It calculates the area of the polygon
* then it calculates how much it would cost to build that polygon with the constants 2.78 for the area and 1.64 for the amount of letters in the string
* 
* Sam Taylor
* 3/2/2021
* CMSC 255
* 
*/


import java.util.Scanner;

public class CrazySigns {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String again = "yes";

        while (again.toUpperCase().compareTo("NO") != 0){
            System.out.println("Enter the number of sides to your polygon: ");
            int n = scan.nextInt();
            System.out.println("Enter the length of each side: ");
            int s = scan.nextInt();scan.nextLine();
            System.out.println("Enter the string you would like on your sign: ");
            String phrase = scan.nextLine();
            phrase = phrase.replace(" ", "");

            double area = (n * s * s) / (4 * Math.tan(Math.PI/n));

            System.out.print("$");
            System.out.printf("%.2f", area * 2.78 + phrase.length() * 1.64);


            System.out.println("\nWould you like to create another sign? Enter no to exit.");
            again = scan.nextLine();
        }
        scan.close();
    }
}