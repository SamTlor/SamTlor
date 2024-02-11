import java.util.Scanner;

public class Exercise06_37 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter an integer");
        int integer = scan.nextInt();
        System.out.println("Enter the width");
        int width = scan.nextInt();

        int var = (width - String.valueOf(integer).length());
        if (var > 0){
            while (var > 0){
                System.out.print("0");
                var--;
            }
        }
        System.out.println(integer);
    }
}