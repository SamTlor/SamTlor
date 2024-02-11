import java.io.File;
import java.util.Scanner;


public class MA1 {
    public static void main(String[] args) throws Exception {
        //reads the input from the file like the instructions say it should
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);

        //gets how many lines to read
        int n = scan.nextInt();
        //saves an array for adding to and editing later
        int[] array = new int[n];

        //creates the original array
        for (int i = 0; i < n; i++){
            int y_cord = scan.nextInt();
            int size = scan.nextInt();
            array[i] = y_cord * size;
        }

        //organizes the array. see sorting for more details
        sorting(array, 0, n-1);

        //num is the final answer. if there is an even number of houses then
        //the median of the array will need to be decided on.
        int num;
        if(n % 2 == 0){
            //so there isn't a median but we can make one by adding two nums
            //if the median we make is divisible by 2 then divide by 2. done
            if((array[n/2] + array[n/2-1]) % 2 == 0){
                num = (array[n/2] + array[n/2 -1]) / 2;
            } 
            
            //if it's not divisible by 2 add 1 to it at the end
            else{
                num = (array[n/2] + array[n/2 -1]) / 2 + 1;
            }
        } else{
            //n is odd so just take the actual median
            num = array[n/2];
        }
        
        //final answer and then done
        System.out.println(num);
        for(int i : array){
            System.out.println(i);
        }
        scan.close();
    }

    //this_array is the array but the name is different
    //left is the start of the section of the array tatt we're interested in
    //right is the end  of the section of the array tatt we're interested in
    public static void sorting(int[] this_array, int left, int right){
        //markers or pointers for looking at the array and testing things
        int i = left;
        int j = right;
        
        //i'll need a temp int for later
        int temp;

        //pivot is the middle element in the array. It's declared now 
        //because it'll be used in the rest of the for testing other elems
        int pivot = this_array[(i + j) / 2];
        

        while(i < j){
            //makes i be the index for the first element that is not  
            //less than the pivot
            while(this_array[i] < pivot){
                i++;
            }
            //makes j be the index for the first element that is not 
            //bigger than the pivot
            while(this_array[j] > pivot){
                j--;
            }

            /*
             * so it counts up the amount of elements that are less than 
             * the pivot and takes the next element that wouldn't fit in
             * that section and moves it to a section where it would fit 
             */

            //switches the location of the elements that i and j point to
            if(i <= j){
                temp = this_array[i];
                this_array[i] = this_array[j];
                this_array[j] = temp;

                i++;
                j--;
            }
        }
        //if the starting boundry at the beginning is less than the new right 
        //boundry then we understand that that is the new section we need to
        //look at and organize
        if(left < j){
            sorting(this_array, left, j);
        }
        //same thing but for the new left boundry and the ending boundry
        if(i < right){
            sorting(this_array, i, right);
        }

        /*
         * it organizes the whole array to find the most median element
         * in the array 
         */
    }
}