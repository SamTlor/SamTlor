public class  countCode {
    public static void main(String[] args) {

        System.out.println(countCode("aaacodebbb"));
        System.out.println(countCode("codexxcode"));
        System.out.println(countCode("cozexxcope"));
    }

    public static int countCode(String str){
        int count = 0;                                                                      
        for (int i = 0; i < str.length() - 3; i++){ //I need the next three letters after i, so the loop should stop 3 before the end
            if(str.charAt(i) == 'c' && str.charAt(i + 1) == 'o' && str.charAt(i + 3) == 'e'){   // if co {something} e 
                count++;                                                                        // increment
            }
        }
        return count;
    }
}