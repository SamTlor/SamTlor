import java.util.Scanner;

public class Exercise06_23 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String line = scan.nextLine();
        System.out.println("Enter a character: ");
        char c = scan.next().charAt(0);

        int count = 0;
        for (int i = 0; i < line.length(); i++){
            if (line.charAt(i) == c){
                count++;
            }
        }
        System.out.println("The number of occurances of " + c + " in " + line + " is " + count);
    }
}