public class changePi {
    public static void main(String[] args) {

        System.out.println(changePi("xpix"));
        System.out.println(changePi("pipi"));
        System.out.println(changePi("pip"));
    }

    public static String changePi(String str){
        if(str.length() == 0){
            return "";
        }
        if(str.length() == 1){
            return str;
        }
        else{
            if(str.substring(str.length() - 2, str.length()).equals("pi")){
                return changePi(str.substring(0, str.length() - 2)) + "3.14";
            }
            return changePi(str.substring(0, str.length() - 1)) + str.charAt(str.length() - 1);
        }
    }
}