import java.util.Scanner;

public class Merge_16 {
    public static void main(String[] args) {
       int[] arr1 = new int[4];
        int[] arr2 = new int[4];
        Scanner s = new Scanner(System.in);
        System.out.println("输入4个升序整数：");
        for(int i = 0; i < 4; i++){
            arr1[i] = s.nextInt();
        }
        System.out.println("输入4个升序整数：");
        for(int i = 0; i < 4; i++){
            arr2[i] = s.nextInt();
        }
        int[] arr3 = new int[8];
        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;
        while(idx1 < arr1.length && idx2 < arr2.length){
            if(arr1[idx1] < arr2[idx2]){
                arr3[idx3] = arr1[idx1];
                idx1++;
            }
            else{
                arr3[idx3] = arr2[idx2];
                idx2++;
            }
            idx3++;
        }
        if(idx1 >= 4){
            while(idx2 < 4){
            arr3[idx3] = arr2[idx2];
            idx2++;
            idx3++;
            }
        }
        else{
            while(idx1 < 4){
            arr3[idx3] = arr1[idx1];
            idx1++;
            idx3++;
            }
        }
        System.out.println("合并后数组：");
        for(int num: arr3){
            System.out.print(num + " ");
        }
        s.close();
    }
}