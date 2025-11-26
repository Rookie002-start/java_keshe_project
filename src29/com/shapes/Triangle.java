package src29.com.shapes;

public class Triangle {
    Triangle(){}
    Triangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private double a;
    private double b;
    private double c;

    public double calculateArea(){
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    public double calculatePerimeter(){
        return a+b+c;
    }
    public String getShapeName(){
        return "Triangle";
    }
    void displayInfo(){
        System.out.println("a："+a);
        System.out.println("b："+b);
        System.out.println("c："+c);
    }
}
