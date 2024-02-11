import java.util.Scanner;

public class Exercise04_17 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a year");
        int year = scan.nextInt();
        scan.nextLine();
        System.out.println("enter a month");
        String month = scan.nextLine();

        switch(month){
            case "Jan":
                System.out.println(month + " " + year + " has 31 days");
                break;
            case "Feb":
                if (year % 4 == 0){
                    System.out.println(month + " " + year + " has 29 days");
                } else{
                    System.out.println(month + " " + year + " has 28 days");
                }
                break;
            case "Mar":
                System.out.println(month + " " + year + " has 31 days");
                break;
            case "Apr":
                System.out.println(month + " " + year + " has 30 days");
                break;
            case "May":
                System.out.println(month + " " + year + " has 31 days");
                break;
            case "Jun":
                System.out.println(month + " " + year + " has 30 days");
                break;
            case "Jul":
                System.out.println(month + " " + year + " has 31 days");
                break;
            case "Aug":
                System.out.println(month + " " + year + " has 31 days");
                break;
            case "Sep":
                System.out.println(month + " " + year + " has 30 days");
                break;
            case "Oct":
                System.out.println(month + " " + year + " has 31 days");
                break;
            case "Nov":
                System.out.println(month + " " + year + " has 30 days");
                break;
            case "Dec":
                System.out.println(month + " " + year + " has 31 days");
                break;
            default:
                System.out.println(month + " is not a correct month name");
        }
    }
}