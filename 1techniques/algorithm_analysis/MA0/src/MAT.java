import java.io.File;
import java.util.Scanner;

public class MAT {
    public static void main(String[] args) throws Exception {
        //like the instructions say:
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);

        //get the first number in the file to say how many lines to get
        int first_line = scan.nextInt();
        for (int i = 0; i < first_line; i++){
            //first thing is get how many numbers are in this line
            int first_num = scan.nextInt();
            //make an array to hold those numbers
            int[] line = new int[first_num];
            for(int j = 0; j < first_num; j++){
                line[j] = scan.nextInt();
            }

            //for readability. save the last two numbers in the line
            //could use array length but the int is right there so..
            int second_last = line[first_num - 2];
            int last_last = line[first_num - 1];

            //minus 1 to make up for array indexing
            int min = Math.min(line[second_last - 1], line[last_last - 1]);

            System.out.println(min);
        }
        
        scan.close();
    }
}
