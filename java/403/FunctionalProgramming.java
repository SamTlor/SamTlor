import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;

public class FunctionalProgramming {
    public static void main(String[] args){
        /* LOOPS
        * you can do loops like python with ArrayLists
        * or with lambdas to shorten the expression
        */

        List<String> names = new ArrayList<String>();
        names.add("jane");
        names.add("joe");
        names.add("mark");
        names.add("donna");

        //normal for loop
        for(String i : names){
            System.out.println(i);
        }
        
        System.out.println("\n");

        //lambda expression iteration
        names.forEach(
            (String i) -> {System.out.println(i);}
        );
        
        System.out.println("\n");

        //shortened lambda expression version
        names.forEach(System.out :: println);




        /* THREADS
        * lambda for threads
        * can create a thread and have a task state things about the thread
        * or do stuff for the thread
        */
        Runnable task = () -> {System.out.println("Task is running");};
        new Thread(task).start();


        
        //lambda for a thread that runs infinitely
        new Thread(() -> {
            try{
                while (true){
                    System.out.println("Task is running");
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {}
        }).start();




    /* STREAM
     * conveys elements from a source like an I/O channel, data structure,
     * array, generator function, etc
     * through a pipeline of computational operations
     * 
     * has many operations such as filtering, mapping, and duplicate removal
     */
    names.stream().map(
        (String s) -> s.toUpperCase()
    ).forEach(System.out :: println);
    
        System.out.println("\n");

    names.stream().map(
        String :: toUpperCase
    ).forEach(System.out :: println);

        System.out.println("\n");

    names.stream().filter(
        (String s) -> s.length() > 3        //filters need a predicate, a functional interace that 
    ).forEach(System.out :: println);       //always returns a boolean value

        System.out.println("\n");

    names.stream().filter(
        (s) -> {
            String z = s.toUpperCase();
            return (z.substring(1,3).compareTo("ON") == 0);
        }
    ).forEach(System.out :: println);

        System.out.println("\n");

    //you can chain them together too
    int totalLength = names
                        .stream()
                        .map(s -> s.length())       //mapToInt(String :: length) is more efficient
                        .reduce(0, (a, b) -> a + b);
    System.out.println(totalLength);




    String totalString = names
                            .stream()
                            .reduce("", (a, b) -> a + " " + b);
    System.out.println(totalString);




    Collections.sort(names, (String s1, String s2) -> s1.compareTo(s2));
    for (String s : names) {System.out.println(s);}

    Collections.sort(names, (s1, s2) -> s2.compareTo(s1));






    //Given the list: Barb, Cal, Abe, Fred, Dan. How would you create a 
    //collection to print only the names sorted that start with “A”, “B”, or 
    //“C”?
    List<String> new_names = new ArrayList<String>();
    new_names.add("Barb");
    new_names.add("Cal");
    new_names.add("Abe");
    new_names.add("Fred");
    new_names.add("Dan");

    List<String> collect = new_names.stream().filter(
        (s) -> {
            String z = s.toUpperCase();
            if(z.substring(0,1).compareTo("D") < 0)
                return true;
            else
                return false;
        }
    ).collect(Collectors.toCollection(ArrayList :: new));
    Collections.sort(collect, (s1, s2) -> s1.compareTo(s2));
    System.out.println(collect);




    //you can run streams in parallel
    List<String> collect2 = names.stream()
    .parallel()
    .filter((String s) -> s.length() > 3)
    .sequential()
    .map(String :: toUpperCase)
    .collect(Collectors.toCollection(ArrayList :: new));
    System.out.println(collect2);

    }
}