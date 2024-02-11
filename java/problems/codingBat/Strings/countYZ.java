public class  countYZ {
    public static void main(String[] args) {

        System.out.println(countYZ("fez day"));
        System.out.println(countYZ("day fez"));
        System.out.println(countYZ("day fyyyz"));
    }

    public static int countYZ(String str){
        int count = 0;
        int i = 0;
        for (; i < str.length()-1; i++){
            // if the one above i is not a letter and the one at i is Z or Y
            if (!Character.isLetter(str.charAt(i+1)) && (Character.toUpperCase(str.charAt(i)) == 'Z' || Character.toUpperCase(str.charAt(i)) == 'Y') ) {
                count++;
            }
        }// if the last letter is Z or Y
        if (Character.toUpperCase(str.charAt(i)) == 'Z' || Character.toUpperCase(str.charAt(i)) == 'Y'){
            count++;
        }
        return count;
    }


}