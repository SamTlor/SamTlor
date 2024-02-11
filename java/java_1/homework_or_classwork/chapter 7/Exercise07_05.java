import java.util.Scanner;
import java.util.Arrays;

public class  Exercise07_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int i;
        int[] nums = new int[10];
        for (i = 0; i< 10; i++){
            int var = scan.nextInt();    
            if (howMany(var, nums) == 0){
                nums[i] = var;
            }
        }

        Arrays.sort(nums);
        int[] vetter_nums = new int[i];
        for (int k = 0; k < i; k++){
            if (nums[k] != nums[k + 1] && k != i-1){
                vetter_nums[k] = nums[k];
            } else if(nums[k] != nums[k + 1] && k == i-1){
                vetter_nums[k] = nums[k];
                vetter_nums[k + 1] = nums[k + 1];
            }
        }

        System.out.println("\nThe number of distinct number is " + (vetter_nums.length) + "\nThe distinct numbers are: ");
        for (int a = 0; a < i; a++){
            System.out.print(vetter_nums[a] + " ");
        }

    }

    public static int howMany(int input, int[] nums){
        int value = 0;
        for (int i = 0; i < nums.length; i++){
            if (input == nums[i]){
                value++;
            }
        }
        return value;
    }
}