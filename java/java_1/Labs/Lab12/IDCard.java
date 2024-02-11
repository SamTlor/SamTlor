package Labs.Lab12;

public class IDCard extends Card{
    private int idNumber;

    public IDCard(){
        super("Jane Smith");
        idNumber = 0;
    }
    public IDCard(String theName, int theIDNum){
        super(theName);
        idNumber = theIDNum;
    }
    public String toString(){
        return super.toString() + " ID Number: " + idNumber;
    }
}
