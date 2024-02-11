struct Solution;
impl Solution {
    pub fn candy(ratings: Vec<i32>) -> i32 {

        let index = ratings.iter().position(|&x| x == ratings.iter().cloned().min().unwrap_or_default()).unwrap_or_default();


        return ratings[index];
    }
}



fn main() {
    let ratings: Vec<i32> = vec![1, 0, 2];

    println!("{}", Solution::candy(ratings));
}