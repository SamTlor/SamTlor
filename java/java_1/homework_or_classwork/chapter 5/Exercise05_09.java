import java.util.Scanner;

public class Exercise05_09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String bigname, littlename;
        double bigscore, littlescore;

        bigname = littlename = "";
        bigscore = littlescore = 0;



        System.out.println("Enter the number of students");
        int students = scan.nextInt();



        for (int i = 0; i < students; i++){
            System.out.println("Enter a student's name: ");
            String name = scan.next();
            System.out.println("Enter a student's score: ");
            int score = scan.nextInt();

            if (score > bigscore){
                littlescore = bigscore;
                littlename = bigname;
                bigscore = score;
                bigname = name;
            } else if(score > littlescore){
                littlescore = score;
                littlename = name;
            }
        }
        System.out.println("Top two students:");
        System.out.println(bigname + "'s score is " + bigscore);
        System.out.println(littlename + "'s score is " + littlescore);
    }
}