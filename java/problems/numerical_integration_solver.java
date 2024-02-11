import java.lang.Math;

public class  numerical_integration_solver {
    public static void main(String[] args) {


        double a = 3;
        double b = 11; 
        double n = 1; 
        double change = (b - a) / n;


        double midpoint = 0;
        for (double i = 0; i < b; i += change){
            midpoint += mather((i + i + change) / 2);
            System.out.println(midpoint + "\n");
        }
        System.out.println(change * midpoint);

        double trapezoid = (mather(a) + mather(b)) / 2;
        for (double i = a + change; i < b; i += change){
            trapezoid += mather(i);
        }
        System.out.println(change * trapezoid);

        double simpson = mather(a) + mather(b);
        int outer = 0;
        for (double i = a + change; i < b; i += change){
            if(outer == 0){
                simpson += 4 * mather(i);
                outer++;
            }else{
                simpson += 2 * mather(i);
                outer--;
            }
        }
        System.out.println((change/3) * simpson);
    }

    public static double mather(double x){
        return Math.pow(x, 3);
    }
}