public class countX {
    public static void main(String[] args) {

        answer thing = new answer();

        System.out.println(thing.countX("xxhixx"));
        System.out.println(thing.countX("xhixhix"));
        System.out.println(thing.countX("hi"));
    }
}

class answer{
    public int countX(String str){
        /*
        if (str.length() == 0){
            return 0;
        }
        else{
            int recurse = 0;
            if(str.charAt(str.length() - 1)  == 'x'){
                recurse++;
            }
            return recurse + countX(str.substring(0, str.length() - 1));
        }
        */
        return 7;
    }
}