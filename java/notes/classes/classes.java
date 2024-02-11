class Rectangle {
    //data members
    double width = 1;
    double height = 1;

    //constructors
    public Rectangle(){}
    public Rectangle(double setWidth, double setHeight){
        width = setWidth;
        height = setHeight;
    }

    //getters
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }

    //setters
    public void setWidth(double newWidth){
        width = newWidth;
    }
    public void setHeight(double newHeight){
        width = newHeight;
    }

    //methods
    double getArea(){
        return (width*height);
    }
    double getPerimeter(){
        return 2 * (width + height);
    }
}

public class classes {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(4,40);
        Rectangle r3 = new Rectangle(3.5,35.9);
        
        System.out.println("The area of a rectangle with width " + r1.width + " and height " + r1.height + " is: " + r1.getArea());
        System.out.println("The perimeter of the rectangle is: " + r1.getPerimeter() + "\n\n");
        System.out.println("The area of a rectangle with width " + r2.width + " and height " + r2.height + " is: " + r2.getArea());
        System.out.println("The perimeter of the rectangle is: " + r2.getPerimeter() + "\n\n");
        System.out.println("The area of a rectangle with width " + r3.width + " and height " + r3.height + " is: " + r3.getArea());
        System.out.println("The perimeter of the rectangle is: " + r3.getPerimeter() + "\n\n");
    }
}