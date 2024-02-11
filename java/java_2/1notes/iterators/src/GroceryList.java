import java.util.*;

public class  GroceryList {
    public static void main(String[] args) {

    }

    public static void makeList(){
        List<String> groceries = new ArrayList<>();

        printList(groceries);
    }

    public static void printList(List<String> theList){
        int numberOfEntries= theList.size();

        System.out.println("There are: " + numberOfEntries + " in your shopping list.");

        for (int i = 0; i < numberOfEntries; i++){
            System.out.println(theList.get(i));
        }
    }
}