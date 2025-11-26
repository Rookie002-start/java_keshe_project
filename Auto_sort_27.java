import java.util.Scanner;
import java.util.TreeSet;

public class Auto_sort_27 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        TreeSet<Integer> nums = new TreeSet<>();
        System.out.println("要输入的整数个数：");
        int n = s.nextInt();
        System.out.println("输入" + n + "个整数：");
        for(int i = 0;i < n;i++){
            nums.add(s.nextInt());
        }
        System.out.println("存入TreeSet后的整数：");
        for(int num : nums){
            System.out.print(num + " ");
        }
        s.close();
    }
}
