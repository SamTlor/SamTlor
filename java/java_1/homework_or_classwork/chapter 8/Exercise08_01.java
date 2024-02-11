import java.util.Scanner;

public class Exercise08_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a 3-by-4 matrix row by row");
        double[][] matrix = new double[3][4];

        for (int row = 0; row < 3; row++){
            for (int column = 0; column < 4; column++){
                matrix[row][column] = scan.nextDouble();
            }
        }


        for (int i = 0; i < 4; i++){
            System.out.println("Sum of the elements in column " + i + " is " + sumColumn(matrix, i));
        }

    }

    public static double sumColumn(double[][] m, int columnIndex){
        double sum = 0;
        for (int j = 0; j < 3; j++){
            sum += m[j][columnIndex];
        }

        return sum;
    }
}