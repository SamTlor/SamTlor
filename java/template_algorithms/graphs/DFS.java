import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// I solemnly swear I will only use this file with either a list or a matrix
// otherwise it will crash. i do not do error handling.
public class DFS {
    
    public static <T> void dfs(T graph, int startVertex, Set<Integer> visited) {

        // the vertices whose neighbors we've already looked at
        visited.add(startVertex);



        // this is where i can add a "sum += currentVertex" or a 
        System.out.print(startVertex + " ");
        // "currentVertex == target" or whatever



        // adjacency list
        if (graph instanceof Map) {
            Map<Integer, List<Integer>> adjacencyList = (Map<Integer, List<Integer>>) graph;
            List<Integer> neighbors = adjacencyList.get(startVertex);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    if(!visited.contains(neighbor)) {
                        dfs(graph, neighbor, visited);
                    }
                }
            }
        } 
        


        // adjacency matrix
        else {
            int[][] adjacencyMatrix = (int[][]) graph;
            for (int neighbor = 0; neighbor < adjacencyMatrix.length; neighbor++) {
                if (adjacencyMatrix[startVertex][neighbor] == 1 && !visited.contains(neighbor)) {
                    dfs(graph, neighbor, visited);
                }
            }
        } 

    }
}
