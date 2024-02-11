public class extendo_clip{
    public static void main(String[] args){
        ICalculator2 test = new ICalculator2(5);

        System.out.println(test.add(35));
        System.out.println(test.negativize());
    }
}


class ICalculator {
    private int currentValue;
    public int get_CurrentValue(){
        return currentValue;
    }

    public ICalculator(int start){
        currentValue = start;
    }

    public int add(int other){
        currentValue += other;
        return currentValue;
    }
    public int sub(int other){
        currentValue -= other;
        return currentValue;
    }
    public int mul(int other){
        currentValue *= other;
        return currentValue;
    }
    public int div(int other){
        currentValue /= other;
        return currentValue;
    }
}

class ICalculator2 extends ICalculator{
    public ICalculator2(int start){
        super(start);
    }

    public int negativize(){
        return get_CurrentValue() * -1;
    }   
}