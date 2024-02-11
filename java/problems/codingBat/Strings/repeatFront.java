public class  repeatFront {
    public static void main(String[] args) {

        System.out.println(repeatFront("Chocolate", 4));
    }

    public static String repeatFront(String str, int n){        
        String ending = "";                                 // final return value

        for (int i = 0; i < n; i++){                        // n many times
            ending += str.substring(0, n-i);                // n stays the same but i get bigger and bigger. i stops when n == i
        }

        return ending;
    }
}