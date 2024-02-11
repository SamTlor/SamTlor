public class splitArray {
    public static void main(String[] args) {

        int[] theArray1 = {2,2};
        int[] theArray2 = {2,3};
        int[] theArray3 = {5,2,3};

        System.out.println(splitArray(theArray1));
        System.out.println(splitArray(theArray2));
        System.out.println(splitArray(theArray3));
    }

    public static boolean splitArray(int[] nums){
        int index = 0;
        int sum1 = 0;
        int sum2 = 0;
        return helper(nums, index, sum1, sum2);
    }

    public static boolean helper(int[] nums, int index, int sum1, int sum2){
        if(index >= nums.length){
            return sum1 == sum2;
        }

        int value = nums[index];
        return helper(nums, index + 1, sum1 + value, sum2) || helper(nums, index + 1, sum1, sum2 + value);
    }
}