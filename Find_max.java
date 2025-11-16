import java.util.Scanner;

public class Find_max {
    public static <T extends Comparable<T>> T getmax(T[] arr){
        if (arr == null || arr.length == 0) {
        return null;
        }
        T max = arr[0];
        for(T e: arr){
            if(e.compareTo(max) > 0){
                max = e;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer[] int_arr = new Integer[5];
        Double[] dou_arr = new Double[5];
        System.out.println("输入5个整数");
        for(int i = 0; i < 5; i++){
            int_arr[i] = s.nextInt();
        }
        System.out.println("其中的最大值为："+getmax(int_arr));
        System.out.println("输入5个小数");
        for(int i = 0; i < 5; i++){
            dou_arr[i] = s.nextDouble();
        }
        System.out.println("其中的最大值为："+getmax(dou_arr));
        s.close();
    }
}
