//Summation
/*
public class recursion {
    public static void main(String[] args) {
        System.out.println(factorial(8));
    }

    public static int factorial(int n){
        if (n == 0){                            //base case. stopping point
            return 0;
        }
        else {                  
            int recurse = factorial(n-1);       //cause of the recursion
            int result = n + recurse;           //effect of the recursion
            return result;                      //implementation of the recursion
        }
    }
}
*/

//factorial

public class recursion {
    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

    public static int factorial(int n){
        if (n == 1){                            //base case. stopping point
            return 1;
        }
        else {                  
            int recurse = factorial(n-1);       //cause of the recursion
            int result = n * recurse;           //effect of the recursion
            return result;                      //implementation of the recursion
        }
    }

}
