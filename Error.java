import java.util.Scanner;

class NegativeNumberException extends Exception{
    public NegativeNumberException(){
        super("输入值不能为负数！");
    }
    public NegativeNumberException(String message){
        super(message);
    }
}

public class Error {
    public static void getinput(int num) throws NegativeNumberException{
        if(num < 0){
            throw new NegativeNumberException("你输入了负数!");
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("输入一个整数：");
        try{
            int inpute = s.nextInt();
            getinput(inpute);
        }
        catch(NegativeNumberException e){
            System.out.println(e.getMessage());
        }
        finally{
            s.close();
        }
    }
}
