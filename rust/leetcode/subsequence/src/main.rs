struct Solution;
impl Solution {
    pub fn is_subsequence(s: String, t: String) -> bool {

        if s.len() == 0 {
            return true;
        }

        let mut s_ptr: usize = 0;
        let mut t_ptr: usize = 0;


        while t_ptr < t.len() {
            if s.as_bytes()[s_ptr] == t.as_bytes()[t_ptr]{
                s_ptr += 1;
                if s_ptr == s.len() {
                    return true;
                }
            }
            t_ptr += 1;
        }

        return false;

    }
}

fn main() {

    let s = "".to_string();
    let t = "ahbgdc".to_string();


    println!("{}", Solution::is_subsequence(s, t));
}
