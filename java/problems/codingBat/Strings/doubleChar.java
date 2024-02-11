public class doubleChar {
    public static void main(String[] args) {
        System.out.println( doubleChar("the") );
        System.out.println( doubleChar("AAbb") );
        System.out.println( doubleChar("Hi-There") );
    }

    public static String doubleChar(String str){
        String ending = "";                                     // final return value
        for(int i = 0; i < str.length(); i++){
            ending += String.valueOf(str.charAt(i));            // add each value
            ending += String.valueOf(str.charAt(i));            // twice
        }
        return ending;                                          // return final
    }
}