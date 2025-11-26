import java.util.Scanner;

public enum UserRole_18 {
    ADMIN,USER,GUEST;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("给出选择：");
        System.out.println("1：ADMIN " + "2：USER " + "3：GUEST");
        int input = s.nextInt();
        UserRole_18 peo = UserRole_18.ADMIN;
        switch(input){
            case 1:
            break;
            case 2:
            peo = UserRole_18.USER;
            break;
            case 3:
            peo = UserRole_18.GUEST;
            break;
        }
        System.out.println("你选择了" + peo 
        + "，你拥有了" + peo + "的权限");
        s.close();
    }
}
