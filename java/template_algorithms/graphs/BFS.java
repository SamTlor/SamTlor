import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


// I solemnly swear I will only use this file with either a list or a matrix
// otherwise it will crash. i do not do error handling.
public class BFS {
    public static <T> void bfs(T graph, int startVertex) {

        // the vertices whose neighbors we've already looked at
        Set <Integer> visited = new HashSet<>();

        // the vertices whose neighbors we'll look at soon
        Queue<Integer> queue = new LinkedList<>();

        // the first step is looking at startVertex so it gets added first
        visited.add(startVertex);
        queue.add(startVertex);



        // adjacency list
        if (graph instanceof Map) {
            Map<Integer, List<Integer>> adjacencyList = (Map<Integer, List<Integer>>) graph;
            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();
                System.out.print(currentVertex + " ");



                // this is where i can add a "sum += currentVertex" or a 
                
                // "currentVertex == target" or whatever



                List<Integer> neighbors = adjacencyList.get(currentVertex);
                if (neighbors != null) {
                    for (int neighbor : neighbors) {
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.add(neighbor);
                        }
                    }
                }

            }
        } 
        


        // adjacency matrix
        else {
            int[][] adjacencyMatrix = (int[][]) graph;
            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();
                System.out.print(currentVertex + " ");
                

                
                // this is where i can add a "sum += currentVertex" or a 
                
                // "currentVertex == target" or whatever



                for (int neighbor = 0; neighbor < adjacencyMatrix.length; neighbor++) {
                    if (adjacencyMatrix[currentVertex][neighbor] == 1 && !visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        } 

        
    }
}



/*

https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/



1. Shortest Path and Minimum Spanning Tree for unweighted graph: In an unweighted graph, the shortest path is the path with the least number of edges. With Breadth First, we always reach a vertex from a given source using the minimum number of edges. Also, in the case of unweighted graphs, any spanning tree is Minimum Spanning Tree and we can use either Depth or Breadth first traversal for finding a spanning tree. 

2. Minimum Spanning Tree for weighted graphs: We can also find Minimum Spanning Tree for weighted graphs using BFT, but the condition is that the weight should be non-negative and the same for each pair of vertices.

3. Peer-to-Peer Networks: In Peer-to-Peer Networks like BitTorrent, Breadth First Search is used to find all neighbor nodes. 

4. Crawlers in Search Engines: Crawlers build an index using Breadth First. The idea is to start from the source page and follow all links from the source and keep doing the same. Depth First Traversal can also be used for crawlers, but the advantage of Breadth First Traversal is, the depth or levels of the built tree can be limited.

5. Social Networking Websites: In social networks, we can find people within a given distance ‘k’ from a person using Breadth First Search till ‘k’ levels.

6. GPS Navigation systems: Breadth First Search is used to find all neighboring locations.

7. Broadcasting in Network: In networks, a broadcasted packet follows Breadth First Search to reach all nodes.

8. In Garbage Collection: Breadth First Search is used in copying garbage collection using Cheney’s algorithm. Breadth First Search is preferred over Depth First Search because of a better locality of reference.

9. Cycle detection in undirected graph: In undirected graphs, either Breadth First Search or Depth First Search can be used to detect a cycle. We can use BFS to detect cycle in a directed graph also.

10. Ford–Fulkerson algorithm In Ford – Fulkerson algorithm, we can either use Breadth First or Depth First Traversal to find the maximum flow. Breadth First Traversal is preferred as it reduces the worst-case time complexity to O(VE2).

11. To test if a graph is Bipartite: We can either use Breadth First or Depth First Traversal.

12. Path Finding: We can either use Breadth First or Depth First Traversal to find if there is a path between two vertices. 

13. Finding all nodes within one connected component: We can either use Breadth First or Depth First Traversal to find all nodes reachable from a given node. 

14. AI: In AI, BFS is used in traversing a game tree to find the best move.

15. Network Security: In the field of network security, BFS is used in traversing a network to find all the devices connected to it.

16. Connected Component: We can find all connected components in an undirected graph.

17. Topological sorting: BFS can be used to find a topological ordering of the nodes in a directed acyclic graph (DAG).

18. Image processing: BFS can be used to flood-fill an image with a particular color or to find connected components of pixels.

19. Recommender systems: BFS can be used to find similar items in a large dataset by traversing the items’ connections in a similarity graph.

20. Other usages: Many algorithms like Prim’s Minimum Spanning Tree and Dijkstra’s Single Source Shortest Path use structures similar to Breadth First Search. 
Advantages of Breadth First Search:

    BFS will never get trapped exploring the useful path forever.
    If there is a solution, BFS will definitely find it.
    If there is more than one solution then BFS can find the minimal one that requires less number of steps.
    Low storage requirement – linear with depth.
    Easily programmable.

Disadvantages of Breadth First Search:

The main drawback of BFS is its memory requirement. Since each level of the graph must be saved in order to generate the next level and the amount of memory is proportional to the number of nodes stored the space complexity of BFS is O(bd ), where b is the branching factor(the number of children at each node, the outdegree) and d is the depth. As a result, BFS is severely space-bound in practice so will exhaust the memory available on typical computers in a matter of minutes.

 */