import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class day8 {
    public static void main(String[] args) {
            
        // read and store the input line by line in a list
        String instuctions = "";
        List<String> starts = new ArrayList<>();
        List<String> input = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("day8.txt"))) {

            instuctions = br.readLine();
            br.readLine();                              //ignore space between line 1 and 3

            String line;
            while ((line = br.readLine()) != null) {
                
                // add the countPairs to the line so that you don't need to look it up later
                input.add(line);
            }
        } catch (IOException e) {}
        


        Graph_adj_list graph = new Graph_adj_list();
        for (String i : input){

            String trim = i.replaceAll("\\s", "");
            String[] nums = trim.split("\\s*=\\s*\\(|,\\s*|\\s*\\)");


            if (nums[0].charAt(2) == 'A'){
                starts.add(nums[0]);
            }
            
            graph.addEdge(nums[0], nums[1]);
            graph.addEdge(nums[0], nums[2]);
        }


        // System.out.println(part1(instuctions, graph));
        System.out.println(part2(instuctions, graph, starts));

        // int a = 0;
        // for (List<Pair> thing : graph.getCycles(graph, "RJK", new HashSet<>(), new ArrayList<>(), new ArrayList<>(), 0)){
        //     System.out.println(thing);
        //     System.out.println();
        //     a++;
        // }
        // System.out.println(a);

        // TODO: maybe don't even bother with cycles just try to run the infinite instructions on the starting
        // vertices and see where it takes you
    }



    static int part1(String instructions, Graph_adj_list graph) {

        int i = 0;
        String start = "AAA";

        while (!start.equals("ZZZ")) {

            if (instructions.charAt(i % instructions.length()) == 'L' || graph.getNeighbors(start).size() == 1) {
                start = graph.getNeighbors(start).get(0);
            } else {
                start = graph.getNeighbors(start).get(1);
            }

            i++;
        }

        return i;
    }



    // straight impossible. anyone who says different is lying
    // best possible runtime is n * m. n = lines of input   m = chars of first line to go through
    static int part2(String instructions, Graph_adj_list graph, List<String> starts) {

        int i = 0;

        /*
        boolean endsInZ = false;
        
        while (!endsInZ){
            endsInZ = true;
            for (int a = 0; a < starts.size(); a++){
                if(!(starts.get(a).charAt(2) == 'Z')) {
                    endsInZ = false;
                }



                String thisStart = starts.get(a);
                List<String> thisNeighbors = graph.getNeighbors(thisStart);

                if (instructions.charAt(i % instructions.length()) == 'L' || thisNeighbors.size() == 1) {
                    starts.set(a, thisNeighbors.get(0));
                } else {
                    starts.set(a, thisNeighbors.get(1));
                }
            }

            i++;
        }
        */

        /*
        ArrayList thing = new ArrayList<>();
        String realStart = starts.get(0);
        String theStart = starts.get(0);
        do {
            thing.add(theStart);

            if (instructions.charAt(i % instructions.length()) == 'L' || graph.getNeighbors(theStart).size() == 1) {
                theStart = graph.getNeighbors(theStart).get(0);
            } else {
                theStart = graph.getNeighbors(theStart).get(1);
            }

            i++;
        } while (i < 2500);

        System.out.println(thing);
        System.out.println(thing.size());
        */


        // vertex, instructions index, if there is a vertex that ends in z, the steps until the z
        boolean endsInZ = false;
        String current = starts.get(0);
        Set<String> visited = new HashSet<>();      // visited needs a Pairs class to store i for stuff later
        ArrayList<Data> cycles = new ArrayList<>();
        while (!endsInZ){

            List<String> thisNeighbors = graph.getNeighbors(current);

            if (instructions.charAt(i % instructions.length()) == 'L' || thisNeighbors.size() == 1) {
                current = thisNeighbors.get(0);
            } else {
                current = thisNeighbors.get(0);
            }


            // would have to store the index id of the first time i find this vertex and increment to current
            if (visited.contains(current)) {

                // here i would find out if there are z's inbetween those two indices
                // if there are then the third param in Data would be true
                // id create an array of the steps until z and use that for the fourth param
                // id find the difference between the first index and current and use that for the fifth param

                // // new Data(current, instructions % instructions.length(), , , );
            }
            visited.add(current);







            // only need to check the other ones if the first start is a vertex that ends in z
            endsInZ = true;
            for (int a = 0; a < starts.size(); a++){
                if(!(starts.get(a).charAt(2) == 'Z')) {
                    endsInZ = false;
                }
            }

            i++;
        }

        return i;
    }


    static class Graph_adj_list {
        
        // instance variables
        private Map<String, List<String>> adjacencyList;



        // constructors
        public Graph_adj_list() {
            this.adjacencyList = new HashMap<>();
        }



        // getters
        public List<String> getNeighbors(String inputVertex) {
            return adjacencyList.get(inputVertex);
        }

        /*
        // maybe you could change this so that you don't find cycles that could exist 
        // but you find cycles that could exist if it followed the instructions
        // see where the 
        public static List<List<Pair>> getCycles(Graph_adj_list graph, String startVertex, Set<String> visited, 
                                            List<Pair> path, List<List<Pair>> cycles, int gotHereHow) {

            // the vertices whose neighbors we've already looked at
            visited.add(startVertex);

            Pair starterThing;
            if (gotHereHow % 2 == 0){
                starterThing = new Pair(startVertex, "L");
            } else {
                starterThing = new Pair(startVertex, "R");
            }
            path.add(starterThing);
            


            List<String> neighbors = graph.getNeighbors(startVertex);
            if (neighbors != null) {
                for (int i = 0; i < neighbors.size(); i++) {

                    String neighbor = neighbors.get(i);
                    if (checkForNeighbor(neighbor, path)){

                        List<Pair> cycle = new ArrayList<>(path);
                        if (i % 2 == 0){
                            cycle.add(new Pair(neighbor, "L"));
                        } else {
                            cycle.add(new Pair(neighbor, "R"));
                        }

                        System.out.println("for looped:\n" + cycle);
                        cycles.add(trimCycle(cycle, cycle.get(cycle.size() - 1)));
                    }


                    if(!visited.contains(neighbor)) {
                        getCycles(graph, neighbor, visited, path, cycles, i);
                    }
                }
            }

            path.remove(starterThing);
            return cycles;
        }
        
        
        public static boolean checkForNeighbor(String neighbor, List<Pair> path){

            for (Pair pair : path) {
                if(pair.first.equals(neighbor)){
                    return true;
                }
            }
            return false;

        }

        public static Pair pathGetter(Set<Pair> path){
            Pair mostRecent = null;
            for(Pair i : path){
                mostRecent = i;
            }

            return mostRecent;
        }

        public static List<Pair> trimCycle(List<Pair> cycle, Pair elementToFind){

            int i = 0;
            while (i < cycle.size()){
                if ((cycle.get(i).first).equals(elementToFind.first)){
                    break;
                } else{
                    cycle.remove(i);
                }
                i++;
            }

            return cycle;
        }
        

        // public static boolean sameCycle(List<Pair> first, List<Pair> second){

        // }


        
    static class Pair<T1, T2> {
        public T1 first;
        public T2 second;

        // constructors
        public Pair(T1 theFirst, T2 theSecond){
            first = theFirst;
            second = theSecond;
        }



        // setters
        public void setFirst(T1 first) {
            this.first = first;
        }
        
        public void setSecond(T2 second) {
            this.second = second;
        }



        // polymorphisms
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pair)) {
                return false;
            }
            Pair<?, ?> other = (Pair<?, ?>) obj;
            return Objects.equals(first, other.first) && Objects.equals(second, other.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
        
        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }
        */

        

        // setters
        public void addVertex(String thisVertex) {
            adjacencyList.put( thisVertex, new LinkedList<>() );
        }

        public void addEdge(String source, String destination) {

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
        }



        // functions
    }



    // vertex, instructions index, if there is a vertex that ends in z, the steps until the z
    static class Data {
        
        // instance variables
        private String startVertex;
        private int instuctionsStartIndex;
        private boolean thereAZ;
        private int[] stepsToZ;
        private int otherVertex;

        // constructors
        public Data(String theStartVertex, int theInstuctionsStartIndex, boolean theThereAZ, 
                                                        int[] theSteptsToZ, int theOtherVertex){
            this.startVertex = theStartVertex;
            this.instuctionsStartIndex = theInstuctionsStartIndex;
            this.thereAZ = theThereAZ;
            this.stepsToZ = theSteptsToZ;
            this.otherVertex = theOtherVertex;
        }

        // getters
        public String getStartVertex() {
            return startVertex;
        }
        public int getInstuctionsStartIndex() {
            return instuctionsStartIndex;
        }
        public boolean getThereAZ() {
            return thereAZ;
        }
        public int[] getStepsToZ() {
            return stepsToZ;
        }
        public int getOtherVertex() {
            return otherVertex;
        }
    }
}