public class Exercise06_13 {
    public static void main(String[] args) {
        System.out.println("i m(i)");
        double sum = 0;
        int j = 1;
        
        for (double i = 1; i < 21; i++){
            sum += i / (i+1);
            System.out.println(j + " " + sum);
            j++;
        }
    }
}