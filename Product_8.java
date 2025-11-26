import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product_8 {
    private int id;
    private String name;
    private double price;
    Product_8(){}
    Product_8(int m_id,String m_name,double m_price){
        id=m_id;
        name=m_name;
        price=m_price;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public static void main(String args[]){
        List<Product_8> arrayList = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        System.out.println("输入商品信息(id，price，name)：");
        int id = s.nextInt();
        double price = s.nextDouble();
        s.nextLine();
        String name = s.nextLine();
        arrayList.add(new Product_8(id,name,price));//添加商品
        System.out.println("输入要查询的商品id：");
        int tar=s.nextInt();
        for(Product_8 p: arrayList){
            if(p.getId()==tar){
                System.out.println("找到了：\n"+"id:"+p.getId()+"\nname:"+p.getName()+"\nprice:"+p.getPrice());
            }
        }
        System.out.println("没找到");
        s.close();
    }
}
