public class noX {
    public static void main(String[] args) {

        System.out.println(noX("xaxb"));
        System.out.println(noX("abc"));
        System.out.println(noX("xx"));
    }
    public static String noX(String str){
        if (str.length() == 0){
            return "";
        }
        else{
            if(str.charAt(str.length() - 1)  == 'x'){
                return noX(str.substring(0, str.length() - 1));
            }
            return noX(str.substring(0, str.length() - 1)) + str.charAt(str.length() - 1);
        }
    }
}