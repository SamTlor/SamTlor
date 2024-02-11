struct Solution;
impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {

        // let mut i = 0;
        // let mut j = 1;



        // while i < nums.len(){
        //     if nums[j - 1] == nums[i] {
        //         i += 1;
        //     } else {
        //         nums[j] = nums[i];
        //         j += 1;
        //     }
        // }

        // return j as i32;


        //prev is starting and amount of unique elems in nums
        let mut prev = 0;

        //i = 1 to len of nums to look at every elem
        for i in 1..nums.len() {

            //if a new unique elem has been found
            if nums[prev] != nums[i] {
                prev += 1;
                nums[prev] = nums[i];
            }
        }

        return (prev + 1) as i32;

    }
}



fn main() {
    let mut nums: Vec<i32> = vec![0,0,1,1,1,2,2,3,3,4];

    

    let count = Solution::remove_duplicates(&mut nums);
    
    
    println!("count {}", count);
    println!("{:?}", &nums[..count as usize]);
}
