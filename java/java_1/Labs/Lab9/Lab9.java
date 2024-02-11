/*
 *
 * lab9.java
 *
 * This program reads data from a two dimensional array and for each row finds a number that can be changed from 0
 * to make the sum of the row equal 10. it also has a function that finds the larger of the average of the row or
 * the column and changes each zero to that respective answer
 *
 * Sam Taylor
 * 5/5/2021
 * CMSC 255
 *
 */

package Labs.Lab9;

public class Lab9 {
    public static void main(String[] args) {
        //data
        int [][] addTo10Input = {
                {  6,  3,  2,  0,  4},
                { 34, 53,  0, 23,  1},
                {  0, 23, 54, 11,  7}
        };

        double [][] findAvgInput = {
                {  5, 4.5,  6.8},
                {  6,  0,  3.4},
                { 7,  8.4,  2.3}
        };

        double [][] findAvgInputLarge = {
                { 6.7,  23.8,  0,  5.9,  12.8,  45.7},
                {  0,  36.8,  13.5,  6.7,  54.9,  67.4},
                {  37.4,  2.5,  39.8,  0,  2.4,  43.6},
                {  44.6,  76.5,  4.5, 2.4,  0, 54.6},
                {  5.4,  76.3,  6.5, 28.5,  54.7,  0},
                {  19.4,  0,  5.3,  65.4,  93.5,  3.5}
        };

        //addTo10 (addTo10Input);
        //System.out.println();
        //findAverage (findAvgInput);
        //System.out.println();
        //findAverage (findAvgInputLarge);
        }

    public static void addTo10 (int [][] array) {
        for (int i = 0; i < array.length; i++){         //for every row

            int rowTotal = 0;                           //the values of the row added up
            for(int j = 0; j < array[i].length; j++){   //j goes sideways because it's in the second square brackets
                rowTotal += array[i][j];                //add to rowTotal
            }
            for(int j = 0; j < array[i].length; j++){   //go through every value in the double array
                if(array[i][j] == 0){                   //find 0
                    array[i][j] = 10 - rowTotal;        //x + y = 10   -->   x = 10 - y
                }
            }
        }
    }

    public static void findAverage (double [][] array) {
        for (int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){               //for every value in the double array
                if(array[i][j] == 0){                               //find 0
                    double rowTotal = 0;                            //values of the row added up
                    for (int a = 0; a < array[i].length; a++){
                        rowTotal += array[i][a];
                    }
                    double columnTotal = 0;                         //values of the column added up
                    for (int b = 0; b < array.length; b++){
                        columnTotal += array[b][j];
                    }                                               //max gives the answer
                    array[i][j] = Math.max((rowTotal/ array[i].length), (columnTotal/ array.length));
                }
            }
        }
    }
}