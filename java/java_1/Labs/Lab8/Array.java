/*
 *
 * Array.java
 *
 * This program prints the names of characters from Rick and Morty then changes the order they're in a few times
 *
 * Sam Taylor
 * 3/17/2021
 * CMSC 255
 *
 */

package Labs.Lab8;

public class Array {
    public static void main(String[] args){
        String[] tokens = args[0].split(",");
        String[] customer_name = new String[8];

        for (int i = 0; i < tokens.length; i++){
            customer_name[i] = tokens[i];
        }

        displayNames(customer_name);

        customer_name[6] = customer_name[4];
        customer_name[7] = customer_name[5];
        customer_name[4] = "Rick";
        customer_name[5] = "Jessica";
        displayNames(customer_name);
        displayNames(reverseNames(customer_name));

        for(int j = 0; j < customer_name.length - 1;){
            if(customer_name[j] == null) break;
            if (customer_name[j].equals("Rick")){
                for(int k = j; k < customer_name.length - 1; k++){
                    customer_name[k] = customer_name[k + 1];
                }
                customer_name[customer_name.length - 1] = null;
            } else {
                j++;
            }
        }
        displayNames(customer_name);
    }
    public static void displayNames(String[] names){
        for(String name : names){
            System.out.println(name);
        }
        System.out.println();
    }
    public static String[] reverseNames(String[] names){
        String temp;
        for (int i = 0; i < names.length / 2; i++) {
            temp = names[i];
            names[i] = names[names.length - 1 - i];
            names[names.length - 1 - i] = temp;
        }
        return names;
    }
}