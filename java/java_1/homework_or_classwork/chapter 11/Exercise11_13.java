import java.util.Scanner;
import java.util.ArrayList;

public class  Exercise11_13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> hold = new ArrayList<Integer>();
        System.out.println("Enter 10 integers: ");
        
        for (int i = 0; i < 10; i++){
            int temp = scan.nextInt();
            if(!hold.contains(temp)){
                hold.add(temp);
            }
        }

        System.out.print("The distinct numbers are ");
        for (int i = 0; i < hold.size(); i++){
            System.out.print(hold.get(i) + " ");
        }
    }
}