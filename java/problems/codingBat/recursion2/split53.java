public class split53 {
    public static void main(String[] args) {
        int[] theArray1 = {1,1};
        int[] theArray2 = {1,1,1};
        int[] theArray3 = {2,4,2};

        System.out.println(split53(theArray1));
        System.out.println(split53(theArray2));
        System.out.println(split53(theArray3));
    }

    public static boolean split53(int[] nums){
        int index = 0;
        int sum1 = 0;
        int sum2 = 0;
        return helper(nums, index, sum1, sum2);
    }

    public static boolean helper(int[] nums, int index, int sum1, int sum2){
        if(index >= nums.length){
            return sum1 == sum2;
        }

        if (nums[index] % 5 == 0){
            return helper(nums, index + 1, sum1 + nums[index], sum2);
        }
        else if(nums[index] % 3 == 0){
            return helper(nums, index + 1, sum1, sum2 + nums[index]);
        }
        return helper(nums, index + 1, sum1 + nums[index], sum2) || helper(nums, index + 1, sum1, sum2 + nums[index]);
    }
}