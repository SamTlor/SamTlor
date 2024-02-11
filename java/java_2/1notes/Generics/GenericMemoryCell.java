public class GenericMemoryCell<AnyType> {
    private AnyType storedValue;

    public void write(AnyType obj){
        storedValue = obj;
    }
    public AnyType read(){
        return storedValue;
    }



    public static void main(String[] args){
        GenericMemoryCell<String> m = new GenericMemoryCell<String> ();

        m.write("57");
        String val = m.read();
        System.out.println("Contents are: " + val);




        GenericMemoryCell<Integer> mInt = new GenericMemoryCell<> ();

        mInt.write(42);
        Integer val2 = mInt.read();
        System.out.println("Contents are: " + val2);
    }
}

