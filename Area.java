import java.util.Scanner;

public class Area {
    public static final double P = 3.14;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = scanner.nextDouble();
        System.out.println("S = " +P+'*'+r+'*'+r+'='+P*r*r);
        scanner.close();
    }
}