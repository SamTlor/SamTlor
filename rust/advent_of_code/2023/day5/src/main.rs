
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

        let seeds: Vec<i32> = line.trim().split_whitespace().filter_map(|x| x.parse().ok()).collect();
        for seed in seeds {
            // do stuff here
        }

        break;
    }

    Ok(ans)
}


fn part_two(filepath: &str) -> Result<i32, Box<dyn std::error::Error>> {

    //final return value
    let mut ans = 0;
    

    // loop through the file and store each line as a vector in full
    let file = File::open(filepath)?;
    let reader = BufReader::new(file);
    for line in reader.lines() {
        let line = line?;
    }

    Ok(ans)    
}



fn main() {
    match part_one("src/day5.txt"){
        Ok(ans) =>{
            println!("answer: {}", ans);
        }
        Err(e) => {
            eprintln!("Error: {}", e);
        }
    }


    
    match part_two("src/day5.txt"){
        Ok(ans) =>{
            println!("answer: {}", ans);
        }
        Err(e) => {
            eprintln!("Error: {}", e);
        }
    }
}
