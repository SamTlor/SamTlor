public class powerN {
    public static void main(String[] args) {

        System.out.println(powerN(3,1));
        System.out.println(powerN(3,2));
        System.out.println(powerN(3,3));
    }

    public static int powerN(int base, int n){
        if(n == 1){
            return base;
        }
        else{
            return base * powerN(base, n - 1);
        }
    }
}