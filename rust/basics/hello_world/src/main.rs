//HOW TO MAKE FILE AND RUN IT
// to create a new directory and file use:
//cargo new [name]

// that creates a folder called [name]
// to run use:
//cargo run





//HOW TO KNOW INFO ABOUT THIS PROGRAM. LIKE DEPENDENCIES 
// Cargo.toml 
//the manifest file for Rust. 
//It’s where you keep metadata for your project, as well as dependencies.

// to add dependencies
//after the "[dependencies]" line add [dependency name] = "[version number]"
//or in a terminal use: cargo add [dependency name] and then cargo build

// cargo.lock
//this is a log of the exact versions of the dependencies we're using locally

// to import the dependency or specific functions use:
//use [dependency name]::*;
//use [dependency name]::[dependency function];
//use [dependency name]::{[dependency1, dependency2]};

use ferris_says::*;
use std::io::{stdout, BufWriter};





//CLASSES
//to instantiate a class use: stuct [Name]
//to define the class use impl
struct Class;
impl Class {

    //FUNCTIONS
    //to define a function use: fn
    //to make it public use: pub
    //to make it private use: priv

    //to specify return type use: -> [type]
    //to maybe specify a return type or not use: Option<[possible type]>
    fn hello() -> Option<String> {

        if false {
            Some("to have a function with the return type Option you have \
                    to return a Some() or a None".to_string())
        } else {
            //print! for same line 
            print!("He");
            print!("ll");

            //println! for a new line after
            println!("o ");



            //all together this prints out 'Hello \n'
            None
        }
    }
}





//VARIABLES
//use the let keyword
//variables are immutable by default unless you use: mut
//type is inferred if you want to say what type use: :[type]
//you can use a variable to redeclare a variable that is immutable
//constants are always immutable and must have a specified type
//scope is limited to the {} that a variable is defined in

//bulit in variable types are integers, floating-point numbers, booleans, characters, 
//                            and compound types like tuples and arrays/vectors

fn world(){
    //setting a variable equal to single quotes means it's a char
    let comma: char = ',';

    //setting a string variable with double quotes makes it a string pointer
    let ending = " w";

    //so to use it later you have to use to_string() on it
    //but if you use it on one part of an additional thing you don't need to 
    // use it for anything in the rest of the line. this is me using a variable
    // to redeclare a variable that is immutable
    //so for this comma needs a to_string() but ending doesn't
    let ending = comma.to_string() + ending + "orld!\n\n";

    //this is how you do f strings
    //there is no other type of print statement
    println!("{}", ending);





    //this is how you create the other TYPES of variables
    // _ before the variable to let compiler know it's unused on purpose
    let _number: i32 = 42; // Signed 32-bit integer
    let _is_true: bool = true; // Boolean
    let _character: char = 'A'; // Character
    let _float_number: f64 = 3.14; // 64-bit floating-point number
}





fn arrays() {
    
    //this is how you create ARRAYS [type; length]
    //arrays have a fixed size at compile time
    let mut numbers: [i32; 5] = [1, 2, 3, 4, 5];

    //this is how you ACCESS THE ARRAY AND CHANGE IT but only if it is mutable
    println!("First element: {}", numbers[0]);
    numbers[0] = 0;
    println!("First element again: {}", numbers[0]);
    println!("All elements: {:?}", numbers);

    //this is how you access a SLICE from the array (exclusive)
    println!("Some elements: {:?}", &numbers[0..3]);





    //this is how you create VECTORS Vec<type> 
    //vectors don't have a fixed size at compile time
    let mut numbers: Vec<i32> = Vec::new();

    //this is how you ADD to vectors if it is mutable
    numbers.push(1);
    numbers[0] = 0;
    numbers.push(3);

    //this is another way to define a vector
    let numbers: Vec<i32> = vec![1,3];

    // Access individual elements
    println!("First element: {}", numbers[0]);
    println!("Second element: {}", numbers[1]);

    // Print the whole vector
    println!("All elements: {:?}", numbers);

    //Print a partial vector (exclusive)
    //the first way is more memory efficient because the second way creates
    //  a new vector out of the old one whereas the first way is a slice, which
    //  is not the same thing as a vector. it's only a view of the data
    println!("Some elements: {:?}", &numbers[0..1]);
    println!("Some elements: {:?}", numbers[0..1].to_vec());
}





fn main(){
    let stdout = stdout();
    let message = String::from("Hello fellow Rustaceans!");
    let width = message.chars().count();

    //this is how you USE A DEPENDENCY
    //say is a function from the ferris_says dependency
    //BufWriter is a dependency from the std::io dependency
    let mut writer = BufWriter::new(stdout.lock());
    say(&message, width, &mut writer).unwrap();





    //if you want to call functions you made earlier
    Class::hello();
    world();
    arrays();





    //this is how you do loops
    //LOOP runs FOREVER unless a break is triggered
    //when the loop reaches line 182 without reaching the break it goes to 174
    let mut count = 0;

    loop {
        println!("This is loop iteration {}", count);

        count += 1;

        if count == 3 {
            break;
        }
    }



    //WHILE 
    let mut count = 0;
    while count < 3 {
        println!("This is loop iteration {}", count);

        count += 1;
    }



    //FOR
    // for using an range (inclusive)           for i in (start)..=(end) 
    for number in 1..=3 {
        println!("This is range element {}", number);
    }

    // for using an array                   for i in [array].iter()
    for number in [4, 5, 6].iter() {
        println!("This is array element {}", number);
    }

    // for using a vector
    let bar: Vec<i32> = vec![7,8,9];
    for number in bar.iter() {
        println!("This is a vector element {}", number);
    }
}



//The merge function takes mutable references because if it accepted actual vectors
//then the ownership of the vectors would be passed to this function. The main 
//function wouldn't be able to send the vectors back easily. 
pub fn merge(nums1: &mut Vec<i32>, m: i32, nums2: &mut Vec<i32>, n: i32) {
    
    // (m and n) - 1 to account for array indexing
    //m and n are pointers to different indexes in the two different inputs
    //current is a pointer to the target location of the return array
    let mut m = m as usize;
    let mut n = n as usize;
    let mut current = m  + n - 1;

    //the function works backwards
    while current > 0 && m > 0 && n > 0 {

        //it places the bigger element at the current location
        if nums1[m - 1] > nums2[n - 1]{
            nums1[current] = nums1[m - 1];
            m -= 1;
        } else {
            nums1[current] = nums2[n - 1];
            n -= 1;
        }
        current -= 1;
    }



    // if all of nums2 elements are smaller than nums1 elements
    while n > 0 {
        nums1[current] = nums2[n - 1];
        if n == 0 || current == 0{
            break;
        }
        n -= 1;
        current -= 1;
    }



    //no need for a return line because rust implicitly returns the last 
    //expression in this case it's the while loop which has a return type of ()

}