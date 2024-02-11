public class countHi {    
    public static void main(String[] args) {

        System.out.println(countHi("xxhixx"));
        System.out.println(countHi("xhixhix"));
        System.out.println(countHi("hi"));
    }

    public static int countHi(String str){
        if (str.length() <= 1){
            return 0;
        }
        else{
            int recurse = 0;
            if(str.substring(str.length() - 2, str.length()).equals("hi")){
                recurse++;
            }
            return recurse + countHi(str.substring(0, str.length() - 1));
        }
    }
}