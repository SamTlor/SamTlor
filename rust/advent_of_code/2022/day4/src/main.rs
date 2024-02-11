use std::fs::File;
use std::io::{BufRead, BufReader};

fn part_one(filepath: &str) -> Result<i32, Box<dyn std::error::Error>> {
    let mut count = 0;

    // Open the file
    let file = File::open(filepath)?;
    let reader = BufReader::new(file);

    // Read the file line by line
    for line in reader.lines() {
        let line = line?;
        let parts: Vec<&str> = line.split(',').collect();

        // Assuming each line has exactly two comma-separated values
        // breaks into elf1 and elf2 here 
        if let [elf1, elf2] = &parts[..] {
            let elf1_parts: Vec<&str> = elf1.split('-').collect();
            let elf2_parts: Vec<&str> = elf2.split('-').collect();

            // breaks elf1 into its min and max here
            if let [elf1_min, elf1_max] = &elf1_parts[..] {

                // breaks elf2 into its min and max here
                if let [elf2_min, elf2_max] = &elf2_parts[..] {

                    // turns everything into ints here
                    let elf1_min = elf1_min.parse::<i32>().unwrap();
                    let elf1_max = elf1_max.parse::<i32>().unwrap();
                    let elf2_min = elf2_min.parse::<i32>().unwrap();
                    let elf2_max = elf2_max.parse::<i32>().unwrap();


                    let minmin = elf1_min.min(elf2_min);
                    let maxmax = elf1_max.max(elf2_max);

                    let comparor = (minmin, maxmax);
                    if comparor == (elf1_min, elf1_max) || comparor == (elf2_min, elf2_max) {
                        count += 1;
                    }
                }
            }
        }
    }

    Ok(count)
}


fn part_two(filepath: &str) -> Result<i32, Box<dyn std::error::Error>> {
    let mut count = 0;

    // Open the file
    let file = File::open(filepath)?;
    let reader = BufReader::new(file);

    // Read the file line by line
    for line in reader.lines() {
        let line = line?;
        let parts: Vec<&str> = line.split(',').collect();

        // Assuming each line has exactly two comma-separated values
        // breaks into elf1 and elf2 here 
        if let [elf1, elf2] = &parts[..] {
            let elf1_parts: Vec<&str> = elf1.split('-').collect();
            let elf2_parts: Vec<&str> = elf2.split('-').collect();

            // breaks elf1 into its min and max here
            if let [elf1_min, elf1_max] = &elf1_parts[..] {

                // breaks elf2 into its min and max here
                if let [elf2_min, elf2_max] = &elf2_parts[..] {

                    // turns everything into ints here
                    let elf1_min = elf1_min.parse::<i32>().unwrap();
                    let elf1_max = elf1_max.parse::<i32>().unwrap();
                    let elf2_min = elf2_min.parse::<i32>().unwrap();
                    let elf2_max = elf2_max.parse::<i32>().unwrap();

                    // compares them here
                    if (elf1_min <= elf2_min && elf2_min <= elf1_max) || (elf2_min <= elf1_min && elf1_min <= elf2_max) {
                        
                        // increments count here
                        count += 1;
                    }
                }
            }
        }
    }

    // returns count
    Ok(count)
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
