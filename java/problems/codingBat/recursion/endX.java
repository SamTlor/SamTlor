public class endX {
    public static void main(String[] args) {

        System.out.println(endX("xxre"));
        System.out.println(endX("xxhixx"));
        System.out.println(endX("xhixhix"));
    }

    public static String endX(String str){
        if(str.length() == 0){
            return "";
        }
        if(str.charAt(0) == 'x'){
            return endX(str.substring(1, str.length())) + 'x';
        }
        return str.charAt(0) + endX(str.substring(1, str.length()));
    }
}