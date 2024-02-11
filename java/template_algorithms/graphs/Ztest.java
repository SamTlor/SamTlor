
// https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/


import java.util.HashSet;
import java.util.Map;

public class Ztest {
    public static void main(String[] args) {
        // Create adjacency list graph
        Graph_adj_list adjGraph = new Graph_adj_list();

        // add to it. the edges create vertices
        adjGraph.addEdge(1, 2);
        adjGraph.addEdge(1, 3);
        adjGraph.addEdge(2, 3);
        adjGraph.addEdge(3, 1);

        // see it with toString()
        System.out.println("Graph representation with toString(): \n" + adjGraph);
        
        // see neighbors of a given vertex
        for (int i : adjGraph.getNeighbors(1)) {
            System.out.print(i + " ");
        }
        System.out.println("\n\n\n");



        // Create adjacency matrix graph
        Graph_adj_matrix matGraph = new Graph_adj_matrix(5);

        // add to it
        matGraph.addEdge(1, 2);
        matGraph.addEdge(1, 3);
        matGraph.addEdge(2, 3);
        matGraph.addEdge(3, 1);

        // see it with toString()
        System.out.println("Graph representation with toString(): \n" + matGraph);
        
        // see neighbors of a given vertex
        for (int i : matGraph.getNeighbors(1)) {
            System.out.print(i + " ");
        }
        System.out.println("\n\n\n");







        // BFS traversal for both types
        System.out.println("BFS: Adjacency list");
        BFS.bfs(adjGraph.getAdjacencyList(), 2);

        System.out.println("\nBFS: Adjacency matrix");
        BFS.bfs(matGraph.getAdjacencyMatrix(), 2);



        // DFS traversal for both types
        System.out.println("\nDFS: Adjacency list");
        DFS.dfs(adjGraph.getAdjacencyList(), 2, new HashSet<>());
        
        System.out.println("\nDFS: Adjacency matrix");
        DFS.dfs(matGraph.getAdjacencyMatrix(), 2, new HashSet<>());







        /*
            For a general weighted graph, we can calculate single source shortest distances in O(VE) time using Bellman–Ford Algorithm. https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
            
            For a graph with no negative weights, we can do better and calculate single source shortest distances in O(E + VLogV) time using Dijkstra’s algorithm. https://www.geeksforgeeks.org/dijkstras-algorithm-for-adjacency-list-representation-greedy-algo-8/
            
            Can we do even better for Directed Acyclic Graph (DAG)? We can calculate single source shortest distances in O(V+E) time for DAGs. The idea is to use Topological Sorting. https://www.geeksforgeeks.org/topological-sorting/

            https://www.geeksforgeeks.org/shortest-path-for-directed-acyclic-graphs/
        */
    }
}