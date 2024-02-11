public class array6 {
    public static void main(String[] args) {

        int[] array1 = {1,6,4};
        int[] array2 = {1,4};
        int[] array3 = {6};

        System.out.println(array6(array1 ,0));
        System.out.println(array6(array2, 0));
        System.out.println(array6(array3, 0));
    }

    public static boolean array6(int[] nums, int index){
        if(nums.length == index){
            return false;
        }
        if (nums[index] == 6){
            return true;
        }
        return array6(nums, index + 1);
    }
}