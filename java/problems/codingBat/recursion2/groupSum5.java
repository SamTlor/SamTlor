public class groupSum5 {
    public static void main(String[] args) {

        int[] theArray = {2,5,10,4};

        System.out.println(groupSum5(0, theArray, 19));
        System.out.println(groupSum5(0, theArray, 17));
        System.out.println(groupSum5(0, theArray, 12));
    }

    public static boolean groupSum5(int start, int[] nums, int target){
        if(start >= nums.length){
            return target == 0;
        }
        if(nums[start] % 5 == 0){
            if(nums.length > start + 1 && nums[start + 1] == 1){
                return groupSum5(start + 2, nums, target - nums[start]);
            }
            else{
                return groupSum5(start + 1, nums, target - nums[start]);
            }
        }
        if (groupSum5(start + 1, nums, target - nums[start])){
            return true;
        }
        if (groupSum5(start + 1, nums, target)){
            return true;
        }
        return false;
    }
}