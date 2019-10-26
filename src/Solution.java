import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the maximumSum function below.
    static long maximumSum3(long[] a, long m) {
        long max = 0;
        long sum;

        for (int size = 1; size <= a.length; size++) {
            for (int i = 0; i <= a.length - size; i++) {
                sum = Arrays.stream(a).skip(i).limit(size).sum();
                if (sum % m > max) {
                    max = sum % m;
                }
            }
        }
        return max;
    }

    // Complete the maximumSum function below.
    static long maximumSum2(long[] a, long m) {
        long max = 0;
        long sum;

        if (Arrays.stream(a).anyMatch(l -> l == m - 1)) {
            return m - 1;
        }

        for (int i = 0; i < a.length; i++) {
            sum = a[i];
            if (sum % m > max) {
                max = sum % m;
                if (max == m - 1) return max;
            }
            for (int next = i + 1; next < a.length; next++) {
                sum += a[next];
                if (sum % m > max) {
                    max = sum % m;
                    if (max == m - 1) return max;
                }
            }
        }
        return max;
    }

    static long maximumSum(long[] a, long m) {
        TreeSet<Long> prefix = new TreeSet<>();
        long maxSum = 0;
        long currentSum = 0;

        for (int i = 0; i < a.length; i++) {
            currentSum = (currentSum + a[i] % m) % m;
            SortedSet<Long> set = prefix.tailSet(currentSum + 1);
            Iterator<Long> iterator = set.iterator();

            if (iterator.hasNext()) {
                maxSum = Math.max(maxSum, (currentSum - iterator.next() + m) % m);
            }

            maxSum = Math.max(maxSum, currentSum);
            prefix.add(currentSum);
        }

        return maxSum;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        long[] arr = {1, 2, 3, 4, 5};

        long result = maximumSum(arr, 8);
        System.out.println(result);
    }
}
