public class arithmetic_operators {
    public static void main(String[] args) {
        int a = 10; int b = 4;

        System.out.println("a is: "+a+ " and b is "+b);

        int res = a + b;
        System.out.println("a + b is "+res);
        res = a - b;
        System.out.println("a - b is "+res);
        res = a * b;
        System.out.println("a * b is "+res);
        res = a / b;
        System.out.println("a / b is "+res);
        res = a % b;
        System.out.println("a % b is "+res);

        a++;
        b++;
        System.out.println("a++ is: "+a+ " and b++ is "+b);
    }
}