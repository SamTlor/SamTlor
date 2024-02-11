import java.util.Scanner;
import java.util.Arrays;

public class Exercise07_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = new int[100];

        int i = 0;
        System.out.println("Enter the integers between 1 and 100:");
        int response = scan.nextInt();

        while(response != 0){
            nums[i] = response;
            response = scan.nextInt();
            i++;
        }
        Arrays.sort(nums);

        int[] used = new int[100];
        for (int j = 0; j < nums.length; j++){
            if (nums[j] != 0){
                int var = howMany(nums[j], nums);

                if(howMany(nums[j], used) == 0){
                    if (var == 1){
                        System.out.println(nums[j] + " occurs 1 time");
                    } else {
                        System.out.println(nums[j] + " occurs " + var + " times");
                    }
                    used[j] = nums[j];
                }
            }
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