import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jumpgame4 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] test = {100,-23,-23,404,100,23,23,23,3,404};

        System.out.println(sol.minJumps(test));
    }
}

class Solution<V> {
    public int minJumps(int[] arr){
        String printer_thing = "";
        List<Edge> edges = new ArrayList<Edge>();

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                while (j >= i - 1 && j <= i + 1 && j < arr.length){
                    if(i != j){
                        Edge link = new Edge(i, j);
                        edges.add(link);

                        printer_thing += "link: " + arr[i] + "    " + j + "    " + arr[j];
                    }
                    j++;
                }
                if (j >= arr.length) break;

                if (i != j && arr[i] == arr[j]){
                    Edge link = new Edge(i, j);
                    edges.add(link);
                    
                    printer_thing +=  "link: " + arr[i] + "    " + j + "    " + arr[j];
                }
            }
        }

        Graph ending = new Graph(edges, arr.length);
        V start = ending.vertices.get(0);
        V final_index = ending.vertices.get(ending.vertices.size() - 1);

        List<V> thing = ending.getShortestPath(start, final_index);
        return thing.size();
    }

	public List<V> getShortestPath(V origin, V destination){
        if (origin == destination){                                                 //if the shortest path is not a path
            return Arrays.asList(origin);                                           //return this "list"
        }

        List<V> bfs_searched = bfs(getIndex(destination)).getPath(getIndex(origin));//get bfs path by working backwards
        if(bfs_searched.size() == 0 || bfs_searched.equals(Arrays.asList(0))){      //if can't find a path in two ways
            return null;
        }
        return bfs_searched;
	}
}

public interface Graph_starter<V>{
	/** Return the number of vertices in the graph */
	public int getSize();

	/** Return the vertices in the graph */
	public java.util.List<V> getVertices();

	/** Return the object for the specified vertex index */
	public V getVertex(int index);

	/** Return the index for the specified vertex object */
	public int getIndex(V v);

	/** Return the neighbors of vertex with the specified index */
	public java.util.List<Integer> getNeighbors(int index);

	/** Return the degree for a specified vertex */
	public int getDegree(int v);

	/** Print the edges */
	public void printEdges();

	/** Clear the graph */
	public void clear();

	/** Add a vertex to the graph */
	public boolean addVertex(V vertex);

	/** Add an edge (u, v) to the graph */
	public boolean addEdge(int u, int v);

	/** Add an edge to the graph */
	public boolean addEdge(Edge e);

	/** Remove a vertex v from the graph, return true if successful */
	public boolean remove(V v);

	/** Remove an edge (u, v) from the graph */
	public boolean remove(int u, int v);

	/** Obtain a depth-first search tree */
	public UnweightedGraph<V>.SearchTree dfs(int v);

	/** Obtain a breadth-first search tree */
	public UnweightedGraph<V>.SearchTree bfs(int v);
}

class Graph<V> implements Graph_starter<V>{
    protected List<V> vertices = new ArrayList<V>();                         // Store vertices
    protected List<List<Edge>> neighbors = new ArrayList<>();               // Adjacency lists

    public Graph(List<Edge> edges, int numberOfVertices) {
        for (int i = 0; i < numberOfVertices; i++)
            addVertex((V)(new Integer(i)));                                 // vertices is {0, 1, ...}
    
        createAdjacencyLists(edges, numberOfVertices);
      }

    public boolean addEdge(Edge e) {
        if (e.u < 0 || e.u > getSize() - 1)
            throw new IllegalArgumentException("No such index: " + e.u);
    
        if (e.v < 0 || e.v > getSize() - 1)
            throw new IllegalArgumentException("No such index: " + e.v);
    
        if (!neighbors.get(e.u).contains(e)) {
            neighbors.get(e.u).add(e);
            return true;
        }
        else {
            return false;
        }
    }

    private void createAdjacencyLists(List<Edge> edges, int numberOfVertices) {
        for (Edge edge: edges) {
            addEdge(edge.u, edge.v);
        }
    }

    public SearchTree bfs(int v) {
        List<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        for (int i = 0; i < parent.length; i++)
          parent[i] = -1; // Initialize parent[i] to -1
    
        java.util.LinkedList<Integer> queue =
          new java.util.LinkedList<>(); // list used as a queue
        boolean[] isVisited = new boolean[vertices.size()];
        queue.offer(v); // Enqueue v
        isVisited[v] = true; // Mark it visited
    
        while (!queue.isEmpty()) {
          int u = queue.poll(); // Dequeue to u
          searchOrder.add(u); // u searched
          for (Edge e: neighbors.get(u)) { // Note that e.u is u
            if (!isVisited[e.v]) { // e.v is w in Listing 28.11
              queue.offer(e.v); // Enqueue w
              parent[e.v] = u; // The parent of w is u
              isVisited[e.v] = true; // Mark w visited
            }
          }
        }
    
        return new SearchTree(v, parent, searchOrder);
      }
      


    public class SearchTree {
        private int root; // The root of the tree
        private int[] parent; // Store the parent of each vertex
        private List<Integer> searchOrder; // Store the search order
    
        /** Construct a tree with root, parent, and searchOrder */
        public SearchTree(int root, int[] parent,
            List<Integer> searchOrder) {
          this.root = root;
          this.parent = parent;
          this.searchOrder = searchOrder;
        }
    
        /** Return the root of the tree */
        public int getRoot() {
          return root;
        }
    
        /** Return the parent of vertex v */
        public int getParent(int v) {
          return parent[v];
        }
    
        /** Return an array representing search order */
        public List<Integer> getSearchOrder() {
          return searchOrder;
        }
    
        /** Return number of vertices found */
        public int getNumberOfVerticesFound() {
          return searchOrder.size();
        }
    
        /** Return the path of vertices from a vertex to the root */
        public List<V> getPath(int index) {
          ArrayList<V> path = new ArrayList<>();
    
          do {
            path.add(vertices.get(index));
            index = parent[index];
          }
          while (index != -1);
    
          return path;
        }
    
        /** Print a path from the root to vertex v */
        public void printPath(int index) {
          List<V> path = getPath(index);
          System.out.print("A path from " + vertices.get(root) + " to " +
            vertices.get(index) + ": ");
          for (int i = path.size() - 1; i >= 0; i--)
            System.out.print(path.get(i) + " ");
        }
    
        /** Print the whole tree */
        public void printTree() {
          System.out.println("Root is: " + vertices.get(root));
          System.out.print("Edges: ");
          for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -1) {
              // Display an edge
              System.out.print("(" + vertices.get(parent[i]) + ", " +
                vertices.get(i) + ") ");
            }
          }
          System.out.println();
        }
      }
    
      @Override /** Remove vertex v and return true if successful */
      public boolean remove(V v) {
        throw new java.lang.UnsupportedOperationException();
      }
    
      @Override /** Remove edge (u, v) and return true if successful */
      public boolean remove(int u, int v) {
        throw new java.lang.UnsupportedOperationException();
      }
    }

    class Edge {
      int u;
      int v;
    
      public Edge(int u, int v) {
          this.u = u;
          this.v = v;
      }
    
      public boolean equals(Object o) {
          return u == ((Edge)o).u && v == ((Edge)o).v;
      }
    }
    