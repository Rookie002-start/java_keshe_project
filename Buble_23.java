import java.util.Scanner;

public class Buble_23 {
    private static void do_sort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1 ; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("输入数组长度：");
        int n = s.nextInt();
        int[] arr = new int[n];
        System.out.println("输入" + n + "个整数：");
        for(int i = 0; i < n; i++){
            arr[i] = s.nextInt();
        }
        System.out.println("排序后数组：");
        do_sort(arr);
        for(int num: arr){
            System.out.print(num + " ");
        }
        s.close();
    }
}
