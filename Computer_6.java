import java.util.Scanner;

public class Computer_6 {
    public static int docalcu(int a, int b, char op)
    {
        int ans = 0;
        switch(op)
        {
            case '+':
            ans = a+b;
            break;
            case '-':
            ans = a-b;
            break;
            case '*':
            ans = a*b;
            break;
            case '/':
            try
            {
                ans = a/b;
            }
            catch(ArithmeticException e)
            {
                System.out.println("除数不能为0!");
                return 0;
            }
            break;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入运算数：");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("输入运算符：");
        char op = scanner.next().charAt(0);
        System.out.println("result = "+docalcu(a, b, op));
        scanner.close();
    }
}
