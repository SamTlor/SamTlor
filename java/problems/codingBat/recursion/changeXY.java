public class changeXY {
    public static void main(String[] args) {

        System.out.println(changeXY("codex"));
        System.out.println(changeXY("xxhixx"));
        System.out.println(changeXY("xhixhix"));
    }

    public static String changeXY(String str){
        if(str.length() == 0){
            return "";
        }
        else{
            int end_of_string = str.length() - 1;

            if(str.charAt(end_of_string) == 'x'){
                return changeXY(str.substring(0, end_of_string) + 'y');
            }
            return changeXY(str.substring(0, end_of_string)) + str.charAt(end_of_string);
        }
    }
}