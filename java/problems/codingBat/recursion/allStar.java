public class  allStar {
    public static void main(String[] args) {

        System.out.println(allStar("hello"));
        System.out.println(allStar("abc"));
        System.out.println(allStar("ab"));
    }

    public static String allStar(String str){
        if(str.length() == 0){
            return "";
        }
        if(str.length() == 1){
            return str;
        }
        return allStar(str.substring(0, str.length() - 1)) + "*" + str.charAt(str.length()-1);
    }
}