// //the dfs method works it just crashes if you give it a really large input 
// //there are more elegant ways of doing this exact problem


// use std::collections::HashSet;

// // Represent the whole graph using a vertex and a list of nodes 
// // you can also do the adjacency_list part with a hashmap
// struct Graph {
//     vertices: usize,
//     adjacency_list: Vec<Vec<usize>>,
// }

// impl Graph {
//     // Constructor to create a new graph with a given number of vertices
//     fn new(vertices: usize) -> Self {
//         Self {
//             vertices,
//             adjacency_list: vec![Vec::new(); vertices],
//         }
//     }

//     // Function to add an edge to the graph
//     // u is the source node 
//     // v is the destination node
//     fn add_edge(&mut self, u: usize, v: usize) {
//         self.adjacency_list[u].push(v);
//         self.adjacency_list[v].push(u); 
//     }

//     // Depth-First Search function
//     fn dfs(&self, start_vertex: usize, target_vertex: usize) -> bool {
//         let mut visited = HashSet::new();
//         return self.dfs_recursive(start_vertex, &mut visited, target_vertex);
//     }

//     // the recursive function that is called by the starter function
//     // it checks if the inputted vertex has been seen yet
//     //      if it has then it doesn't need to check its children
//     // otherwise it says that it is visited and recurses on its children

//     //another value can be passed into the function to sum or whatever
//     fn dfs_recursive(&self, current_vertex: usize, visited: &mut HashSet<usize>, 
//                         target_vertex: usize) -> bool {
//         if visited.contains(&current_vertex) {
//             return false;
//         }

//         visited.insert(current_vertex);

//         if current_vertex == target_vertex { 
//             return true;
//         }

//         for &neighbor in &self.adjacency_list[current_vertex] {
//             if self.dfs_recursive(neighbor, visited, target_vertex){
//                 return true;
//             }
//         }

//         return false;
//     }
// }



// struct Solution;
// impl Solution {
//     pub fn can_jump(nums: Vec<i32>) -> bool {
//         let mut graph = Graph::new(nums.len());


//         //i is the index of the inputted vector
//         for i in 0..=(nums.len() - 1) {

//             //j is the index of the jumps that can be made from this index i
//             for j in (i + 1)..=((nums.len() - 1).min(i + nums[i] as usize)) {
//                 graph.add_edge(i, j);
//             }
//         }

//         return graph.dfs(0, nums.len() - 1);
//     }
// }



// fn main() {
//     println!("{}", Solution::can_jump(vec![2,3,1,1,4]));
//     println!("{}", Solution::can_jump(vec![3,2,1,0,4]));
//     println!("{}", Solution::can_jump(vec![3,0,8,2,0,0,1]));
// }



struct Solution;
impl Solution {
    pub fn can_jump(nums: Vec<i32>) -> bool {
        //reach is the furthest index reached so far
        let mut reach = 0;

        //i is the current index
        for i in 0..(nums.len() - 1) {

            //which is bigger reach or the index that can be jumped to
            reach = reach.max(i + (nums[i] as usize));

            //i is incremented to simulate the other values that can be
            //jumped to. If the function reads a 5 and it doesn't jump
            //to the end there and instead finds a zero it will then try
            //a 1 instead because i will be incremented. it will try all
            //of the possible values until it gets to reach. if i is 
            //reach then it has tried all of the other elements that can
            //be jumped to by this element. in that case it has reached
            //then end so just return false
            if reach == i {
                return false;
            }
        }

        //i has reached nums.len() - 1 which is the target so 
        return true;
    }
}



fn main() {
    println!("{}", Solution::can_jump(vec![1,2,2,0,4]));
    println!("{}", Solution::can_jump(vec![3,2,1,0,4]));
    println!("{}", Solution::can_jump(vec![3,0,8,2,0,0,1]));
}