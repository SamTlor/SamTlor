/*
* Sam Taylor
* 9/8/21
* CMSC256
*/

package cmsc256;
import java.util.Arrays;

public class ArrayUtilities {
    public static void main(String[] args) {
        int[] testFindMax = {1, 42, 35, 50, 75, -6, 89, 4, 12};

        System.out.println("Testing findMax: Expected is 89 - Observed is " +  ArrayUtilities.findMax(testFindMax));
        System.out.println("Testing findIndexOfMax: Expected is 6 - Observed is" +  ArrayUtilities.findIndexOfMax(testFindMax));

        byte[][] testTransmission =    {
                                        {5, 2, 9, 3, 7, 5},         //bytes are whole numbers that are between 1-200ish
                                        {5, 2, 1, 3, 7, 5},
                                        {5, 2, 1, 3, 1, 1},
                                        {5, 4, 4, 3, 7, 5},
                                        {7, 2, 1, 8, 7, 5}
                                                            };
        int[] correctRow =              {5, 2, 1, 3, 7, 5};

        System.out.println("Testing extractCorrectArray:\n  Expected is " + Arrays.toString(correctRow) +
                            "\n  Observed is " + Arrays.toString(ArrayUtilities.extractCorrectArray(testTransmission)) );
                            
        System.out.println("Testing countErrors: Expected is 7 - Observed is " + ArrayUtilities.countErrors(testTransmission));
        System.out.println("Testing errorRate: Expected is approx. 23.33% - Observed is " +
                                ArrayUtilities.errorRate(testTransmission) + "%");
    }


    
    public static int findMax(int[] nums) {
        int max = nums[0];                          //biggest is the first in the array
        for (int i = 1; i < nums.length; i++){      //loop through the array
            if (nums[i] > max){                     //if there's a number that's bigger than the current biggest
                max = nums[i];                      //make that one the biggest
            }
        }
        return max;                                 //return the biggest
    }

    public static int findIndexOfMax(int[] nums) {
        int max = nums[0];      
        int index = 0;                              //same as the one above but save the index too
        
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > max){
                max = nums[i];
                index = i;                          //index too
            }
        }
        return index;
    }


    public static int howmanyRepeaters(byte[] column){      //i'm not going to put this part into extractCorrectArray
        int[] ending = new int[6];                          //list of how many times each number is repeated
        int count, currentInt = 0;

        for (int i = 0; i < column.length; i++){            //loops through the array that was given
            currentInt = column[i];                         //saves the item we're working on
            count = 0;                                      //saves how many times it repeats

            for (int j = 0; j < column.length; j++){        //loops through the array again
                if (currentInt == column[j]){               //when it hits the one it's working on 
                    count++;                                //says how many times currentInt is in the column array
                }
            }
            ending[i] = count;
        }

        return findIndexOfMax(ending);                      //returns the index of the item that repeats the most
    }

    public static byte[] extractCorrectArray(byte[][] multiples){
        byte [] ending = new byte[6];

        for (int i = 0; i < multiples.length+1; i++){
            byte[] temp = new byte[5];                          //creates array out of each column of the 2D array

            for (int j = 0; j < multiples.length; j++){         
                temp[j] = multiples[j][i];
            }
            ending[i] = multiples[howmanyRepeaters(temp)][i];   //puts it into the final
        }

        return ending;
    }

    public static int countErrors(byte[][] matrix){
        byte[] comparator = extractCorrectArray(matrix);        //gets the right array
        int count = 0;                              

        for (int i = 0; i < matrix[0].length; i++){             //for i horizontally
            for (int j = 0; j < matrix.length; j++){            //for j vertically
                if(matrix[j][i] != comparator[i]){              //if ji is wrong
                    count++;                                    //c++
                }
            }
        }

        return count;
    }

    public static double errorRate(byte[][] matrix){
        double count = 0; 

        for(int i = 0; i< matrix[0].length; i++){               
            for (int j = 0; j < matrix.length; j++){
                count++;                                        //I might not always have the same amount of transmissions
            }
        }
        
        return countErrors(matrix) / count * 100;
    }
}