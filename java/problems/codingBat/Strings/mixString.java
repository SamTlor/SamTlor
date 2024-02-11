public class  mixString {
    public static void main(String[] args) {
        System.out.println( mixString("abc", "xyz") );
        System.out.println( mixString("Hi", "There") );
        System.out.println( mixString("xxxx", "There") );
    }

    public static String mixString(String a, String b){
        int shorter = Math.min(a.length(), b.length());         // find the length that i need to keep alternating between
        String ending = "";                                     // final return value

        int i = 0;                                              // will be needing i later
        for(; i < shorter; i++){
            ending += String.valueOf(a.charAt(i));              // alternate
            ending += String.valueOf(b.charAt(i));
        }

        if ( a.length() > b.length() ){                         // if a is longer than b
            ending += a.substring(i);                           // start at where the alternating left off, and add whats left to ending
        } else if( a.length() < b.length() ){                   // if b is longer than a
            ending += b.substring(i);                           // start at where the alternating left off, and add whats left to ending
        }

        return ending;
    }
}