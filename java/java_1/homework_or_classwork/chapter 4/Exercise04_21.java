import java.util.Scanner;

public class Exercise04_21 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a valid Social security number");
        
        String socialSecurity = scan.nextLine();

        if (socialSecurity.charAt(3) != '-' || socialSecurity.charAt(6) != '-'){
            System.out.println(socialSecurity + " is an invalid social security number");
        } else{
            System.out.println(socialSecurity + " is a valid social security number");
        }
    }
}