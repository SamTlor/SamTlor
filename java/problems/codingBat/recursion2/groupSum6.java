public class groupSum6 {
    public static void main(String[] args) {

        int[] theArray = {5,6,2};

        System.out.println(groupSum6(0, theArray, 8));
        System.out.println(groupSum6(0, theArray, 9));
        System.out.println(groupSum6(0, theArray, 7));
    }

    public static boolean groupSum6(int start, int[] nums, int target){
        if(start >= nums.length){
            return target == 0;
        }
        if (nums[start] == 6){                                              //if it == 6 you have to use it
            return groupSum6(start + 1, nums, target - nums[start]);
        }
        if (groupSum6(start + 1, nums, target - nums[start])){
            return true;
        }
        if (groupSum6(start + 1, nums, target)){
            return true;
        }
        return false;
    }
}