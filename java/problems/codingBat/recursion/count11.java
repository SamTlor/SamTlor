public class count11{
    public static void main(String[] args) {

        System.out.println(count11("11abc11"));
        System.out.println(count11("abc11x11x11"));
        System.out.println(count11("111 "));
    }

    public static int count11(String str){
        if (str.length() <= 1){
            return 0;
        }
        String tester = str.substring(str.length() - 2, str.length());

        if (tester.equals("11")){
            return 1 + count11(str.substring(0, str.length() - 2));
        }
        return count11(str.substring(0, str.length() - 1));
    }
}