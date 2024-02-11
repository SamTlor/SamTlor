public class groupNoAdj {
    public static void main(String[] args) {

        int[] theArray = {2,5,10,4};

        System.out.println(groupNoAdj(0, theArray, 12));
        System.out.println(groupNoAdj(0, theArray, 14));
        System.out.println(groupNoAdj(0, theArray, 7));
    }

    public static boolean groupNoAdj(int start, int[] nums, int target){
        if(start >= nums.length){
            return target == 0;
        }
        if (groupNoAdj(start + 2, nums, target - nums[start])){                 //if I don't use a digit then I don't need to skip 
            return true;                                                        //the adjacent number
        }
        if (groupNoAdj(start + 1, nums, target)){
            return true;
        }
        return false;
    }
}