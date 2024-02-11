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