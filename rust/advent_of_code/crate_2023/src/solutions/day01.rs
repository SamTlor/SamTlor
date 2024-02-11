pub mod day01 {
    
    
    use std::fs::File;
    use std::io::{BufRead, BufReader};
    use std::collections::HashMap;




        
    pub fn part_one(filepath: &str) -> Result<i32, Box<dyn std::error::Error>> {
        let file = File::open(filepath)?;
        let reader = BufReader::new(file);
        
        //final return value
        let mut ans = 0;

        //loop through the file
        for line in reader.lines() {
            // ? is to handle errors
            let line = line?;

            // to store numbers
            let mut nums = Vec::new();

            //go through the line char by char
            for c in line.chars() {

                //if this one is a number then save it in nums
                if c.is_digit(10) {
                    nums.push(c.to_digit(10).unwrap_or(0) as i32);
                }
            }

            // (first * 10) + last
            ans += nums[0] * 10 + nums[nums.len() - 1];
        }

        Ok(ans)
    }





    pub fn part_two(filepath: &str) -> Result<i32, Box<dyn std::error::Error>> {
        let file = File::open(filepath)?;
        let reader = BufReader::new(file);

        

        let mut three: HashMap<&str, i32> = HashMap::new();
        three.insert("one", 1);
        three.insert("two", 2);
        three.insert("six", 6);

        let mut four: HashMap<&str, i32> = HashMap::new();
        four.insert("four", 4);
        four.insert("five", 5);
        four.insert("nine", 9);
        
        let mut five: HashMap<&str, i32> = HashMap::new();
        five.insert("three", 3);
        five.insert("seven", 7);
        five.insert("eight", 8);


        let mut ans = 0;
        for line in reader.lines() {

            // ? is to handle errors
            let line = line?;


            let mut nums: Vec<i32> = Vec::new();
            for (index, character) in line.char_indices() {

                // just like part 1
                if character.is_digit(10) {
                    nums.push(character.to_digit(10).unwrap_or(0) as i32);
                }

                // for the others get a slice the size of the words you'll look through
                // if there's an out of bounds error nothing will get pushed
                if let Some(slice) = line.get(index..index + 3){
                    if let Some(value) = three.get(slice){
                        nums.push(*value);
                    }
                }
                
                if let Some(slice) = line.get(index..index + 4){
                    if let Some(value) = four.get(slice){
                        nums.push(*value);
                    }
                }
                
                if let Some(slice) = line.get(index..index + 5){
                    if let Some(value) = five.get(slice){
                        nums.push(*value);
                    }
                }

            }

            // same as part 1
            if !nums.is_empty(){
                ans += nums[0] * 10 + nums[nums.len() - 1];
            }

        }

        Ok(ans)
    }




    pub fn run(){
        match part_one("data/day1.txt"){
            Ok(ans) =>{
                println!("answer: {}", ans);
            }
            Err(e) => {
                eprintln!("Error: {}", e);
            }
        }


        
        match part_two("data/day1.txt"){
            Ok(ans) =>{
                println!("answer: {}", ans);
            }
            Err(e) => {
                eprintln!("Error: {}", e);
            }
        }
    }
}