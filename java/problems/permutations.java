public class permutations {
    public static void main(String[] args) {
        String str = "1234";

        permutations perm = new permutations();
        perm.permute(str, 0, str.length() - 1);
    }

    /**
    * permutation function
    * str: string to calculate permutation for
    * how_long: starting index
    * ending: end index
    */
    private void permute(String str, int how_long, int ending){
        if(how_long == ending){
            System.out.println(str);
        }
        for (int i = how_long; i <= ending; i++){
            str = swap(str, how_long, i);
            permute(str, how_long + 1, ending);
            str = swap(str, how_long, i);
        }
    }

    public String swap(String a, int i, int j){
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}