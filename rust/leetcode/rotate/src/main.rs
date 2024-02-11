struct Solution;
impl Solution {
    pub fn rotate(nums: &mut Vec<i32>, k: i32) {

        //you don't need to do anything if the array is just one element
        if (nums.len() as i32) <= 1 {
            return;
        } 

        //if k is too big then it won't work so k = k % len
        let k = k % nums.len() as i32;
        
        //use these two numbers to split the vector in two
        let minus_k = nums.len() - (k as usize);
        let len = nums.len();

        //the end of the original vector stored as a vector
        let mut end = nums[minus_k..len].to_vec();
        
        //so that we can extend it it with the beginning 
        end.extend_from_slice(&nums[0..minus_k]);

        //then put it into nums
        nums.clone_from(&end);
        
    }
}





fn main() {
    let mut nums: Vec<i32> = vec![1,2,3,4,5,6,7];
    let k = 3;
    


    Solution::rotate(&mut nums, k);
    println!("{:?}", nums);
    
}