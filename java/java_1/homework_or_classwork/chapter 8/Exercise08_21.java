import java.util.Scanner;

public class Exercise08_21 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of cities: ");
        int number = scan.nextInt();
        double[] list = new double[number * 2];

        System.out.println("Enter the coordinates of the cities: ");
        for(int i = 0; i < number * 2; i++){
            list[i] = scan.nextDouble();
        }

        double[] ending = new double[number];
        int z = 0;
        for(int i = 0; i < number * 2; i += 2){
            double total = 0;

            for (int j = 0; j < number * 2; j += 2){
                total += distanceFormula(list[i], list[i + 1], list[j], list[j + 1]);
            }
            ending[z] = total;
            z++;
        }

        double min = ending[0];
        int min_ID = 0;
        for (int a = 1; a < ending.length; a++){
            if(ending[a] < min){
                min = ending[a];
                min_ID = a;
            }
        }

        System.out.println("The central city is at (" + list[min_ID * 2] + ", " + list[min_ID * 2 + 1] + ")");
        System.out.println("The total distance to all other cities is " + String.format("%.2f", min));
    }

    public static double distanceFormula(double x_start, double y_start, double x_new, double y_new){
        return Math.sqrt(Math.pow((x_new - x_start),2) + Math.pow((y_new - y_start), 2));
    }
}