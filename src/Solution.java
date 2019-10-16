import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        BigInteger sum = Arrays.stream(arr)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.valueOf(0), BigInteger::add);
        BigInteger min = sum.subtract(
                BigInteger.valueOf(Arrays.stream(arr)
                        .max()
                        .orElse(0)));
        BigInteger max = sum.subtract(
                BigInteger.valueOf(Arrays.stream(arr)
                        .min()
                        .orElse(0)));
        System.out.println(min.toString() + " " + max.toString());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
