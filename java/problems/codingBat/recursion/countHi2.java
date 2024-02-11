public class  countHi2 {
    public static void main(String[] args) {

        System.out.println(countHi2("ahixhi"));
        System.out.println(countHi2("ahibhi"));
        System.out.println(countHi2("xhixhi"));
    }

    public static int countHi2(String str){
        if(str.length() <= 1){
            return 0;
        }
        if (str.substring(str.length() - 2, str.length()).equals("hi") ){
            if (str.length() == 2 || str.charAt(str.length() - 3) != 'x'){
                return 1 + countHi2(str.substring(0, str.length() - 1));
            }
        }
        return countHi2(str.substring(0, str.length() - 1));
    }
}