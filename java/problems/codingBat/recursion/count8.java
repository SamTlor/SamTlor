public class count8 {
    public static void main(String[] args) {

        System.out.println(count8(8));
        System.out.println(count8(818));
        System.out.println(count8(8188));
    }

    public static int count8(int n){
        if(n == 0){
            return 0;
        }
        else{
            int recurse = 0;
            if(n % 10 == 8){
                if(n % 100 == 88){
                    recurse++;
                }
                recurse++;
            }
            return recurse + count8(n / 10);
        }
    }
}