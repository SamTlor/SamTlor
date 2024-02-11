use std::fs::File;
use std::io::{BufRead, BufReader};



fn part_one(filepath: &str) -> Result<i32, Box<dyn std::error::Error>> {

    // Open and read the file
    let file = File::open(filepath)?;
    let reader = BufReader::new(file);


    // list of elves and how much they have
    let mut elves: Vec<i32> = vec![0];

    // the element of the array that corresponds to an elf
    let mut index: usize = 0;

    // Read the file line by line
    for line in reader.lines() {
        let line = line?;

        // try to convert to integer 
        let parsed_num: Result<i32, _> = line.parse();
        match parsed_num {

            // if it works add it to that elf
            Ok(num) => elves[index] += num,
            
            // otherwise it's found a new elf
            Err(_) => {
                elves.push(0);
                index += 1;
            }
        }
    }

    // return the max elf
    match elves.iter().max() {
        Some(max) => return Ok(*max),
        None      => return Ok(0)
    }
}



fn part_two(filepath: &str) -> Result<i32, Box<dyn std::error::Error>> {

    // Open and read the file
    let file = File::open(filepath)?;
    let reader = BufReader::new(file);


    // list of elves and how much they have
    let mut elves: Vec<i32> = vec![0];

    // the element of the array that corresponds to an elf
    let mut index: usize = 0;

    // Read the file line by line
    for line in reader.lines() {
        let line = line?;

        // try to convert to integer 
        let parsed_num: Result<i32, _> = line.parse();
        match parsed_num {

            // if it works add it to that elf
            Ok(num) => elves[index] += num,
            
            // otherwise make a new elf
            Err(_) => {
                elves.push(0);
                index += 1;
            }
        }
    }

    // sort it in ascending order
    elves.sort_unstable();

    // take the last three and sum it
    return  Ok(elves.iter().take(3).sum());

}







fn main() {
    
    match part_one("src/day1.txt"){
        Ok(ans) =>{
            println!("answer: {}", ans);
        }
        Err(e) => {
            eprintln!("Error: {}", e);
        }
    }
    
    match part_two("src/day1.txt"){
        Ok(ans) =>{
            println!("answer: {}", ans);
        }
        Err(e) => {
            eprintln!("Error: {}", e);
        }
    }

}
