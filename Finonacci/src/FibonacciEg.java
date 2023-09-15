import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciEg {
    public static void main(String[] args) {
        BigInteger a=BigInteger.ZERO;
        BigInteger b=BigInteger.ONE;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Fibonacci Series up to " + n + " terms:");
        printFibonacciSeries(n, 0, 1);
    }

    public static void printFibonacciSeries(int n, int a, int b) {
        if (n > 0) {
            System.out.print(a + " ");
            printFibonacciSeries(n - 1, b, a + b);
        }
    }
}