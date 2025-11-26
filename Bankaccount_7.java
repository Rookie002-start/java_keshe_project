public class Bankaccount_7{
    private double cash;

    Bankaccount_7(){
        cash = 0;
    }
    public void deposit(double save_cash){
        cash+=save_cash;
    }
    public void withdraw(double get_cash){
        cash-=get_cash;
    }
    public double checkBalance(){
        return cash;
    }
    public static void main(String args[])
    {
        Bankaccount_7 bc = new Bankaccount_7();
        bc.deposit(20);
        System.out.println("存入金额：" + bc.checkBalance());
        bc.withdraw(10);
        System.out.println("拿出10元后：" + bc.checkBalance());
    }
}