struct Solution;
impl Solution {

    //this works because 
    pub fn max_profit(prices: Vec<i32>) -> i32 {

        if prices.len() < 2 {
            return 0;
        }
        
        //max stores the maximum profit seen so far
        let mut max = 0;

        //start is pointer 1
        let mut start: usize = 0;

        //end is pointer 2
        let mut end: usize = 1;

        //while pointer 2 is still moving forward
        while end < prices.len() {

            //if pointer 1 is less than pointer 2 profit could be made
            if prices[start] < prices[end]{

                //so see if it is the max profit
                max = max.max(prices[end] - prices[start]);
            } 
            
            //otherwise move pointer 1 up. which ends up finding the min value 
            //where profit could be made
            else {
                start = end;
            }

            //always move up pointer 2
            end += 1;
        }

        return max;

    }
}


fn main() {
    let nums = vec![7,1,5,3,6,4];

    println!("{}", Solution::max_profit(nums));
}
