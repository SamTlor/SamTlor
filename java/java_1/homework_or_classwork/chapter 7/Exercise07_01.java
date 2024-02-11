import java.util.Scanner;

public class Exercise07_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of students");
        int students = scan.nextInt();

        int[] scores = new int[students];
        char[] grades = new char[students];

        System.out.println("Enter " + students + "scores:");
        for (int i = 0; i < students; i++){
            scores[i] = scan.nextInt();
        }

        int best = scores[0];
        for (int i = 1; i < students; i++){
            if(best < scores[i]){
                best = scores[i];
            }
        }
        
        for (int i = 0; i < students; i++){
            if(scores[i] >= best - 10){
                grades[i] = 'A';
            } else if(scores[i] >= best - 20){
                grades[i] = 'B';
            } else if(scores[i] >= best - 30){
                grades[i] = 'C';
            } else if(scores[i] >= best - 40){
                grades[i] = 'D';
            } else {
                grades[i] = 'F';
            }
        }

        for (int j = 0; j < students; j++){
            System.out.println("Student " + j + " score is " + scores[j] + " and grade is " + grades[j]);
        }
    }
}