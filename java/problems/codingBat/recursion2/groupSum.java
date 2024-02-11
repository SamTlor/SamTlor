public class groupSum {
    public static void main(String[] args) {

        int[] theArray = {2,4,8};

        System.out.println(groupSum(0, theArray, 10));
        System.out.println(groupSum(0, theArray, 14));
        System.out.println(groupSum(0, theArray, 8));
    }

    /*  makes a power set of the array
    *   it ends when the set is "empty"
    *   lets say the array is {a,b,c}
    *   it gets the target  minus a             100
    *                       minus a, b          110
    *                       minus a, b, c       111
    *                       minus a, c          101
    *                       minus b             010
    *                       minus b, c          011
    *                       minus c             001
    *                   which is the same as
    *                       {a}, {b}, {c}
    *                       {a,b}, {a,c}, {b,c}
    *                       {a,b,c}
    */  
    public static boolean groupSum(int start, int[] nums, int target){
        if(start >= nums.length){                                           //base case. 
            return target == 0;                                             //returns returns false for when the if calls the method again
        }
        if (groupSum(start + 1, nums, target - nums[start])){               //gets if target minus start == 0
            return true;                                                    //when this part is running it's looking for a nth number
        }
        if (groupSum(start + 1, nums, target)){                             //if you don't use the next number
            return true;                                                    //see if the current number == target
        }
        return false;
    }
}