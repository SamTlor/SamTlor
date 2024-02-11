public class  stringClean {
    public static void main(String[] args) {

        System.out.println(stringClean("yyzzza"));
        System.out.println(stringClean("abbbcdd"));
        System.out.println(stringClean("Hello"));
    }

    public static String stringClean(String str){
        if(str.length() == 0){
            return "";
        }
        if(str.length() == 1){
            return str;
        }
        if(str.charAt(str.length() - 1) == str.charAt(str.length() - 2)){
            return stringClean(str.substring(0, str.length() - 2) + str.charAt(str.length() - 1));
        }
        return stringClean(str.substring(0, str.length() - 1)) + str.charAt(str.length() - 1);
    }
}