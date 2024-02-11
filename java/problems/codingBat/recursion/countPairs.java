public class countPairs {
    public static void main(String[] args) {
        System.out.println(countPairs("axa"));
        System.out.println(countPairs("axax"));
        System.out.println(countPairs("axbx"));
    }

    public static int countPairs(String str){
        if (str.length() <= 2){
            return 0;
        }
        if ( Character.compare(str.charAt(str.length() - 1), (str.charAt(str.length() - 3))) == 0 ) {
            return 1 + countPairs(str.substring(0, str.length() - 1));
        }
        return countPairs(str.substring(0, str.length() - 1));
    }
}