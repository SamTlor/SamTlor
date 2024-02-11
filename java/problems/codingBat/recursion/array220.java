public class  array220 {
    public static void main(String[] args) {

        int[] array1 = {1, 2, 20};
        int[] array2 = {3, 30};
        int[] array3 = {3};


        System.out.println(array220(array1, 0));
        System.out.println(array220(array2, 0));
        System.out.println(array220(array3, 0));
    }

    public static boolean array220(int[] nums, int index){
        if(nums.length == index + 1  || nums.length == index){
            return false;
        }
        if(nums[index] * 10 == nums[index + 1]){
            return true;
        }
        return array220(nums, index + 1);
    }
}