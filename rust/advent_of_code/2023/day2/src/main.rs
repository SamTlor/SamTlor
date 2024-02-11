use std::fs::File;
use std::io::{BufRead, BufReader};
// use std::collections::HashMap;

fn part_one(filepath: &str) -> Result<i32, Box<dyn std::error::Error>> {
    let file = File::open(filepath)?;
    let reader = BufReader::new(file);
    
    //final return value
    let mut ans = 0;



    //loop through the file
    'next_game: for line in reader.lines() {
        // ? is to handle errors
        let line = line?;

        // split the line on the : to get the game number and the hands
        let parts: Vec<&str> = line.split(":").collect();
        if let [game_info, hands] = &parts[..] {

            // split on whitespace to get different words and then parse the number
            let game_str: Vec<&str> = game_info.split_whitespace().collect();
            let game_number = game_str[1].parse::<i32>().unwrap();

            // split the hands on ;
            let start: Vec<&str> = hands.split(";").collect();
            for game in start.iter() {

                // split the hand on ,
                let cubes: Vec<&str> = game.split(",").collect();
                for cube in cubes {

                    // split on whitespace the color is first and then the number
                    let tokens: Vec<&str> = cube.split_whitespace().collect();
                    let color = tokens.last().unwrap();
                    let tester = tokens[0].parse::<i32>().unwrap();


                    // switch statement on color but &&str -> &str
                    match *color {

                        // hardcoded comparisons for r,g,b
                        // continue will skip ans but break wouldn't
                        "red" => {
                            if tester > 12 {
                                continue 'next_game;
                            }
                        }
                        "green" => {
                            if tester > 13 {
                                continue 'next_game;
                            }
                        }
                        "blue" => {
                            if tester > 14 {
                                continue 'next_game;
                            }
                        }
                        _ => {}
                    }
                }
            }

            // this will only run if none of the if statements run
            ans += game_number;

        }
    }

    return Ok(ans);
}





fn part_two(filepath: &str) -> Result<i32, Box<dyn std::error::Error>> {
    let file = File::open(filepath)?;
    let reader = BufReader::new(file);
    
    //final return value
    let mut ans = 0;




    //loop through the file
    for line in reader.lines() {
        // ? is to handle errors
        let line = line?;

        // split on : and then don't bother with the game number part
        let parts: Vec<&str> = line.split(":").collect();
        let hands = &parts[1];

        // init to 1 so when multiplied by each other ans doesn't = 0
        let mut red_max: i32 = 1;
        let mut gre_max: i32 = 1;
        let mut blu_max: i32 = 1;

        // split into games on ;
        let start: Vec<&str> = hands.split(";").collect();
        for game in start.iter() {

            // same as part 1
            let cubes: Vec<&str> = game.split(",").collect();
            for cube in cubes {
                let tokens: Vec<&str> = cube.split_whitespace().collect();
                let color = tokens.last().unwrap();
                let tester = tokens[0].parse::<i32>().unwrap();



                match *color {

                    // find max
                    "red" => red_max = red_max.max(tester),
                    "green" => gre_max = gre_max.max(tester),
                    "blue" => blu_max = blu_max.max(tester),
                    _ => {}
                }
            }
        }

        // self explanitory
        ans += red_max * gre_max * blu_max;
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
