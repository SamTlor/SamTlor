// struct Solution;
// impl Solution {
//     pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {

//         //prev is starting and amount of unique elems in nums
//         let mut place: usize = 1;
//         let mut prev: usize = 0;
//         let mut this_count: i32 = 0;

//         //i = 1 to len of nums to look at every elem
//         let mut i = 1;
//         while i < nums.len() {

//             // //it breaks because previous doesn't get updated. so in ex3 it clears 
//             // //all the 0's and then finds more 0's and skips them because prev is 0
//             // //but when it finds the 1 and the 2's it adds those then finds the 1 again
//             // //because at that point prev is still at index 5 so it adds the 1 and the
//             // //2's a second time





//             // //if a new unique elem has been found
//             // if nums[prev] != nums[i] {
//             //     place += 1;
//             //     prev += 1;

//             //     nums[place] = nums[i];
//             //     this_count = 1;
//             // } 
            
//             // //if a duplicate elem
//             // else {
//             //     prev += 1;
//             //     nums[prev] = nums[i];
//             //     this_count += 1;
//             // }


//             // if this_count == 2 {
//             //     let mut j = 0;
//             //     while prev + j < nums.len() && nums[prev] == nums[prev + j] {
//             //         j += 1;
//             //     }

//             //     i = prev + j - 1;
//             // }


//             // //always increment i to go through the array
//             // i += 1;



//             let i = 0;
//             for n in nums.iter_mut(){
//                 if i < 2 || n > nums[i - 2] {
//                     nums[i + 1] = n;
//                 }
//             }


//         }

//         return (prev + 1) as i32;

//     }
// }



// fn main() {
//     let mut ex1: Vec<i32> = vec![1,1,1,2,2,3];              // [1,1,2,2,3,_]
//     let mut ex2: Vec<i32> = vec![0,0,1,1,1,1,2,3,3];        // [0,0,1,1,2,3,3,_,_]
//     let mut ex3: Vec<i32> = vec![0,0,0,0,0,1,2,2,3,3,4,4];  // [0,0,1,2,2,3,3,4,4]
    










//     let count = Solution::remove_duplicates(&mut ex1);
    
//     println!("count {}", count);
//     println!("{:?}", &ex1[..count as usize]);




    
//     let count = Solution::remove_duplicates(&mut ex2);
    
//     println!("count {}", count);
//     println!("{:?}", &ex2[..count as usize]);




    
//     let count = Solution::remove_duplicates(&mut ex3);
    
//     println!("count {}", count);
//     println!("{:?}", &ex3[..count as usize]);
// }




// //chatGPT's imperfect solution



// struct Solution;

// impl Solution {
//     pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
//         // index of unique element
//         let mut unique = 1; 

//         // how many of this unique element
//         let mut this_count = 1;

//         for i in 1..nums.len() {

//             // If the current element is not unique
//             if nums[i] == nums[i - 1] {
//                 this_count += 1;

//                 // if it's not unique but hasn't reached the limit yet
//                 if this_count <= 2 {
//                     // Move the unique element to the next valid position
//                     nums[unique] = nums[i];
//                     unique += 1;
//                 }

//                 //otherwise this_count has been incremented so func will continue
//             } 
            
//             // If the current element is unique
//             else {
//                 this_count = 1;

//                 // Move the unique element to the next valid position
//                 nums[unique] = nums[i];
//                 unique += 1;
//             }
//         }

//         unique as i32
//     }
// }

// fn main() {
//     let mut nums1: Vec<i32> = vec![1, 1, 1, 2, 2, 3];
//     let mut nums2: Vec<i32> = vec![0, 0, 1, 1, 1, 1, 2, 3, 3];
//     let mut nums3: Vec<i32> = vec![0,0,0,0,0,1,2,2,3,3,4,4];  // [0,0,1,2,2,3,3,4,4]

//     let count1 = Solution::remove_duplicates(&mut nums1);
//     println!("count1: {}", count1);
//     println!("{:?}", &nums1[..count1 as usize]);

//     let count2 = Solution::remove_duplicates(&mut nums2);
//     println!("count2: {}", count2);
//     println!("{:?}", &nums2[..count2 as usize]);
    
//     let count3 = Solution::remove_duplicates(&mut nums3);
//     println!("count3: {}", count3);
//     println!("{:?}", &nums3[..count3 as usize]);
// }





struct Solution;
impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        // index of unique element
        let mut unique = 1; 

        // how many of this unique element
        let mut this_count = 1;



        for i in 1..nums.len() {

            // If the current element is not unique
            if nums[i - 1] == nums[i] {
                this_count += 1;
            } else {
                this_count = 1;
            }



            // if it's not unique but hasn't reached the limit yet
            if this_count <= 2 {
                // Move the unique element to the next valid position
                nums[unique] = nums[i];
                unique += 1;
            }
        }

        unique as i32
    }
}

fn main() {
    let mut nums1: Vec<i32> = vec![1, 1, 1, 2, 2, 3];
    let count1 = Solution::remove_duplicates(&mut nums1);
    println!("count1: {}", count1);
    println!("{:?}", &nums1[..count1 as usize]);

    let mut nums2: Vec<i32> = vec![0, 0, 1, 1, 1, 1, 2, 3, 3];
    let count2 = Solution::remove_duplicates(&mut nums2);
    println!("count2: {}", count2);
    println!("{:?}", &nums2[..count2 as usize]);
    
    let mut nums3: Vec<i32> = vec![0,0,0,0,0,1,2,2,3,3,4,4];
    let count3 = Solution::remove_duplicates(&mut nums3);
    println!("count3: {}", count3);
    println!("{:?}", &nums3[..count3 as usize]);
}


//there's nothing wrong with comparing an element to the one before it
//don't use multiple pointers and loops when one look is fine