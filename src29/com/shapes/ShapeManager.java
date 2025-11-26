package src29.com.shapes;

public class ShapeManager {
    public static void main(String[] args) {
        Circle circle = new Circle(2.5);
        System.out.println("图形名称："+circle.getShapeName());
        circle.displayInfo();
        System.out.println("面积："+circle.calculateArea());
        System.out.println("周长："+circle.calculatePerimeter());
        Rectangle rectangle = new Rectangle(2, 5);
        System.out.println("图形名称："+rectangle.getShapeName());
        rectangle.displayInfo();
        System.out.println("面积："+rectangle.calculateArea());
        System.out.println("周长："+rectangle.calculatePerimeter());
        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println("图形名称："+triangle.getShapeName());
        triangle.displayInfo();
        System.out.println("面积："+triangle.calculateArea());
        System.out.println("周长："+triangle.calculatePerimeter());
    }
}
