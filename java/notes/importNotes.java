import java.util.Scanner;
import java.util.Random;

public class importNotes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Type a word to have it said back to you");
        String response = scan.nextLine();
        System.out.println(response);

        Random rand = new Random();
        System.out.println("You will now have a random number between 0-10 said to you");;
        System.out.println(rand.nextInt(10));
    }
}