/* 
* MiddleString.java
* 
* asks the user for three strings and sorts them alphabetically so that it can return the string that is in the middle of the other two 
* 
* Sam Taylor
* 2/24/21
* CMSC 255
*/

/*
* test cases
* user input        Expected output         actual output
* ---------------------------------------------------------
* abc def ghi       def                     def
* abd eft bde       bde                     bde
* aaa bbb ccc       bbb                     bbb
* AAA AAA AAA       AAA                     AAA
* AAA AAA BBB       AAA                     AAA
* AAA BBB BBB       BBB                     BBB
*/

import java.util.Scanner;

public class MiddleString { 
    public static void main(String [] args) {  
        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter three strings:");
        String str1 = scnr.nextLine();
        String str2 = scnr.nextLine();
        String str3 = scnr.nextLine();
        String lowest;
        String middle;

        // see if the first string comes before the second one
        if (str1.compareTo(str2) < 0){
            lowest = str1;
            middle = str2;
        } else {
            lowest = str2;
            middle = str1;
        }

        // see if the first string comes before the third one
        if (lowest.compareTo(str3) < 0){
            // if it does compare the second one and the third one
            if (str3.compareTo(middle) < 0){
                //change only needs to happen if the third string comes before the string that is second at this point
                middle = str3;
            }
        // if the third string comes first then the former first string has to be the middle string that the user wants
        } else {
            middle = lowest;
        }

        System.out.println(middle);
        scnr.close();
    }
}