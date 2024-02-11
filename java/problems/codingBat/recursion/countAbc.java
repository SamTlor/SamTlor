public class countAbc {
    public static void main(String[] args) {

        System.out.println(countAbc("abc"));
        System.out.println(countAbc("abcxxabc"));
        System.out.println(countAbc("abaxxaba"));
    }

    public static int countAbc(String str){
        if (str.length() <= 2){
            return 0;
        }
        String tester = str.substring(str.length() - 3, str.length());

        if (tester.equals("abc") || tester.equals("aba")){
            return 1 + countAbc(str.substring(0, str.length() - 1));
        }
        return countAbc(str.substring(0, str.length() - 1));
    }
}