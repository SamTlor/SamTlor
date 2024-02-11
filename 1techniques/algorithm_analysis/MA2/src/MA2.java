import java.io.File;
import java.util.Scanner;

public class MA2 {
    public static void main(String[] args) throws Exception {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);

        int courses = scan.nextInt();       //height of the matrix
        int halls = scan.nextInt();         //width of the matrix
        scan.nextLine();



        int[][] matrix = new int[courses + halls + 2][courses + halls + 2];
        int[][] residual = new int[courses + halls + 2][courses + halls + 2];


        int source = 0;
        int sink = courses + halls + 1;

        for(int i = 1; i <= courses; i++){
            int courseID = scan.nextInt();
            
            //the source node is connected to every course node
            matrix[source][i] = 1;
            residual[source][i] = 1;

            Scanner lineScan = new Scanner(scan.nextLine());
            while(lineScan.hasNextInt()){
                //we save the left side of the matrix for working on the residual graphs
                int hallID = courses + lineScan.nextInt();
                matrix[i][hallID] = 1;
                residual[i][hallID] = 1;
            }
            lineScan.close();
        }

        //every hall is connected to the end node
        for(int i = 1; i <= halls; i++){
            int hallID = courses + i;
            matrix[hallID][sink] = 1;
            residual[hallID][sink] = 1;
        }

        int maxFlow = 0;
        while(true){
            //BFS implementation
            int[] parent = new int[sink+1];
            for(int i = 0; i < sink+1; i++){
                parent[i] = -1;
            }


            //so that we can say 'for every vertex in graph except start'
            parent[0] = -2;
            
            //start the queue with the starting node
            Queue queue = new Queue();
            queue.enQ(source);

            //just like BFS: while queue is not empty 
            //parent array is the array of element that have been seen already
            while(!queue.isEmpty() && parent[sink] == -1){
                int elem = queue.deQ();
                // <= so it looks at every element in the column
                // goes through all the possible nodes that could be connected to elem
                for(int i = 1; i <= sink; i++){
                    //if this vertex-vertex edge connection hasn't been seen before
                    //and if it's also not in the residual path
                    if(parent[i] == -1 && residual[elem][i] > 0){
                        parent[i] = elem;
                        queue.enQ(i);
                    }
                }
            }



            //no augmenting path exists and we've found the answer
            if(parent[courses] == -1){
                break;
            }

            //go backward from sink to source
            int v = sink;
            int flow = Integer.MAX_VALUE;
            while(v != source){
                int u = parent[v];

                if (flow > residual[u][v]){
                    flow = residual[u][v];
                }
                v = u;
            }
            v = sink;
            while(v != source){
                int u = parent[v];
                residual[u][v] -= flow;
                residual[v][u] += flow;
                v = u;
            }
            //add up all the times where there is a path between start and end
            maxFlow += flow;
        }
        System.out.println(maxFlow);
    }
}



class Node {
    private int data;
    private Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}



class Queue{
    private Node front;
    private Node rear;
    private int size;

    public Queue(){
        front = null;
        rear = null;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public void enQ(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            front = newNode;
            rear = newNode;
        } else{
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }

    public int deQ(){
        int data = front.getData();
        front = front.getNext();
        if(isEmpty()){
            rear = null;
        }
        size--;
        return data;
    }

    public void printAll(){
        Node thing = front;
        
        for (int i = 0; i < size; i++){
            System.out.println(thing.getData());
            thing = thing.getNext();
        }
    }
}