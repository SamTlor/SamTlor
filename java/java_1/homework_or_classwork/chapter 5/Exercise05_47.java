import java.util.Scanner;

public class Exercise05_47 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the first 12 digits of an ISBN-13 as a string: ");
        String twelve = scan.nextLine();

        if (twelve.length() != 12){
            System.out.println(twelve + " is an invalid input");
        } else {
            long var = Long.parseLong(twelve);
            long original = var;

            int sum = 0;
            for (int i = 1; i < 13; i++){
                if (i % 2 == 1) {
                    sum += (var % 10) * 3;
                } else {
                    sum += var % 10;
                }
                var /= 10;
            }
            System.out.print("The ISBN-13 number is ");
            if (sum % 10 != 0){
                System.out.println((original * 10) + 10 - sum % 10);
            } else {
                System.out.println(original * 10);
            }
        }
    }
}