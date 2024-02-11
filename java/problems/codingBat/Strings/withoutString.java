public class  withoutString {
    public static void main(String[] args) {

        System.out.println(withoutString("Hello there", "llo"));
        System.out.println(withoutString("Hello there", "e"));
        System.out.println(withoutString("Hello there", "x"));
        System.out.println(withoutString("This is a FISH", "IS"));
        System.out.println(withoutString("1111", "11"));
        System.out.println(withoutString("Hi HoHo", "Ho"));
    }

    public static String withoutString(String base, String remove){
        String ending = "";

        int i = 0;
        for(; i < base.length()-remove.length() + 1; i++){

            if ( base.substring(i, i + remove.length() ).equals(remove)) {
                i += remove.length()-1;
            } else{
                ending += base.substring(i, i+1);
            }
        }

        if (!(i > base.length()-remove.length())) {
            ending += base.substring(i, i + remove.length()-1);
        }
        return ending;
    }
}