// use std::io;

// mod solutions {
//     pub mod day01;
// }




// fn main() {
//     // println!("Which day do you want to run?");
//     // let mut input = String::new();
    
//     // // Read user input
//     // io::stdin().read_line(&mut input).expect("Failed to read line");
//     // let input: usize = input.trim().parse().expect("Please enter a valid number");

//     let input = 1;


//     match input {
//         1 => day01::run(),
//         _ => println!("No function defined for input {}", input),
//     }
    
// }



mod solutions;
use solutions::day01::run;


fn main() {
    let input = 1;

    match input {
        1 => run(),
        _ => println!("error")
    }
}