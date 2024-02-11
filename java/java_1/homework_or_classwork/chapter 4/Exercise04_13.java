import java.util.Scanner;
import java.util.Arrays;

public class Exercise04_13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter a letter");
        char letter = scan.next().charAt(0);

        char[] alphabet = {'A', 'E', 'I', 'O', 'U','B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};

        int lightswitch = 0;
        for (int i = 0; i < 26; i++){
            if(alphabet[i] == Character.toUpperCase(letter)){
                if(i < 5){
                    System.out.println(letter + " is a vowel");
                    lightswitch = 1;
                    break;
                } else{
                    System.out.println(letter + " is a consonant");
                    lightswitch = 1;
                    break;
                }
            } 
        }
        if (lightswitch == 0){
            System.out.println(letter + " is an invalid input");
        }
    }
}