import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;


public class Graph_adj_list {
    
    // instance variables
    private Map<Integer, List<Integer>> adjacencyList;



    // constructors
    public Graph_adj_list() {
        this.adjacencyList = new HashMap<>();
    }



    // getters
    public int getVertexCount() {
        return adjacencyList.size();
    }

    public int getEdgeCount() {
        int count = 0;
        for (List<Integer> edges : adjacencyList.values()) {
            count += edges.size();
        }

        return count / 2;   // For undirected graph
        // return count;    // For directed graph
    }

    public List<Integer> getNeighbors(int inputVertex) {
        return adjacencyList.get(inputVertex);
    }

    public Map<Integer, List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }



    // setters
    public void addVertex(int thisVertex) {
        adjacencyList.put( thisVertex, new LinkedList<>() );
    }

    public void addEdge(int source, int destination) {

        // if the source or destination params don't exist in the graph then add them
        if (!adjacencyList.containsKey(source)) {
            addVertex(source);
        }
        if (!adjacencyList.containsKey(destination)) {
            addVertex(destination);
        }




        // Add source or destination to the list of neighbors, if not already present
        if (!adjacencyList.get(source).contains(destination)) {
            adjacencyList.get(source).add(destination);
        }

        // include this segment \/ only if you want an undirected graph
        if (!adjacencyList.get(destination).contains(source)) {
            adjacencyList.get(destination).add(source);
        }
    }



    // polymorphisms
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            result  .append(entry.getKey())
                    .append(" -> ")
                    .append(entry.getValue())
                    .append("\n");
        }
        return result.toString();
    }



    // functions
    public static List<List<String>> getCycles(Graph_adj_list graph, String startVertex, Set<String> visited, 
                                            List<String> path, List<List<String>> cycles) {

        // the vertices whose neighbors we've already looked at
        visited.add(startVertex);
        path.add(startVertex);
        


        List<String> neighbors = graph.getNeighbors(startVertex);
        if (neighbors != null) {
            for (int i = 0; i < neighbors.size(); i++) {

                String neighbor = neighbors.get(i);
                if (checkForNeighbor(neighbor, path)){

                    List<String> cycle = new ArrayList<>(path);
                    cycle.add(neighbor);
                    cycles.add(trimCycle(cycle, cycle.get(cycle.size() - 1)));
                }


                if(!visited.contains(neighbor)) {
                    getCycles(graph, neighbor, visited, path, cycles, i);
                }
            }
        }

        path.remove(startVertex);
        return cycles;
    }
    
    public static List<String> trimCycle(List<String> cycle, String elementToFind){

        int i = 0;
        while (i < cycle.size()){
            if ((cycle.get(i)).equals(elementToFind)){
                break;
            } else{
                cycle.remove(i);
            }
            i++;
        }

        return cycle;
    }

}