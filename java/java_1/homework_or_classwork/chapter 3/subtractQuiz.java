import java.util.Scanner;

public class subtractQuiz {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter 1 for an easy game. Any other number for a hard game");
        boolean isEasy= scan.nextInt();
        
        int num1 = (int) (Math.random() * 100);
        int num2 = (int) (Math.random() * 100);

        System.out.println("What is " + num1 + " - " + num2 + "?");
        int answer = scan.nextInt();

        if (num1 - num2 == answer){
            System.out.println("correct");
        } else{
            System.out.println("incorrect");
        }

    }
}