import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        long negativeCount = Arrays.stream(arr)
                .filter(e -> e < 0)
                .count();
        long positiveCount = Arrays.stream(arr)
                .filter(e -> e > 0)
                .count();
        long zeroCount = Arrays.stream(arr)
                .filter(e -> e == 0)
                .count();
        long sum = negativeCount + positiveCount + zeroCount;
        BigDecimal negativeBD = BigDecimal.valueOf(negativeCount);
        BigDecimal positiveBD = BigDecimal.valueOf(positiveCount);
        BigDecimal zeroBD = BigDecimal.valueOf(zeroCount);
        BigDecimal sumBD = BigDecimal.valueOf(sum);
        BigDecimal negativeFraction = negativeBD.divide(sumBD, 6, RoundingMode.CEILING);
        BigDecimal positiveFraction = positiveBD.divide(sumBD, 6, RoundingMode.CEILING);
        BigDecimal zeroFraction = zeroBD.divide(sumBD, 6, RoundingMode.CEILING);
        System.out.println(positiveFraction);
        System.out.println(negativeFraction);
        System.out.println(zeroFraction);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
