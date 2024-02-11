public class strDist {
    public static void main(String[] args) {
        System.out.println(strDist("catcowcat", "cat"));
        System.out.println(strDist("catcowcat", "cow"));
        System.out.println(strDist("cccatcowcatxx", "cat"));
    }

    public static int strDist(String str, String sub){
        if(str.length() == sub.length()){
            if(str.equals(sub)){
                return str.length();
            }
            return 0;
        }
        if (str.length() < sub.length()){
            return 0;
        }
        if(str.substring(0, sub.length()).equals(sub) && str.substring(str.length() - sub.length(), str.length() ).equals(sub)){
            return str.length();
        }
        if(str.substring(0, sub.length()).equals(sub)){
            return strDist(str.substring(0, str.length() - 1), sub);
        }
        if(str.substring(str.length() - sub.length()).equals(sub)){
            return strDist(str.substring(1, str.length()), sub);
        }
        return strDist(str.substring(1, str.length() - 1), sub);
    }
}