public class relational_operators {
    public static void main(String[] args) {
            int a = 10, b = 10;

            System.out.println("a is: "+a+ " and b is "+b);

            if (a > b) System.out.println("a is greater than b"); 
            else System.out.println("a is less than or equal to b"); 
        
            // greater than equal to 
            if (a >= b) 
                System.out.println("a is greater than or equal to b"); 
            else System.out.println("a is lesser than b"); 
        
            // less than example 
            if (a < b) 
                System.out.println("a is less than b"); 
            else System.out.println("a is greater than or equal to b"); 
        
            // lesser than equal to 
            if (a <= b) 
                System.out.println("a is lesser than or equal to b"); 
            else System.out.println("a is greater than b"); 
        
            // equal to 
            if (a == b) 
                System.out.println("a is equal to b"); 
            else System.out.println("a and b are not equal"); 
        
            // not equal to 
            if (a != b) 
                System.out.println("a is not equal to b"); 
            else System.out.println("a is equal b"); 
        }
}
