use std::fs;
use std::fs::File;
use std::io::{BufReader, BufRead, Read};
// BufReader for reader, BufRead for reader.lines(), Read for file.read





// returns one single string or an error message
fn read_file_string(filepath: &str) -> Result<String, Box<dyn std::error::Error>> {
    let data = fs::read_to_string(filepath)?;
    Ok(data)
}

// returns as an entire vector. this goes letter by letter
fn read_file_vec(filepath: &str) -> Result<Vec<u8>, Box<dyn std::error::Error>> {
    let data = fs::read(filepath)?;
    Ok(data)
}

// doesn't return anything because it works all within this function
fn read_file_line_by_line(filepath: &str) -> Result<(), Box<dyn std::error::Error>> {
    let file = File::open(filepath)?;
    let reader = BufReader::new(file);

    //iterate through each line
    for line in reader.lines() {
        // ? is to unwrap or handle the potential error
        println!("{}", line?);
        //processing the line can be done here as well
    }

    Ok(())
}

//same as ^ but it reads it chunk by chunk instead
fn read_file_buffer(filepath: &str) -> Result<(), Box<dyn std::error::Error>> {
    const BUFFER_LEN: usize = 512;
    let mut buffer = [0u8; BUFFER_LEN];
    let mut file = File::open(filepath)?;

    loop {
        match file.read(&mut buffer){
            Ok(0) => break,                            // end of the file
            Ok(read_count) => {                 // contents of the buffer
                println!("{}", String::from_utf8_lossy(&buffer[..read_count]));
            }
            Err(e) => return Err(Box::new(e))   // something went wrong
        }
    }

    Ok(())
}





fn main() {

    // filepath is based on the directory that cargo.toml is in 



    println!("\n\n\n"); //for formatting
    // you can access the whole thing in one variable
    match read_file_string("src/text.txt") {
        Ok(data) => {
            println!("{}", data);
        }
        Err(e) => {
            eprint!("error: {}", e);
        }
    }


    println!("\n\n\n"); //for formatting
    // match is like a switch case statement. it can be used for error handling
    match read_file_vec("src/text.txt") {
        Ok(data) => {
            for &j in data.iter() {
                print!("{}", char::from(j));
            }
        } 

        Err(err) => {
            eprintln!("An error occurred: {}", err);
        }
    }



    println!("\n\n\n"); //for formatting
    // the function reads the file line by line. printing will run in the function
    let _ = read_file_line_by_line("src/text.txt");



    println!("\n\n\n"); //for formatting
    // same as ^
    let _ = read_file_buffer("src/text.txt");
}