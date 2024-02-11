public class  catDog {
    public static void main(String[] args) {

        System.out.println(catDog("catdog"));
        System.out.println(catDog("catcat"));
        System.out.println(catDog("1cat1cadodog"));
    }

    public static boolean catDog(String str){
        int cats = 0;
        int dogs = 0;
                                                                // I'll be getting the next two letters after i
        for (int i = 0; i < str.length() - 2; i++){             // so the loop should stop 2 before the end
            if (str.substring(i, i+3).equals("cat")){           // == doesn't work because java is stupid
                cats++;
            } else if ( str.substring(i, i+3).equals("dog")){   // .equals() works more often
                dogs++;
            }
        }
        return (cats == dogs);                                  // returns whether they're the same number or not
    }
}