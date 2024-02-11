import java.util.Scanner;

public class Exercise12_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a binary number: ");
        String var = scan.nextLine();

        try{                                                        //just like try... except
            bin2Dec(var);
        } catch (NumberFormatException nfe){
            System.out.println("Not a binary number: " + var);
        };
    }

    public static void bin2Dec(String binaryString){
        int total = 0;

        //more beautiful than the most beautifull piece of code ever written from /chapter 3/NumberSum.java
        for (int i = 0; i < binaryString.length(); i++){
            //gets the number value for every character of string.  '- 1 - i' makes it work backwards so that the power of 2 thing works
            int var = Character.getNumericValue(binaryString.charAt(binaryString.length() - 1 - i));

            if (var == 1 || var == 0){                      //as long as the number the person wrote is a binary number
                total += var * Math.pow(2, i);              //figure out the value of the binary number
            } else {
                throw new NumberFormatException();
            }
        }

        System.out.println(total);
    }
}