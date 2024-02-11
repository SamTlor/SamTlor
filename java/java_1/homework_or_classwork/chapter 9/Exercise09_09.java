class RegularPolygon{
    private int n = 3;
    private double side = 1;
    private double x = 0;
    private double y = 0;

    public RegularPolygon(){}
    public RegularPolygon(int setN, double setSide){
        n = setN;
        side = setSide;
    }
    public RegularPolygon(int setN, double setSide, double setX, double setY){
        n = setN;
        side = setSide;
        x = setX;
        y = setY;
    }

    double getArea(){
        return  n * Math.pow(side,2) / (4 * Math.tan(Math.PI / n));
    }
    double getPerimeter(){
        return n * side;
    }
}

public class  Exercise09_09 {
    public static void main(String[] args) {
        RegularPolygon p1 = new RegularPolygon();
        RegularPolygon p2 = new RegularPolygon(6, 4);
        RegularPolygon p3 = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.println("Polygon 1 perimeter: " + p1.getPerimeter());
        System.out.println("Polygon 1 area: " + p1.getArea());

        System.out.println("Polygon 2 perimeter: " + p2.getPerimeter());
        System.out.println("Polygon 2 area: " + p2.getArea());

        System.out.println("Polygon 3 perimeter: " + p3.getPerimeter());
        System.out.println("Polygon 3 area: " + p3.getArea());
    }
}