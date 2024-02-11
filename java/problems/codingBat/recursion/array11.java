public class  array11 {
    public static void main(String[] args) {

        int[] array1 = {1,2,11};
        int[] array2 = {11,11};
        int[] array3 = {1,2,3,4};


        System.out.println(array11(array1, 0));
        System.out.println(array11(array2, 0));
        System.out.println(array11(array3, 0));

    }

    public static int array11(int[] nums, int index){
        if(nums.length == index){
            return 0;
        }
        if(nums[index] == 11){
            return 1 + array11(nums, index + 1);
        }
        return array11(nums, index + 1);
    }
}