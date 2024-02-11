public class count7 {
    public static void main(String[] args) {

        System.out.println(count7(717));
        System.out.println(count7(7));
        System.out.println(count7(123));
    }

    public static int count7(int n){
        if(n == 0){
            return 0;
        }
        else{
            int recurse = 0;
            if(n % 10 == 7){
                recurse++;
            }
            return recurse + count7(n / 10);
        }
    }
}