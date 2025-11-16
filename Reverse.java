public class Reverse {
    static void reverse(int[] arr){
        int lft = 0;
        int rgt = arr.length - 1;
        while(lft < rgt){
            int tmp = arr[lft];
            arr[lft] = arr[rgt];
            arr[rgt] = tmp;
            lft++;
            rgt--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("原数组：");
        for(int num: arr){
            System.out.print(num + " ");
        }
        System.out.println("");
        System.out.println("逆序后数组：");
        reverse(arr);
        for(int num: arr){
            System.out.print(num + " ");
        }
    }
}
