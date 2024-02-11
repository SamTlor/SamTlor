import java.util.Scanner;

public class Exercise06_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter investment amount");
        double investmentAmount = scan.nextDouble();
        System.out.println("Enter monthly interest rate");
        double monthlyInterestRate = scan.nextDouble();

        futureInvestmentValue(investmentAmount, monthlyInterestRate);
    }
    public static void futureInvestmentValue(double investmentAmount, double monthlyInterestRate) {
        for (int i = 1; i < 31; i++){
            double value = investmentAmount * Math.pow((1 + monthlyInterestRate/1200), i * 12);
            System.out.println(i + " " + value);
        }
    }
}