import java.util.Arrays;
import java.util.ArrayList;

public class Grid {
    public static void main(String[] args) {
        State[][] playField;
        ArrayList<Ship> ships;

        public Grid(){
            ships = new ArrayList<>();
            playField = new State[10][10];
            for (State[] row : playField){
                Arrays.fill(row, State.OCEAN);
            }
        }

        public boolean addShip(Ship aship, String aCoordinate){
            int row = getRow
        }
        System.out.println("");
    }
}