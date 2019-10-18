import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {
        List<Integer> all = Arrays.stream(brr).boxed().collect(Collectors.toList());

        Arrays.stream(arr).boxed().forEach(all::remove);

        return new HashSet<>(all).stream().sorted().mapToInt(e -> e).toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] arr = {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
        int[] brr = {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
        int[] result = missingNumbers(arr, brr);
        Arrays.stream(result).forEach(System.out::println);
    }
}
