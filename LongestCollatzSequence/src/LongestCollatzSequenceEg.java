import com.sun.source.tree.BreakTree;

import java.util.Scanner;

class LongestCollatzSequenceEg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number : ");

        int num = sc.nextInt();
        System.out.println(LongestCollatzsequence(num));
    }

    public static String LongestCollatzsequence(int num) {
        if (num <= 0) {
            return "Error";
        }
        String str = " ";
        int counter = 0;

        while (num != 4) {
            counter++;
            str += num + " ";
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = (num * 3) + 1;
            }

            if (counter >= 97 && num != 8) {
                return "Does not Converg";
            }
        }
        str = str + "4 2 1";
        return str;
    }
}

