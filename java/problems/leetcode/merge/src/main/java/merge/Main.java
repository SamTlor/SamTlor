package merge;


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int current = m + n - 1;
        m--;
        n--;
        
        while (current >= 0 && m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[current] = nums1[m];
                m--;
            } else {
                nums1[current] = nums2[n];
                n--;
            }


            current -= 1;
        }


        
        // if all of nums2 elements are smaller than nums1 elements
        while ( n >= 0 ) {
            nums1[current] = nums2[n];
            n -= 1;
            current -= 1;
        }

    }
}


public class Main {
    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int m = 3;
        int[] nums2 = {1,2,3};
        int n = 3;

        Solution test1 = new Solution();
        test1.merge(nums1, m, nums2, n);
        
        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }
}
