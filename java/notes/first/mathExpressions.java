
public class mathExpressions {
  public static void main(String[] args){
    int a = 3;
    int b = 4;
    int c = 5;
    int d = 17;
    
    /*
     * values of a,b,c,d
     */
    System.out.println("int a = 3;\nint b = 4;\nint c = 5;\nint d = 17;\n\n\n");

    

    /*
     * 3 and 4 are added with sum 7       
     * 7 is divided by 5 with 1 as the result of integer division
     * The value displayed is 1
     */
    System.out.println("(a + b) / c: \t\t\t" + (a + b) / c);   
    
    /*
     * Because division has higher precedence, 4 is divided by 5 with 0 as the result of integer division       
     * 3 is added to 0 with sum 3
     * The value displayed is 3
     */
    System.out.println("a + b / c: \t\t\t" + a + b / c);       
        
    /*
     * a is incremented before a giving it a value of a + 1 on the line it is declared on
     * The value displayed is 4
     */
    System.out.println("++a: \t\t\t\t" + ++a);
        
    /*
     * a is decremented before a giving it a value of a - 1 on the line it is declared on
     * The value displayed is 3
     */
    System.out.println("--a: \t\t\t\t" + --a);
        
    /*
     * a is incremented after a giving it a value of a + 1 on the next line that is it displayed
     * The value displayed is 3
     * but if it is called again right after it would display 4
     */
    System.out.println("a++: \t\t\t\t" + a++);
    System.out.println("a: \t\t\t\t" + a);
        
    /*
     * a is incremented after a giving it a value of a + 1 on the next line that is it displayed
     * The value displayed is 4
     * but if it is called again right after it would display 3
     */
    System.out.println("a--: \t\t\t\t" + a--);
    System.out.println("a: \t\t\t\t" + a);
        
    /*
     * 1 is added to 3 with sum 4
     * The value displayed is 4
     */
    System.out.println("a + 1: \t\t\t\t" + a + 1);
        
    /*
     * 17 is divided by 5 using the modulo operator with quotient 3
     * because the modulo operator is used the program subtracts 17 with the result of 5 multiplied by the quotient which is 15.
     * the result of the subtraction is 2
     * The value displayed is 2
     */      
    System.out.println("d % c: \t\t\t\t" + d % c);
        
    /*
     * 17 is divided by 5 with the result of integer division being 3
     * The value displayed is 3
     */
    System.out.println("d / c: \t\t\t\t" + d / c);       
        
    /*
     * 17 is divided by 4 using the modulo operator with quotient 4
     * because the modulo operator is used the program subtracts 17 with the result of 4 multiplied by the quotient which is 16
     * the result of the subtraction is 1
     * The value displayed is 1
     */
    System.out.println("d % b: \t\t\t\t" + d % b);    
        
    /*
     * 17 is divided by 4 with the result of integer division being 4
     * The value displayed is 4
     */   
    System.out.println("d / b: \t\t\t\t" + d / b); 
        
    /*
     * because division has higher precedence 3 is divided by 17 first which results in 0
     * 17 is added to 0 which is added to 4 with sum 21
     * The value displayed is 21
     */      
    System.out.println("d + a / d + b: \t\t\t" + (d + a / d + b));  
        
    /*
     * because parenthesis have higher precedence than division 17 is added to 3 with sum 20
     * 17 is addedt to 4 with sum 21
     * 20 is divided by 21 with integer division meaning the result is 0
     * The value displayed is 0
     */  
    System.out.println("(d + a) / (d + b): \t\t" + (d + a) / (d + b));  
        
    /*
     * the square root of 4 is computed with the result being 2 as a float
     * The value displayed is 2.0
     */   
    System.out.println("Math.sqrt(b): \t\t\t" + Math.sqrt(b));      
        
    /*
     * Math.pow computes the result of 3 to the power of 4 with the result 81 as a float
     * The value displayed is 81.0
     */
    System.out.println("Math.pow(a, b): \t\t" + Math.pow(a, b));     
        
    /*
     * the absolute value of a negative version of 3 is computed
     * the absolute value returns the positive of any negative number which turns -3 into positive 3
     * The value displayed is 3
     */       
    System.out.println("Math.abs(-a): \t\t\t" + Math.abs(-a));
        
    /*
     * Math.max returns the larger of the numbers that it is given
     * 4 > 3
     * The value displayed is 4
     */
    System.out.println("Math.max(a, b): \t\t" + Math.max(a, b));    
  } 
} 
