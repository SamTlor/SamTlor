use std::fs::File;
use std::io::{self, BufRead, BufReader};
use std::collections::HashSet;



fn part_one(filepath: &str) -> Result<i32, Box<dyn std::error::Error>> {
    // for the final return
    let mut ans = 0;



    // Open the file and read it line by line. 
    // ? for error handling
    let file = File::open(filepath)?;
    let reader = BufReader::new(file);
    for line in reader.lines() {
        let line = line?;

        // save the two halves of the line as seperate variables
        if let Some(one) = line.get(0..line.len() / 2){
            if let Some(two) = line.get(line.len() / 2 .. line.len()) {

                // i don't bother with cloning to save memory but maybe I should for safety
                // save the string as a vector of chars
                let one_chars: HashSet<_> = one.chars().collect();
                let two_chars: HashSet<_> = two.chars().collect();



                // so i can find the intersection between the two vectors

                // the intersection() function needs a reference to the second HashSet
                // instead of the real thing because then it would take ownership of it
                // this way it just borrows what's there then gives it back. That also 
                // means that it returns references to chars not actual chars
                let intersection: Vec<&char> = one_chars.intersection(&two_chars).collect();



                // we know there's only one element that intersects so get it

                // next() returns Option<> because it might return empty so we need Some().
                // Inside the Option<> it returns &T where T is the type of the vector.
                // In this case T is &&char because it's a reference to an intersection() which
                // is a reference to a char. So to get the actual value we would need to 
                // dereference it twice. The &c in the Some is a reference to an element that
                // is returned from the next() in Option. c is a reference to the element in 
                // intersection. *c allows you to actually get the value we're looking at.
                // as i32 won't work on a reference so we need to dereference it
                if let Some(&c) = intersection.iter().next(){

                    // and use it to add to ans 
                    ans += match c {
                        'a'..='z' => (*c as i32 - 'a' as i32) + 1,
                        'A'..='Z' => (*c as i32 - 'A' as i32) + 27,
                        _ => 0
                    }
                }


            }
        }
    }

    return Ok(ans);
}



fn read_three_lines(filepath: &str) -> Result<Vec<Vec<String>>, io::Error> {
    let file = File::open(filepath)?;
    let reader = BufReader::new(file);

    let mut lines_iter = reader.lines().peekable();
    let mut result = Vec::new();

    while let Some(line1) = lines_iter.next() {
        let line1 = line1?;
        let mut chunk = vec![line1];
        
        if let Some(line2) = lines_iter.next() {
            let line2 = line2?;
            chunk.push(line2);

            if let Some(line3) = lines_iter.next() {
                let line3 = line3?;
                chunk.push(line3);
            }
        }

        result.push(chunk);
    }

    Ok(result)
}



fn part_two(filepath: &str) -> Result<i32, Box<dyn std::error::Error>> {
    // for the final return
    let mut ans = 0;



    match read_three_lines(filepath) {
        Ok(lines) => {
            for chunk in lines {
                let one: HashSet<_> = chunk[0].chars().collect();
                let two: HashSet<_> = chunk[1].chars().collect();
                let thr: HashSet<_> = chunk[2].chars().collect();

                // one_and_two needs to be cloned so that it can be intersectioned with
                // chars not references to chars like how intersection usually returns
                let one_and_two: HashSet<_> = one.intersection(&two).cloned().collect();
                let intersection: Vec<_> = one_and_two.intersection(&thr).collect();

                if let Some(&c) = intersection.iter().next(){

                    // and use it to add to ans 
                    ans += match c {
                        'a'..='z' => (*c as i32 - 'a' as i32) + 1,
                        'A'..='Z' => (*c as i32 - 'A' as i32) + 27,
                        _ => 0
                    }
                }

            }
        }

        Err(e) => eprintln!("err {}", e)
    }

    return Ok(ans);
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
