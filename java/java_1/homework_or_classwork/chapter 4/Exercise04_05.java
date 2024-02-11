import java.util.Scanner;
import java.lang.Math;

public class Exercise04_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the number of sides");
        int n = scan.nextInt();
        System.out.println("and their length");
        double s = scan.nextDouble();

        double area = n * Math.pow(s, 2) / (4 * Math.tan(Math.PI / n));
        System.out.println("The area of the polygon is " + area);

        }
}