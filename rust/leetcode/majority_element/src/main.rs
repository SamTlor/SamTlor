struct Solution;
impl Solution {

    //this doesn't need a mutable referecne because 
    //  all this function does is read the array
    //finds the element that makes up more than half of the input list
    pub fn majority_element(nums: Vec<i32>) -> i32 {

        //store the current most seen elem val and count
        let mut most = nums[0];
        let mut count = 1;

        //skip the first one cuz we did that already ^
        for &i in nums.iter().skip(1) {

            if i == most {
                count += 1;
            } 
            
            else {
                if count == 0 {
                    most = i;
                    count = 1;
                } else {
                    count -= 1;
                }
            }
        }

        return most;
    }
}

fn main() {


    
    let nums1: Vec<i32> = vec![3,2,3];

    let count1 = Solution::majority_element( nums1);
    println!("count1: {}", count1);





    let nums2: Vec<i32> = vec![0,1,2,3,4,5,6,7,8,3,9];
    
    let count2 = Solution::majority_element( nums2);
    println!("count2: {}", count2);
}