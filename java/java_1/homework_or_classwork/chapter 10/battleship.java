import java.util.Scanner;

public class battleship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        
        System.out.println("");
    }
}

class Ship{
    private String name;
    private int size;
    private boolean sunk;
    private String coordinate;
    private boolean vertical;

    public Ship(String aName, String aCoordinate, boolean isVertical){
        setNameSize(aName);
        coordinate = aCoordinate;
        vertical = isVertical;
        sunk = false;
    }
    private setNameSize(aName){
        switch(aName.upper()){
            case "CARRIER":
                name = aName;
                size = 5;
                break;
            case "BATTLESHIP":
                name = aName;
                size = 4;
                break;
            case "CRUISER":
                name = aName;
                size = 3;
                break;
            case "SUBMARINE":
                name = aName;
                size = 3;
                break;
            case "DESTROYER":
                name = aName;
                size = 2;
                break;
            default:
                System.out.println("FALSE");
                break;
        }
    }
}