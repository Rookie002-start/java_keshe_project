public class Threads_12 {
    public static void main(String[] args) {
        Thread nums = new Thread(()->{
            for(int i = 1; i <= 10; i++){
                System.out.print(i + " ");
            }
        });
        Thread alpha = new Thread(()->{
            for(char c = 'A'; c <= 'J'; c++){
                System.out.print(c + " ");
            }
        });
        nums.start();
        alpha.start();
    }
}
