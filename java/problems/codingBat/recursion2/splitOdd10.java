public class splitOdd10 {
    public static void main(String[] args) {
        int[] theArray1 = {5,5,5};
        int[] theArray2 = {5,5,6};
        int[] theArray3 = {5,5,6,1};

        System.out.println(splitOdd10(theArray1));
        System.out.println(splitOdd10(theArray2));
        System.out.println(splitOdd10(theArray3));
    }

    public static boolean splitOdd10(int[] nums){
        int index = 0;
        int sum1 = 0;
        int sum2 = 0;
        return helper(nums, index, sum1, sum2);
    }

    public static boolean helper(int[] nums, int index, int sum1, int sum2){
        if(index >= nums.length){
            return sum1 % 10 == 0 && sum2 % 2 == 1;
        }

        int value = nums[index];
        return helper(nums, index + 1, sum1 + value, sum2) || helper(nums, index + 1, sum1, sum2 + value);
    }
}