package Labs.Lab12;

public class DriversLicense extends IDCard{
    private int expirationYear;
    private Month expirationMonth;

    public DriversLicense(){
        super();
        expirationYear = 1969;
        expirationMonth = Month.values()[0];
    }
    public DriversLicense(String theName, int theIdNum, int theExpirationYear, Month theExpirationMonth){
        super(theName, theIdNum);
        expirationYear = theExpirationYear;
        expirationMonth = theExpirationMonth;
    }
    public String toString(){
        return super.toString() + " Expiration Month & Year: " + expirationMonth + " " + expirationYear;
    }
}