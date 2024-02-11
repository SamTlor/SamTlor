struct Solution;
impl Solution {

    //this works because it just has to see if there is profit on a case by case
    //basis not on the whole thing. an extra loop to find the most profitable end
    //point is extra. just do if 1 - 7 > 0 add it to max. if 5 - 1 > 0 add it it max
    pub fn max_profit(prices: Vec<i32>) -> i32 {

        let mut i: usize = 1;
        let mut max: i32 = 0;
        while i < prices.len() {
            if prices[i] - prices[i - 1] > 0 {
                max += prices[i] - prices[i - 1];
            }

            i += 1;
        }

        return max;

    }
}


fn main() {
    let nums = vec![7,1,5,3,6,4];

    println!("{}", Solution::max_profit(nums));
}
