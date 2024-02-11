import java.util.Scanner;

public class Exercise03_21 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter year: ");
        int year = scan.nextInt();
        int j = year / 100;
        int k = year % 100;

        System.out.println("Enter month: 1-12");
        int m = scan.nextInt();
        if (m < 3){
            m += 12;
            k--;
        }
        if (k == -1){
            k += 100;
            j--;
        }

        System.out.println("Enter day of the month: 1-31");
        int q = scan.nextInt();

        int h = (q + 26 * (m+1) / 10 + k + k/4 + j/4 + 5 * j) % 7;
        switch(h){
            case 0:
                System.out.println("\n\n\n\n\n\nDay of the week is Saturday");
                break;
            case 1: 
                System.out.println("\n\n\n\n\n\nDay of the week is Sunday");
                break;
            case 2: 
                System.out.println("\n\n\n\n\n\nDay of the week is Monday");
                break;
            case 3: 
                System.out.println("\n\n\n\n\n\nDay of the week is Tuesday");
                break;
            case 4: 
                System.out.println("\n\n\n\n\n\nDay of the week is Wednesday");
                break;
            case 5:
                System.out.println("\n\n\n\n\n\nDay of the week is Thursday");
                break;
            case 6:
                System.out.println("\n\n\n\n\n\nDay of the week is Friday");
                break;
        }
    }
}