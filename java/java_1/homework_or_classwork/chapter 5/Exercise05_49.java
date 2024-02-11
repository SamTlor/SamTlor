import java.util.Scanner;

public class Exercise05_49 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int vows, cons;
        vows = cons = 0;

        System.out.println("Enter a string: ");
        String phrase = scan.nextLine();

        for (int i = 0; i < phrase.length(); i++){
            if (phrase.charAt(i) != ' '){
                if ("AEIOU".indexOf(Character.toUpperCase(phrase.charAt(i))) < 0){
                    cons++;
                } else{
                    vows++;
                }
            }
        }
        System.out.println("The number of vowels is " + vows);
        System.out.println("The number of consonants is " + cons);
    }
}