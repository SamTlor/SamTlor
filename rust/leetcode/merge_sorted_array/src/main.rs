struct Solution;
impl Solution {
    //The merge function takes mutable references because if it accepted actual vectors
    //then the ownership of the vectors would be passed to this function. The main 
    //function wouldn't be able to send the vectors back easily. 
    pub fn merge(nums1: &mut Vec<i32>, m: i32, nums2: &mut Vec<i32>, n: i32) {
        
        // (m and n) - 1 to account for array indexing
        //m and n are pointers to different indexes in the two different inputs
        //current is a pointer to the target location of the return array
        let mut m = m as usize;
        let mut n = n as usize;
        let mut current = m  + n - 1;

        //the function works backwards
        while current > 0 && m > 0 && n > 0 {

            //it places the bigger element at the current location
            if nums1[m - 1] > nums2[n - 1]{
                nums1[current] = nums1[m - 1];
                m -= 1;
            } else {
                nums1[current] = nums2[n - 1];
                n -= 1;
            }
            current -= 1;
        }



        // if all of nums2 elements are smaller than nums1 elements
        while n > 0 {
            nums1[current] = nums2[n - 1];
            if n == 0 || current == 0{
                break;
            }
            n -= 1;
            current -= 1;
        }



        //no need for a return line because rust implicitly returns the last 
        //expression in this case it's the while loop which has a return type of ()

    }
}



fn main(){
    let mut nums1: Vec<i32> = vec![1, 2, 3, 0, 0, 0];
    let m = 3;
    let mut nums2: Vec<i32> = vec![2, 5, 6];
    let n = 3;

    
    Solution::merge(&mut nums1, m, &mut nums2, n);
    println!("{:?}", nums1);
}