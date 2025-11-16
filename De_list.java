import java.util.ArrayList;
import java.util.Scanner;

public class De_list{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        System.out.println("输入数字个数：");
        int n = s.nextInt();
        System.out.println("输入" + n + "个整数：");
        for(int i = 0; i < n; i++){
            int num = s.nextInt();
            if(!nums.contains(num)){
                nums.add(num);
            }
        }
        System.out.println("去重后的数组：");
        for(int num: nums){
            System.out.print(num + " ");
        }
        s.close();
    }
}