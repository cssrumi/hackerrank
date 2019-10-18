import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the pairs function below.
    static int pairs2(int k, int[] arr) {
        int results = 0;
        for (int current : arr) {
            for (int next : arr) {
                if (current - next == k) {
                    results++;
                }
            }
        }
        return results;
    }
    // Complete the pairs function below.
    static int pairs3(int k, int[] arr) {
        List<Integer> sorted;
        int results = 0;
        if (k < 0)
            sorted = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
        else
            sorted = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        for (int current = 0; current < sorted.size() - 1; current++) {
            if (sorted.get(current) - sorted.get(current + 1) > k) continue;
            for (int next = current + 1; next < sorted.size(); next++) {
                if (sorted.get(current) - sorted.get(next) == k) {
                    results++;
                    break;
                }
            }
        }
        return results;
    }

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        List<Integer> sorted;
        int results = 0;
        int next;
        if (k < 0)
            sorted = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
        else
            sorted = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        for (int current = 0; current < sorted.size() - 1; current++) {

            next = current + 1;
            while (sorted.get(current) - sorted.get(next) <= k) {
                if (sorted.get(current) - sorted.get(next) == k) {
                    results++;
                    break;
                }
                next++;
                if (next >= sorted.size()) break;
            }
        }
        return results;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] arr = {1, 5, 3, 4, 2};

        int result = pairs(2, arr);
        System.out.println(result);
    }
}
