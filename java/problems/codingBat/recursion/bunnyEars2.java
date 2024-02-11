public class  bunnyEars2 {
    public static void main(String[] args) {

        System.out.println(bunnyEars2(0));
        System.out.println(bunnyEars2(1));
        System.out.println(bunnyEars2(2));
    }

    public static int bunnyEars2(int bunnies){
        if (bunnies == 0){
            return 0;
        } else{
            int recurse = bunnyEars2(bunnies - 1);
            int result;
            if(bunnies % 2 == 0){
                result = 3 + recurse;
            }else{
                result = 2 + recurse;
            }
            return result;

        }
    }
}