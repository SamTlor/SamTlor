public class Graph_adj_matrix {

    // instance variables
    private int[][] adjacencyMatrix;
    private int vertexCount;


    // constructors
    public Graph_adj_matrix(int vertexCount) {
        this.adjacencyMatrix = new int[vertexCount][vertexCount];
        this.vertexCount = vertexCount;
    }


    // getters
    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        int count = 0;
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    count++;
                }
            }
        }
        return count / 2; // For undirected graph
        // return count;  // For directed graph
    }

    public int[] getNeighbors(int inputVertex) {
        return adjacencyMatrix[inputVertex];
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }


    // setters
    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1; // For undirected graph
    }

    // polymorphism
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < vertexCount; i++) {

            // vertex -> 
            result.append(i).append(" -> ");

            // [x,x,x]
            for (int j = 0; j < vertexCount; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    result.append(j).append(" ");
                }
            }

            // "\n"
            result.append("\n");

        }

        return result.toString();
    }


    public static void main(String[] args) {
        Graph_adj_matrix graph = new Graph_adj_matrix(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        System.out.println(graph);
    }
}
