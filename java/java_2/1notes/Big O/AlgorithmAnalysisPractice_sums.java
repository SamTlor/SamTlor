//SUM VERSION

public class AlgorithmAnalysisPractice_sums {
    public static void main(String[] args) {

        int n = 5;

        int sum = 0;
        // Fragment 1
        for (int i = 0; i < n; i++){
            sum++;
        }
        System.out.println("n           fragment 1 ran " + sum + " times");



        sum = 0;
        // Fragment 2
        for (int i = 0; i < n; i += 2){
            sum++;
        }
        System.out.println("n           fragment 2 ran " + sum + " times");


        sum = 0;
        // Fragment 3
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                sum++;
            }
        }
        System.out.println("n^2         fragment 3 ran " + sum + " times");


        sum = 0;
        // Fragment 4
        for (int i = 0; i < n; i++)
            sum++;
        for (int j = 0; j < n; j++)
            sum++;
        System.out.println("n           fragment 4 ran " + sum + " times");

        
        sum = 0;
        // Fragment 5
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n * n; j++)
                sum++;
        System.out.println("n^3         fragment 5 ran " + sum + " times");
        
        
        sum = 0;
        // Fragment 6
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)
                sum++;
        System.out.println("n^2         fragment 6 ran " + sum + " times");

        
        sum = 0;
        // Fragment 7
        for (int i = 1; i < n; i = i * 2)
            sum++;
        System.out.println("log2 (n)    fragment 7 ran " + sum + " times        (rounds up)");
        
        
        sum = 0;
        // Fragment 8
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n * n; j++)
                for (int k = 0; k < j; k++)
                    sum++;
        System.out.println("n^5         fragment 8 ran " + sum + " times");
    }
}