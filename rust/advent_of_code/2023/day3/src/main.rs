use std::fs::File;
use std::io::{BufRead, BufReader};
use std::collections::HashMap;



// gets a vector of indices that surround the elements full[row][start..end]
fn get_surrounding(full: &Vec<Vec<char>>, row: usize, start: usize, end: usize) -> Vec<(usize, usize)> {

    // make a vector of possible indices to look at
    let mut indices: Vec<(usize, usize)> = Vec::new();


    // row - 1 => row + 2 because it's exclusive and you want to get three rows
    for row_iterator in (row as i32 - 1)..(row as i32 + 2){
        
        // for if the number is on the first or last line of the input
        if row_iterator == -1 || row_iterator == full.len() as i32 {
            continue;
        }

        // same logic as above for the row_iterator
        for col_iterator in (start as i32 - 1)..(end as i32  + 1) {

            // for if the number is on the first or last element of the row
            if col_iterator == -1 || col_iterator == full[row_iterator as usize].len() as i32 {
                continue;
            } 

            // if the indices want to get the elements that are the number
            if (row_iterator == row as i32) && (col_iterator >= start as i32 && col_iterator < end as i32) {
                continue;
            }
            
            // if nothing else has made this one skip then add it to the list
            else {
                indices.push((row_iterator as usize, col_iterator as usize));
            }
        }

    }

    return indices;
}


fn part_one(filepath: &str) -> Result<i32, Box<dyn std::error::Error>> {

    //final return value
    let mut ans = 0;

    // input is the raw input that we'll check later
    // visit is the indices we'll use to look through input later
    let mut input: Vec<Vec<char>> = Vec::new();
    let mut visit: HashMap<(usize, usize, usize), i32> = HashMap::new();



    // loop through the file and store each line as a vector in full
    let file = File::open(filepath)?;
    let reader = BufReader::new(file);

    // enumerate to store the index of the row for use in the vectors
    for (row_ind, line) in reader.lines().enumerate() {
        let line = line?;

        // store the data in input as a vector of chars
        let line_chars: Vec<char> = line.chars().collect();

        // loop through the line to find any numbers
        let mut col_ind: usize = 0;
        while col_ind < line_chars.len(){

            // if it finds a number
            if line_chars[col_ind].is_digit(10){

                // store the place where it starts
                let start: usize = col_ind;

                // store the number we find
                let mut number: Vec<char> = Vec::new();
                while col_ind < line_chars.len() && line_chars[col_ind].is_digit(10) {
                    number.push(line_chars[col_ind]);
                    col_ind += 1;
                }
                
                // col_ind will be where the number ends
                let temp: String = number.iter().collect();
                let num: i32 = temp.parse().unwrap();
                visit.insert((row_ind, start, col_ind), num);
            }

            // continue looping through the line and file
            col_ind += 1;
        }

        // store the raw input for searching later
        input.push(line_chars);
    }


    // i.0 is row, i.1 is start, i.2 is end.    number is the number we found
    for (i, number) in visit {

        // check all of the indices around the number
        let indices = get_surrounding(&input, i.0, i.1, i.2);
        for index in indices {

            // only add the number when you've found a '.'
            if input[index.0][index.1] != '.' {
                ans += number;

                break;
            }
        }
    }

    Ok(ans)
}


fn part_two(filepath: &str) -> Result<i32, Box<dyn std::error::Error>> {

    //final return value
    let mut ans = 0;

    // input is the raw input that we'll check later
    // visit is the indices we'll use to look through input later
    let mut input: Vec<Vec<char>> = Vec::new();
    let mut visit: HashMap<(usize, usize, usize), i32> = HashMap::new();



    // loop through the file and store each line as a vector in full
    let file = File::open(filepath)?;
    let reader = BufReader::new(file);

    // enumerate to store the index of the row for use in the vectors
    for (row_ind, line) in reader.lines().enumerate() {
        let line = line?;

        // store the data in input as a vector of chars
        let line_chars: Vec<char> = line.chars().collect();

        // loop through the line to find any numbers
        let mut col_ind: usize = 0;
        while col_ind < line_chars.len(){

            // if it finds a number
            if line_chars[col_ind].is_digit(10){

                // store the place where it starts
                let start: usize = col_ind;

                // store the number we find
                let mut number: Vec<char> = Vec::new();
                while col_ind < line_chars.len() && line_chars[col_ind].is_digit(10) {
                    number.push(line_chars[col_ind]);
                    col_ind += 1;
                }
                
                // col_ind will be where the number ends
                let temp: String = number.iter().collect();
                let num: i32 = temp.parse().unwrap();
                visit.insert((row_ind, start, col_ind), num);
            }

            // continue looping through the line and file
            col_ind += 1;
        }

        // store the raw input for searching later
        input.push(line_chars);
    }

    
    // the tuple is the index of the gear that has been found 
    // the i32 is the number that is next to that gear
    let mut gears: HashMap<(usize, usize), i32> = HashMap::new();

    // i.0 is row, i.1 is start, i.2 is end.    number is the number we found
    for (i, number) in visit {

        // check all of the indices around the number
        let indices = get_surrounding(&input, i.0, i.1, i.2);
        for index in indices {


            // if we find a gear then we'll
            if input[index.0][index.1] == '*' {

                // see if we've seen this exact gear before
                if gears.contains_key(&(index.0, index.1)) {
                    
                    // and then get the number that has been attached to that gear
                    match gears.get(&(index.0, index.1)){

                        // and multiply it by the number we brought from visit on line 182 and add it to ans
                        Some(value) => ans += number * value,
                        None => println!("no val")
                    }
                } 

                // if we haven't seen this gear before remember that we have seen it for next time ^^
                else {
                    gears.insert((index.0, index.1), number);
                }

                // numbers don't touch multiple gears so break after we find one gear
                break;
            }
        }
    }

    Ok(ans)
}





fn main() {
    match part_one("src/day3.txt"){
        Ok(ans) =>{
            println!("answer: {}", ans);
        }
        Err(e) => {
            eprintln!("Error: {}", e);
        }
    }


    
    match part_two("src/day3.txt"){
        Ok(ans) =>{
            println!("answer: {}", ans);
        }
        Err(e) => {
            eprintln!("Error: {}", e);
        }
    }
}