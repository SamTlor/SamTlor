import java.util.Scanner;

public class Exercise03_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter a, b, c:");

        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();

        double discriminant = Math.pow(b, 2) - 4 * a * c;

        double r1 = (-1 * b + Math.pow(discriminant, .5)) / (2 * a);
        double r2 = (-1 * b - Math.pow(discriminant, .5)) / (2 * a);
        

        if (discriminant < 0){
            System.out.println("The equation has no real roots");
        } else if (r1 == r2){
            System.out.println("the equation has one root: " + r1);
        } else if (r1 != r2){
            System.out.println("This equation has two roots: " + r1 + " and " + r2);
        }
    }
}