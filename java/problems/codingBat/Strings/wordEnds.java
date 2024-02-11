public class  wordEnds {
    public static void main(String[] args) {

        System.out.println(wordEnds("abcXY123XYijk", "XY"));
        System.out.println(wordEnds("XY123XY", "XY"));
        System.out.println(wordEnds("XY1XY", "XY"));
        System.out.println(wordEnds("abc1xyz1", "1"));
        System.out.println(wordEnds("abc1xyz11", "1"));
        System.out.println(wordEnds("XYXY", "XY"));

    }

    public static String wordEnds(String str, String word){
        String ending = "";
        
        for (int i = 0; i < str.length()-word.length()+1; i++){     // less than the length of the string minus word + 1 so it still checks the word
            if ( str.substring(i, i + word.length()).equals(word) ){// if i --> length of the word == word
                if (i != 0){                                        // makes sure there's no out of bound exceptions
                    ending += str.charAt(i - 1);                    // gets the letter below the word
                }
                if (i != str.length()-word.length()){
                    ending += str.charAt(i + word.length());
                }
            }
        }
        return ending;
    }
}