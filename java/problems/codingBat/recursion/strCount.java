import javax.swing.text.Style;

public class strCount {
    public static void main(String[] args) {

        System.out.println(strCount("catcowcat", "cat"));
        System.out.println(strCount("catcowcat", "cow"));
        System.out.println(strCount("catcowcat", "dog"));
    }

    public static int strCount(String str, String sub){
        if(str.length() < sub.length()){
            return 0;
        }

        if(str.substring(str.length() - sub.length(), str.length()).equals(sub)){
            return 1 + strCount(str.substring(0, str.length() - sub.length()), sub);
        }
        return strCount(str.substring(0, str.length() - 1), sub);
    }
}