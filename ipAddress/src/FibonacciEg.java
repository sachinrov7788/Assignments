import java.math.BigInteger;
import java.util.Scanner;

public class ipAddress {
    public static void main(String[] args) {
        BigInteger a=BigInteger.ZERO;
        BigInteger b=BigInteger.ONE;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("IPAddress " + n + " terms:");
        printipAddress(n, 0, 1);

        for(int i=0; i<n; i++){
            int a=(int)
        }

    }

    public static void ipAddress(int n, int a, int b) {
        if (n > 0) {
            System.out.print(a + " ");
            printipAddress(n - 1, b, a + b);
        }
    }
}