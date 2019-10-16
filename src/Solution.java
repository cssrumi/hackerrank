import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.IntStream;

public class Solution {

    // Complete the staircase function below.
    static void staircase(int n) {
        StringBuffer sb = new StringBuffer();
        char s = ' ';
        char h = '#';
        for(int i = 0; i<n; i++) {
            for (int j = n-1; j>=0; j--) {
                if (j <= i) {
                    sb.append(h);
                } else {
                    sb.append(s);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
