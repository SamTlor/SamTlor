public class xyBalance {
    public static void main(String[] args) {
        System.out.println( xyBalance("aaxbby") );
        System.out.println( xyBalance("aaxbb") );
        System.out.println( xyBalance("yaaxbb") );
    }

    public static boolean xyBalance(String str){
        boolean balanced = true;                                    // will return true if it doesn't find any x's or y's

        for(int i = 0; i < str.length(); i++){                      
            if(str.charAt(i) == 'x' && balanced == true){           // the first time it finds an x
                balanced = false;                                   // make it unbalanced because it hasn't found a y yet
            }else if (str.charAt(i) == 'y' && balanced == false){   // if it hasn't found a y yet and it finds one
                balanced = true;                                    // make it balanced again
            }
        }
        return balanced;
    }
}