/*
This uses an ADJACENCY LIST

They're better for SPACE EFFICIENCY. 
Especially for SPARSE GRAPHS where EDGES < POSSIBLE EDGES

Makes it easier to ITERATE through neighbors
Especially for graphs where there are MANY NEIGHBORS and FEW EDGES

Makes it easy to ASSOCIATE INFORMATION with vertices
 */



use std::collections::{HashSet, VecDeque};

/* 
    Represent the whole graph using a vertex and a list of nodes 
    you can also do the adjacency_list part with a HASHMAP
    ex. adjacency_list: HashMap< usize, Vec<(usize)> >

    You can make this graph WEIGHTED
        adjacency_list: Vec<Vec<(usize, i32)>>
    Then use in this add_edge instead of the line that's there now
        fn add_edge(&mut self, u: usize, v: usize, weight: i32) {
            self.adjacency_list[u].push((v, weight));
 */
struct Graph {
    vertices: usize,
    adjacency_list: Vec<Vec<usize>>
}

impl Graph {
    /*
        Constructor to create a new graph with a given number of vertices
        the input "vertices" is how many nodes to create
     */
    fn new(vertices: usize) -> Self {
        Self {
            vertices,
            adjacency_list: vec![Vec::new(); vertices],
        }
    }





    /*
        Function to add an edge to the graph. u is the source node. v is 
        the destination node
        
        uncomment the second line to make it UNDIRECTED
     */
    fn add_edge(&mut self, u: usize, v: usize) {

        self.adjacency_list[u].push(v);
        // self.adjacency_list[v].push(u);
    }





    /*
        the recursive function that is called with an empty visited HashSet
        it checks if the inputted vertex has been seen yet. if it has then 
        it doesn't need to check its children otherwise it says that it is 
        visited and recurses on its children.

        Another value like target can be passed into the function to look 
        for. make the function return a bool and add an if statement that
        returns true if current_vertex == target. 

        You can also use a value like sum and add the values of the weights.
        There are lots of uses for this function.
     */
    fn dfs(&self, current_vertex: usize, visited: &mut HashSet<usize>) {
        if visited.contains(&current_vertex) {
            return;
        }

        visited.insert(current_vertex);

        for &neighbor in &self.adjacency_list[current_vertex] {
            self.dfs(neighbor, visited);
        }
    }



    /*
        sets up vectors for the vertices that the function has seen and 
        for the vectors that will be seen next. When the function sees a
        node it reads its children. Then it adds those to the end of the 
        to see vector. Then it gets the next vector to see from the front

        after current_vertex is where you could see if current == target
        or sum could be added to.
     */
    fn bfs(&self, start_vertex: usize) {
        let mut visited = HashSet::new();
        let mut queue = VecDeque::new();

        visited.insert(start_vertex);
        queue.push_back(start_vertex);

        while !queue.is_empty() {
            let current_vertex = queue.pop_front().unwrap();


            for &neighbor in &self.adjacency_list[current_vertex] {
                if !visited.contains(&neighbor) {
                    visited.insert(neighbor);
                    queue.push_back(neighbor);
                }
            }
        }
    }






}







fn main() {
    //this graph looks like the one in this picture
    // https://miro.medium.com/v2/resize:fit:1005/1*fjiil9FYXuT-u-rt2UfbjA.png
    
    //there are 7 vertices in this graph: 0,1,2,3,  4,5,6
    let mut graph = Graph::new(7);

    graph.add_edge(0, 1);
    graph.add_edge(0, 2);

    graph.add_edge(1, 3);
    graph.add_edge(1, 4);

    graph.add_edge(2, 5);
    graph.add_edge(2, 6);



    // Perform DFS starting from vertex 0
    // graph.dfs(0, &mut HashSet::new());
    graph.bfs(0);
}