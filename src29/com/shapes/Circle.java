package src29.com.shapes;

public class Circle implements Shape {
    Circle(){}
    Circle(double r){
        this.r = r;
    }

    private double r;
    private static final double Pi = 3.14159;
    
    public double calculateArea(){
        return Pi*r*r;
    }
    public double calculatePerimeter(){
        return Pi*r*2;
    }
    public String getShapeName(){
        return "Circle";
    }
    public void displayInfo(){
        System.out.println("半径："+r);
    }
}
