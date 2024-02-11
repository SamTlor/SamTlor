/*

Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11

*/

use std::fs::File;
use std::io::{BufRead, BufReader};
use std::collections::HashMap;



fn part_one(filepath: &str) -> Result<i32, Box<dyn std::error::Error>> {

    //final return value
    let mut ans = 0;



    // loop through the file and store each line as a vector in full
    let file = File::open(filepath)?;
    let reader = BufReader::new(file);
    for line in reader.lines() {
        let line = line?;

        let parts: Vec<&str> = line.split("|").collect();

        let nums1: Vec<i32> = parts[0].trim().split_whitespace().filter_map(|x| x.parse().ok()).collect();
        let nums2: Vec<i32> = parts[1].trim().split_whitespace().filter_map(|x| x.parse().ok()).collect();

        let mut count = 0;
        for i in nums2 {
            if nums1.contains(&i){
                count += 1;
            }
        }


        if count > 0 {
            ans += i32::pow(2, count - 1);
        }
    }

    Ok(ans)
}


fn part_two(filepath: &str) -> Result<i32, Box<dyn std::error::Error>> {

    //final return value
    let mut ans = 0;
    let mut cards: HashMap<usize, i32> = HashMap::new();
    let mut current: usize = 1;


    // loop through the file and store each line as a vector in full
    let file = File::open(filepath)?;
    let reader = BufReader::new(file);
    for line in reader.lines() {
        let line = line?;

        // split the line in two and get just the numbers 
        let parts: Vec<&str> = line.split("|").collect();
        let nums1: Vec<i32> = parts[0].trim().split_whitespace().filter_map(|x| x.parse().ok()).collect();
        let nums2: Vec<i32> = parts[1].trim().split_whitespace().filter_map(|x| x.parse().ok()).collect();

        // counts the wins for this line
        let mut count = 0;
        for i in nums2 {
            if nums1.contains(&i){
                count += 1;
            }
        }

        // include the given scorecard
        *cards.entry(current).or_insert(0) += 1;


        let this_value = cards[&current];
        for i in (current + 1)..(current + count as usize + 1) {
            *cards.entry(i).or_insert(0) += this_value;
        }

        // add to answer
        ans += this_value;

        // increment the HashMap
        current += 1;
    }



    Ok(ans)
}



fn main() {
    match part_one("src/day4.txt"){
        Ok(ans) =>{
            println!("answer: {}", ans);
        }
        Err(e) => {
            eprintln!("Error: {}", e);
        }
    }


    
    match part_two("src/day4.txt"){
        Ok(ans) =>{
            println!("answer: {}", ans);
        }
        Err(e) => {
            eprintln!("Error: {}", e);
        }
    }
}
