import bridges.connect.Bridges;
import bridges.base.SLelement;

public class sllist {
    public static void main(String[] args) {

        Bridges bridges = new Bridges(0, "sam_tlor", "1134158751539");

        SLelement<String> sle0 = new SLelement("Hello", "");
        SLelement<String> sle1 = new SLelement("World", "");

        sle0.setNext(sle1);

        sle0.getVisualizer().setColor("black");
        sle0.getVisualizer().setOpacity(0.5f);
        sle1.getVisualizer().setColor("green");

        bridges.setDataStructure(sle0);

        bridges.visualize();
    }
}