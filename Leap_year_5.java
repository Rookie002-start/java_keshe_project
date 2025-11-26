import java.util.Scanner;

public class Leap_year_5 {
    public static boolean check(int y)
    {
        return (y%400==0)||(y%4==0&&y%100!=0);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入年：");
        int y = scanner.nextInt();
        if(check(y))
        {
            System.out.println(y+"年是闰年");
        }
        else
        {
            System.out.println(y+"年不是闰年");
        }
        scanner.close();
    }
}