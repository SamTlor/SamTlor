import java.util.Scanner;

public class Exercise05_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pos, neg, all;
        double total, avg;
        pos = neg = all = 0;
        total = 0;

        System.out.println("Enter an integer, the input ends if it is 0:");
        int n = scan.nextInt();
        while(n != 0){
            if (n > 0){
                pos++;
            }else{
                neg++;
            }
            all++;
            total += n;

            n = scan.nextInt();
        }

        if(all == 0){
            System.out.println("No numbers are entered except 0");
        }else {
            avg = total / all;
            System.out.println("The number of positives is " + pos);
            System.out.println("The number of negatives is " + neg);
            System.out.println("The total is " + total);
            System.out.println("The number of average is " + avg);
        }
    }
}