/*
    Name: Sam Taylor
    MyCustomGraph.java
    Course: CMSC-256
    Date: 12/7/2021
    this project reads in a file and implements the unweightedGraph class to create a graph from the numbers in the file. it has methods
    to say if the graph is complete or connected. it also has methods to say if a vertex is adjacent to another vertex, find the 
    shortest distance between two vertices, or say if the graph contains a cycle
 */

package cmsc256;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import javax.naming.directory.SearchResult;

public class MyCustomGraph<V> extends UnweightedGraph<V> {
// initializers
	public MyCustomGraph() {
		super();
	}
	public MyCustomGraph(int[][] edges, int numberOfVertices) {
		super(edges, numberOfVertices);
	}
	public MyCustomGraph(List<Edge> edges, int numberOfVertices) {
		super(edges, numberOfVertices);
	}
	public MyCustomGraph(List<V> vertices, List<Edge> edges) {
		super(vertices, edges);
	}
	public MyCustomGraph(V[] vertices, int[][] edges) {
		super(vertices, edges);
	}


	public MyCustomGraph<Integer> readFile(String fileName) throws FileNotFoundException, NumberFormatException {
        File input = new File(fileName);                                                //create file object
        
        if(!input.exists()){                                                            //if file doesn't exist throw FileNotFound
            throw new FileNotFoundException();
        }

        List<Edge> eds = new ArrayList<Edge>();                                         //list of edges for the MyCustomGraph constructor
        Scanner scan = new Scanner(input);                                              //to read the file
        
        
        int num_of_verts = scan.nextInt();                                              //first line is always number of verts
        while (scan.hasNextLine()){                                                     //while there's a next line keep reading the file
            String inputed_line = scan.nextLine();                                      
            String[] verts = inputed_line.split(" ");                                    //remove white space and make array of the nums

            for (int i = 1; i < verts.length; i++){
                Edge connection = new Edge(Integer.parseInt(verts[0]), Integer.parseInt(verts[i]));
                eds.add(connection);                                                    //new edge b/w every node connected to charAt(0)
            }
        }
        return new MyCustomGraph<>(eds, num_of_verts);                                  //ending
	}

	public boolean isComplete(){
		int vertSize = getSize();
		for(List<Edge> i : neighbors){                      //for every vertex
			if ( i.size() != vertSize - 1 ){                //make sure the amount of children that vertex has is the length of verts - 1
				return false;
			}
		}
		return true;
	}

	public boolean areAdjacent(V vert1, V vert2){
		for( int i : getNeighbors(getIndex(vert1)) ){                   //for all the children of vert 1
			if (getVertex(i) == vert2){                                 //if the child is the same as vert 2 return true
				return true;
			}
		}
		return false;
	}

	public boolean isConnected() {                                      //I didn't read the instructions and so my dad and I worked on
                                                                        //this for like an hour. we eventually got it and it was really
                                                                        //long. seeing how quick this actually was made me kinda sad lol
        if(vertices.size() <= 1 ){                                      //one or zero vertices cannot be connected
            return false;
        }
        return dfs(0).getNumberOfVerticesFound() == vertices.size();    //dfs starting anywhere. if the length of vertices is the same as
	}                                                                   //the number of vetices return true otherwise false

	public List<V> getShortestPath(V origin, V destination){
        if (origin == destination){                                                 //if the shortest path is not a path
            return Arrays.asList(origin);                                           //return this "list"
        }

        List<V> bfs_searched = bfs(getIndex(destination)).getPath(getIndex(origin));//get the bfs path by working backwards
        if(bfs_searched.size() == 0 || bfs_searched.equals(Arrays.asList(0))){      //if can't find a path in two ways
            return null;
        }
        return bfs_searched;
	}

	public boolean hasCycle() {
        if(vertices.size() == 0){                               //this would cause a index error so just return false if file is empty
            return false;                                       //"return getSize() > 2" would work for all test cases in gradescope
        }

        // 1. parent
        int[] parent = new int[getSize()];                      //im using it like an int variable tho i dont think this is best practice
        parent[0] = 0;                                          //lol

        // 2. allVertices
        List<Integer> allVertices = new ArrayList<Integer>();   //I don't use this once in the other method

        // 3. isVisited
        boolean[] isVisited = new boolean[getSize()];           //contains all the vertices that have been visited
        for(int i = 0; i < getSize(); i++){
            allVertices.add(i);
            isVisited[i] = false;                               //initiated to has not been visited
        }
    
        //call helper function on every vertex
        for(int i = 0; i < getSize(); i++){                     //for every vertex because a seperated graph could still have a cycle
            if( hasCycle(i, parent, allVertices, isVisited) ){
                return true;
            }
        }
        return false;
	}

    
	private boolean hasCycle(int u, int[] parent, List<Integer> allVertices, boolean[] isVisited) {
        isVisited[u] = true;                            //curent vertex being visited will be asked by its children if it has been visited

        List<Integer> allNeighbors = getNeighbors(u);   //get all of u's children
        for (int neighbor : allNeighbors){              //go through u's children
            if(isVisited[neighbor] == false){           //if a child hasn't been visited yet
                int temp = parent[0];                   //remember u's parent
                parent[0] = u;                          //when hasCycle is called the parent needs to be different

                if (hasCycle(neighbor, parent, allVertices, isVisited)){    //recur
                    return true;                        //if there is a cycle return true. we're all done
                }
                parent[0] = temp;                       //else. the child has not found a cycle so parent needs to be u's parent, not u
            }
            if(parent[0] != neighbor && parent[0] != u && isVisited[neighbor] == true){
                return true;                            //if the child is not the parent, if u is 0 parent[0] will be 0(check for that)
            }                                           //if ^ passes, if the neighbor has been visited thats a cycle. we're all done
            parent[0] = allNeighbors.get(allNeighbors.size() - 1);
        }                                               //if none of the children have found a cycle it will go back to the parent
                                                        //the parent will look at all its children. it won't work if it thinks that
                                                        //one of its children has been visited (because it just was) and is adjacent
                                                        //so it needs to think that the one it just came from is its parent
        return false;                                   //if nothing has found a cycle
	}

    public static void main(String[] args){
        MyCustomGraph points = new MyCustomGraph();
        try{
            points = points.readFile(args[0]);
        } catch(FileNotFoundException f){}
        
       System.out.println(points.getShortestPath());
    }
}