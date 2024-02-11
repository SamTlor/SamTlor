package Labs.Lab12;

public class DebitCard extends Card{
    private int cardNumber;
    private int pin;

    public DebitCard(){
        super("Jane Doe");
        cardNumber = 00000000;
        pin = 0;
    }
    public DebitCard(String theName, int theCardNumber, int thePin){
        super(theName);
        cardNumber = theCardNumber;
        pin = thePin;
    }
    public String toString(){
        return super.toString() + " Card Number: " + cardNumber;
    }
}