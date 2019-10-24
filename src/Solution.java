import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    static int simpleArraySum(int[] ar) {
        return Arrays.stream(ar).reduce(0, Integer::sum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        int[] arr = list.stream().mapToInt(i -> i).toArray();

        int result = simpleArraySum(arr);
        System.out.println(result);
    }
}
