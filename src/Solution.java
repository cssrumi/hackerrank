import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the balancedSums function below.
    static String balancedSums(List<Integer> arr) {
        if (arr.size() == 1) return "YES";
        int sum = arr.stream().reduce(0, Integer::sum);
        int count = 0;
        int current;
        for (int i = 0; i < arr.size(); i++) {
            current = arr.get(i);
            if (count == sum - count - current) {
                return "YES";
            }
            count += current;
        }
        return "NO";
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(3);

        String result = balancedSums(arr);
        System.out.println(result);
    }
}
