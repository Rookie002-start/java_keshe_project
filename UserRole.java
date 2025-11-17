import java.util.Scanner;

public enum UserRole {
    ADMIN,USER,GUEST;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("给出选择：");
        System.out.println("1：ADMIN " + "2：USER " + "3：GUEST");
        int input = s.nextInt();
        UserRole peo = UserRole.ADMIN;
        switch(input){
            case 1:
            break;
            case 2:
            peo = UserRole.USER;
            break;
            case 3:
            peo = UserRole.GUEST;
            break;
        }
        System.out.println("你选择了" + peo 
        + "，你拥有了" + peo + "的权限");
        s.close();
    }
}
