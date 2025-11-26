package src29.com.shapes;

public class Rectangle implements Shape {
    Rectangle(){}
    Rectangle(double lenth, double wide){
        this.lenth = lenth;
        this.wide = wide;
    }

    private double lenth;
    private double wide;
    
    public double calculateArea(){
        return lenth*wide;
    }
    public double calculatePerimeter(){
        return (lenth+wide)*2;
    }
    public String getShapeName(){
        return "Rectangle";
    }
    public void displayInfo(){
        System.out.println("长："+lenth);
        System.out.println("宽："+wide);
    }
}
