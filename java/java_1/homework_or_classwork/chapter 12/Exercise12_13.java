import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Exercise12_13 {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Usage: java filename");
            System.exit(1);
        }

        File input = new File(args[0]);
        if(!input.exists()){
            System.out.println("File " + args[0] + " does not exist");
            System.exit(2);
        }

        int lines = 0;
        int words = 0;
        int characters = 0;

        try {
            Scanner scan = new Scanner(input);

            while(scan.hasNextLine()){
                String var = scan.nextLine();
                characters += var.length();

                String[] sentence = var.split(" ");
                words += sentence.length;
                lines++;
            }

            System.out.println("File " + input.getName() + " has");
            System.out.println(characters + " characters");
            System.out.println(words + " words");
            System.out.println(lines + " lines");

        } catch (FileNotFoundException e){};
    }
}