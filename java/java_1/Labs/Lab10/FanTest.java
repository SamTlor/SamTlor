package Labs.Lab10;

public class FanTest {
    public static void main(String[] args) {
        Fan f1 = new Fan(Fan.FAST, true, 10, "yellow");
        Fan f2 = new Fan(Fan.MEDIUM, false, 20, "blue");

        System.out.println(f1.toString());
        System.out.println(f2.toString());
    }
}
