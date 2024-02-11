struct Solution;
impl Solution {
    pub fn jump(nums: Vec<i32>) -> i32 {
        let mut jumps: i32 = 0;
        let mut current_end: usize = 0;
        let mut reach: usize = 0;

        for i in 0..(nums.len() - 1) {
            reach = reach.max(i + nums[i] as usize);
            if i == current_end {
                jumps += 1;
                current_end = reach;
            }
        } 
        
        return jumps;
    }
}


fn main() {
    println!("{}", Solution::jump(vec![2,3,1,1,4]));
    println!("{}", Solution::jump(vec![2,3,0,1,4]));
}
