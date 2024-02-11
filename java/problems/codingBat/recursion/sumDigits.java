public class  sumDigits {
    public static void main(String[] args) {

        System.out.println(sumDigits(126));
        System.out.println(sumDigits(49));
        System.out.println(sumDigits(12));
    }

    public static int sumDigits(int n){
        if (n == 0){
            return 0;
        }
        else{
            int recurse = (n % 10);
            return recurse + sumDigits(n / 10);
        }
    }
}