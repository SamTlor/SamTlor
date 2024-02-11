public class nestParen {
    public static void main(String[] args) {

        System.out.println(nestParen("(())"));
        System.out.println(nestParen("((()))"));
        System.out.println(nestParen("(((x))"));
    }

    public static boolean nestParen(String str){
        if(str.length() == 0){
            return true;
        }
        if(str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')'){
            return nestParen(str.substring(1, str.length() - 1));
        }
        return false;
    }
}