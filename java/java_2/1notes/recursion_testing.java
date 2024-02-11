import java.util.prefs.BackingStoreException;

public class recursion_testing {

    /*
        * @returns a String of character, ch. The length is determined
        * 			by the second parameter, length.
        */
    public static String buildStringOfCharacters(char ch, int length) {
        if (length < 1){
            return "";
        }else if(length == 1){
            return "" + ch;
        } else{
            return ch + buildStringOfCharacters(ch, length - 1);
        }
    }

    /*
        * returns an int array that has the elements in reverse order
        * 			of the parameter array, nums.
        * Process this recursively beginning with the last element.
        */
    public static int[] reverseNumArray(int[] nums, int backIndex) {
        if (backIndex < nums.length / 2){
            return nums;
        }
        int temp = nums[backIndex];

        int front = nums.length - backIndex - 1;
        nums[backIndex] = nums[front];
        nums[front] = temp;
        
        return reverseNumArray(nums, backIndex-1);
    }

    /*
        * returns true if the int array parameter is sorted from smallest
        * 			to largest, false otherwise.
        * Process this recursively beginning with the first element.
        */
    public static boolean isSmallestToLargest(int[] values, int firstIndex) {
        return false;
    }

    /*
        * @returns true if the parameter String, str is a palindrome
        * 			false otherwise
        */
    public static boolean isPalindrome(String str, int begin, int end) {
        return false;
    }







    

    public static void main(String[] args) {
    
        //buildStringOfCHaracters test
    /*  
        String test1 = buildStringOfCharacters('*', 8);
        String expected1 = "********";
        
        if (test1.equals(expected1)){
            System.out.println("Test 1 passed");
        } else{
            System.out.println("Test 1 failed");
        }

        String test2 = buildStringOfCharacters('8', 8);
        String expected2 = "88888888";
        if(test2.equals(expected2)){
            System.out.println("Test 2 passed");
        } else{
            System.out.println("Test 2 failed");
        }

        String test3 = buildStringOfCharacters('*', 10);
        String expected3 = "**********";
        if(test3.equals(expected3)){
            System.out.println("Test 3 passed");
        } else{
            System.out.println("Test 3 failed");
        }

        String test4 = buildStringOfCharacters(' ', 8);
        String expected4 = "        ";
        if(test4.equals(expected4)){
            System.out.println("Test 4 passed");
        } else{
            System.out.println("Test 4 failed");
        }

        String test5 = buildStringOfCharacters('*', 1);
        String expected5 = "*";
        if(test5.equals(expected5)){
            System.out.println("Test 5 passed");
        } else{
            System.out.println("Test 5 failed");
        }

        String test6 = buildStringOfCharacters('*', -4);
        String expected6 = "";
        if(test6.equals(expected6)){
            System.out.println("Test 6 passed");
        } else{
            System.out.println("Test 6 failed");
        }
     
        String test7 = buildStringOfCharacters('L', 8);
        String expected7 = "LLLLLLLL";
        if(test7.equals(expected7)){
            System.out.println("Test 7 passed");
        } else{
            System.out.println("Test 7 failed");
        }
    } 
    
    //end of buildStringOfCharacters tests
    */

    //reverseNumArray tests
        int[] arr1 = {1,2,3};
        int[] arrTest1 = reverseNumArray(arr1, 2);
        int[] arrExpected1 = {3,2,1};
        boolean same1 = true;

        for(int i = 0; i < arrTest1.length; i++){
            if(arrTest1[i] != arrExpected1[i]){
                same1 = false;
            }
        }

        if (same1){
            System.out.println("Test 1 on reverse arrays passed");
        }else{
            System.out.println("Test 1 on reverse arrays failed");
        }

        int[] arr2 = {1,2,3,4,5,6,7,8,9};
        int[] arrTest2 = reverseNumArray(arr2, 8);
        int[] arrExpected2 = {9,8,7,6,5,4,3,2,1};
        boolean same2 = true;

        for(int i = 0; i < arrTest2.length; i++){
            if(arrTest2[i] != arrExpected2[i]){
                same2 = false;
            }
        }

        if (same2){
            System.out.println("Test 2 on reverse arrays passed");
        }else{
            System.out.println("Test 2 on reverse arrays failed");
        }

        int[] arr3 = {1,2,3,4,5,6,7,8,9,10};
        int[] arrTest3 = reverseNumArray(arr3, 9);
        int[] arrExpected3 = {10,9,8,7,6,5,4,3,2,1};
        boolean same3 = true;

        for(int i = 0; i < arrTest3.length; i++){
            if(arrTest3[i] != arrExpected3[i]){
                same3 = false;
            }
        }

        if (same3){
            System.out.println("Test 3 on reverse arrays passed");
        }else{
            System.out.println("Test 3 on reverse arrays failed");
        }
    }
}