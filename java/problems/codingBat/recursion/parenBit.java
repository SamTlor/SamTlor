public class parenBit {
    public static void main(String[] args) {
        System.out.println(parenBit("xyz(abc)123"));
        System.out.println(parenBit("x(hello)"));
        System.out.println(parenBit("(xy)1"));
    }

    public static String parenBit(String str){
        if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')'){
            return str;
        }
        if(str.charAt(0) == '('){
            return parenBit(str.substring(0, str.length() - 1));
        }
        if(str.charAt(str.length() - 1) == ')'){
            return parenBit(str.substring(1, str.length()));
        }
        return parenBit(str.substring(1, str.length() - 1));
    }
}