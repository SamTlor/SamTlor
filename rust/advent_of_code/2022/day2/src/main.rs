use std::fs::File;
use std::io::{BufRead, BufReader};
use std::collections::HashMap;



// A + X = 0    draw        -1 + 1
// A + Y = 1    win         -1 + 2
// A + Z = 2    lose        -1 + 3

// B + X = -1   lose        -2 + 1
// B + Y = 0    draw        -2 + 2
// B + Z = 1    win         -2 + 3

// C + X = -2   win         -3 + 1 
// C + Y = -1   lose        -3 + 2 
// C + Z = 0    draw        -3 + 3 

// win = 1 or -2        
// draw = 0         
// lose = 2 or -1       



fn part_one(filepath: &str) -> Result<i32, Box<dyn std::error::Error>> {
    // for the final return
    let mut ans = 0;

    // value of your hand and converting op's hand so you can use math
    let mut vals: HashMap<&str, i32> = HashMap::new();
    vals.insert("A", -1);
    vals.insert("B", -2);
    vals.insert("C", -3);
    vals.insert("X", 1);
    vals.insert("Y", 2);
    vals.insert("Z", 3);



    // Open the file and read it line by line. 
    // ? for error handling
    let file = File::open(filepath)?;
    let reader = BufReader::new(file);
    for line in reader.lines() {
        let line = line?;

        // divide each line into op's hand and my hand
        let parts: Vec<&str> = line.split(' ').collect();
        if let [op, me] = &parts[..] {

            // like the beginning says a win is 1 or -2 and 0 is draw
            // only other scenario is lose
            let shoot = vals[op] + vals[me];
            match shoot {
                1 | -2 => ans += 6,
                0 => ans += 3,
                _ => ans += 0
            }

            // always include the value of my hand
            ans += vals[me];
        }
    }


    return Ok(ans);
}



fn part_two(filepath: &str) -> Result<i32, Box<dyn std::error::Error>> {
    // for the final return
    let mut ans = 0;

    // value of your hand and converting op's hand so you can use math
    let mut vals: HashMap<&str, usize> = HashMap::new();
    vals.insert("A", 0);
    vals.insert("B", 1);
    vals.insert("C", 2);
    vals.insert("X", 0);
    vals.insert("Y", 1);
    vals.insert("Z", 2);

    // rock, paper, scissors for the rows
    // lose, draw, win for the columns
    let scoreboard: [[i32; 3]; 3] = [   [3, 4, 8], 
                                        [1, 5, 9], 
                                        [2, 6, 7] ];

    // Open the file and read it line by line. 
    // ? for error handling
    let file = File::open(filepath)?;
    let reader = BufReader::new(file);
    for line in reader.lines() {
        let line = line?;

        // divide each line into op's hand and my hand
        let parts: Vec<&str> = line.split(' ').collect();
        if let [op, me] = &parts[..] {

            // use scorecard to add to ans
            ans += scoreboard[vals[op]][vals[me]];
        }
    }

    return Ok(ans);
}





fn main() {
    match part_one("src/day2.txt"){
        Ok(ans) =>{
            println!("answer: {}", ans);
        }
        Err(e) => {
            eprintln!("Error: {}", e);
        }
    }

    match part_two("src/day2.txt"){
        Ok(ans) =>{
            println!("answer: {}", ans);
        }
        Err(e) => {
            eprintln!("Error: {}", e);
        }
    }
}
