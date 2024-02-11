public class groupSumClump {
    public static void main(String[] args) {

        int[] theArray1 = {2,5,8};
        int[] theArray2 = {1,2,4,8,1};
        int[] theArray3 = {2,4,4,8};

        System.out.println(groupSumClump(0, theArray1, 10));
        System.out.println(groupSumClump(0, theArray2, 14));
        System.out.println(groupSumClump(0, theArray3, 14));
    }

    public static boolean groupSumClump(int start, int[] nums, int target){
        if(start >= nums.length){
            return target == 0;
        }
        if(nums.length > start + 1 && nums[start] == nums[start + 1]){
            int i = 1;
            while (nums[start] == nums[start + i]){
                i++;
            }
            return groupSumClump(start + i, nums, target - nums[start + i]);
        }
        if (groupSumClump(start + 1, nums, target - nums[start])){
            return true;
        }
        if (groupSumClump(start + 1, nums, target)){
            return true;
        }
        return false;
    }
}