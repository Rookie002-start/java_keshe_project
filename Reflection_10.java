import java.lang.reflect.Method;

public class Reflection_10 {
    public static void main(String[] args) {
        try{
            Class<?> bankAccountClass = Class.forName("Bankaccount");
            Object bankAccount = bankAccountClass.getDeclaredConstructor().newInstance();
            Method depositMethod = bankAccountClass.getMethod("deposit", double.class);
            depositMethod.invoke(bankAccount, 40.0);
            Method checkBalanceMethod = bankAccountClass.getMethod("checkBalance");
            double balance = (Double) checkBalanceMethod.invoke(bankAccount);
            System.out.println("当前余额: " + balance);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
