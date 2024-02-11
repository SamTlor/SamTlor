struct Solution;
impl Solution {
    pub fn remove_element(nums: &mut Vec<i32>, val: i32) -> i32 {

        //store length of the array so that i can go from 0 -> n
        let mut i = 0;
        let mut n = nums.len();

        // O(n) 
        while i < n{

            //if the value is found
            if nums[i] == val{
                
                //move the value to the end of the array
                nums.swap(i, n - 1);

                //decrementing n makes it so that n becomes
                // 1) a pointer to the useful part of the array
                //      because it starts at the end of the array and moves backward
                // 2) a counter for the amount of elems that arent val
                //      because it decrements everytime an elem is val
                // 3) useful to i because i can do all of the heavy lifting
                n -= 1;
            } else {
                i += 1;
            }
        }

        n as i32
    }
}




fn main(){
    let mut nums: Vec<i32> = vec![0,1,2,2,3,0,4,2];
    let val = 2;

    

    let count = Solution::remove_element(&mut nums, val);
    
    
    
    println!("{:?}", &nums[..count as usize]);
}