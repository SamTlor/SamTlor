struct Solution;
impl Solution {
    pub fn is_palindrome(s: String) -> bool {
        let s: String = s
            .chars()
            .filter(|c| c.is_ascii_alphanumeric())
            .map(|c| c.to_ascii_lowercase())
            .collect();



        for i in 0..(s.len() / 2) {
            if let Some(letter) = s.chars().nth(i) {
                if let Some(end_letter) = s.chars().nth(s.len() - 1 - i) {
                    if letter != end_letter {
                        return false;
                    }
                }
            }

        }
        return true;
    }

    // pub fn is_palindrome(s: String) -> bool {
    //     let mut iter = s
    //         .chars()
    //         .filter(|c| c.is_alphanumeric())
    //         .map(|c| c.to_ascii_lowercase());

    //     iter.clone().eq(iter.rev())
    // }
}

fn main() {
    println!("{}", Solution::is_palindrome("ABA".to_string()));
}
