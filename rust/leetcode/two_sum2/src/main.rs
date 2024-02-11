struct Solution;
impl Solution {
    pub fn two_sum(numbers: Vec<i32>, target: i32) -> Vec<i32> {
        let mut left = 0;
        let mut right = numbers.len() - 1;
        let mut sum = 0;
        let mut answer = Vec::new();

        while left < right {
            sum = numbers[left] + numbers[right];
            
            if sum == target{
                answer.push(left + 1);
                answer.push(right + 1);
            } else if sum < target {
                left += 1;
            } else {
                right -= 1;
            }
        }




    }
}

fn main() {
    println!("Hello, world!");
}
