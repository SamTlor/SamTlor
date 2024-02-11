public class countHi {
    public static void main(String[] args) {
        System.out.println(countHi("ABChi hi"));
    }

    public static int countHi( String str ){
        int count = 0;
        for(int i = 0; i < str.length()-1; i++){                    // "str.length() - 1" because last i would be out of bounds otherwise
            if(str.charAt(i) == 'h' && str.charAt(i+1) == 'i'){     // if 'h' is followed by 'i'
                count++;                                            // increment
            }
        }
        return count;
    }
}