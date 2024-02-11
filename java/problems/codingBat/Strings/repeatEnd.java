public class  repeatEnd {
    public static void main(String[] args) {
        System.out.println(repeatEnd("Hello", 3));
        System.out.println(repeatEnd("Hello", 2));
        System.out.println(repeatEnd("Hello", 1));
    }

    public static String repeatEnd(String str, int n){
        String ending = "";                                     // final return value

        String repeater = str.substring(str.length() - n);      // thing that will be repeated. length() - n ==> the last n letters

        for (int i = 0; i < n; i++){
            ending += repeater;
        }
        return ending;
    }
}