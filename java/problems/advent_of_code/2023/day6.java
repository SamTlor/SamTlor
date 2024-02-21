import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class day6 {

    // Solve the quadratic equation ax^2 + bx + c = 0
    public static double[] solveQuadratic(double b, double c) {
        double discriminant = (b * b) - (4 * c);
        double[] roots = new double[2];

        if (discriminant > 0) {
            roots[0] = (-b + Math.sqrt(discriminant)) / 2;
            roots[1] = (-b - Math.sqrt(discriminant)) / 2;
        } else if (discriminant == 0) {
            roots[0] = -b / 2;
            roots[1] = roots[0]; // Both roots are the same
        } else {
            // Complex roots
            roots[0] = -b / 2;
            roots[1] = Math.sqrt(-discriminant) / 2;
        }

        return roots;
    }



    public static int part1() {

        // Create a File object
        File file = new File("day6.txt");
        
        // store the numbers in their respective list
        List<Double> firstRowList = new ArrayList<>();
        List<Double> secondRowList = new ArrayList<>();

        try {
            // Create a FileInputStream to read bytes from the file
            FileInputStream fileInputStream = new FileInputStream(file);

            // Create an InputStreamReader to decode bytes into characters
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            // Create a BufferedReader to read text from the character-input stream
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            
            
            // Read lines from the file until reaching the end or the second row
            String line;
            int rowCount = 0;
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line by whitespace to extract individual numbers
                String[] numbers = line.trim().split("\\s+");

                // Parse and add each number to the corresponding list based on the current row
                for (String numStr : numbers) {
                    try {
                        // Parse the string representation of the number into an actual number
                        double number = Double.parseDouble(numStr);

                        // Add the parsed number to the appropriate list based on the current row
                        if (rowCount == 0) {
                            firstRowList.add(number);
                        } else {
                            secondRowList.add(number);
                        }
                    } catch (NumberFormatException e) {}
                }
                rowCount++; // Increment the row counter
            }

            // Close the BufferedReader
            bufferedReader.close();
        } catch (IOException e) {}



        int total = 1;
        for (int i = 0; i < firstRowList.size(); i++){

            double[] roots = solveQuadratic(-1 * firstRowList.get(i), secondRowList.get(i));
            total *= (int) Math.abs(Math.floor(roots[1]) - Math.ceil(roots[0])) - 1;
        }


        return total;
    }



    public static int part2() {

        // Create a File object
        double[] numbers = new double[2];
        int counter = 0;
        File file = new File("day6.txt");

        try {
            // Create a FileInputStream to read bytes from the file
            FileInputStream fileInputStream = new FileInputStream(file);

            // Create an InputStreamReader to decode bytes into characters
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            // Create a BufferedReader to read text from the character-input stream
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            

            // Read lines from the file until reaching the end
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Remove all whitespace from the line to concatenate the numbers
                String concatenatedNumbers = line.replaceAll("[^0-9.]", "");

                try {
                    // Parse the concatenated string of numbers into a single double
                    double number = Double.parseDouble(concatenatedNumbers);
                    numbers[counter] = number;
                    counter++;

                } catch (NumberFormatException e) {}
            }

            // Close the BufferedReader
            bufferedReader.close();
        } catch (IOException e) {}


        double[] result = solveQuadratic(-1 * numbers[0], numbers[1]);

        return (int) Math.abs(Math.floor(result[1]) - Math.ceil(result[0])) - 1;
    }


    public static void main(String[] args) {

        // PART 1
        System.out.println(part1());

        // PART 2
        System.out.println(part2());

    }
}