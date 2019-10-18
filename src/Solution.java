import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumLoss function below.
    static int minimumLoss2(long[] price) {
        Integer min = null;
        Long tempMin;
        for (int i = 0; i < price.length - 1; i++) {
            long currentPrice = price[i];
            tempMin = Arrays.stream(price)
                    .skip(i + 1)
                    .map(next -> currentPrice - next)
                    .filter(e -> e >= 0)
                    .min()
                    .orElse(-1);
            if (min == null)
                min = tempMin.intValue();
            if (tempMin != -1 && tempMin < min)
                min = tempMin.intValue();
        }
        return min;
    }

    static int minimumLoss3(long[] price) {
        long min = Long.MAX_VALUE;
        for (int current = 0; current < price.length - 1; current++) {
            long difference;
            for (int next = current + 1; next < price.length; next++) {
                difference = price[current] - price[next];
                if (difference > 0 && difference < min)
                    min = difference;
            }
        }
        return (int) min;
    }

    static int minimumLoss(long[] price) {
        HashMap<Long, Integer> position = new HashMap<>();
        long min = Long.MAX_VALUE;
        long diff, cur, next;
        for (int i = 0; i < price.length; i++) {
            position.put(price[i], i);
        }

        Arrays.sort(price);

        for (int i = price.length - 1; i > 0; i--) {
            cur = price[i];
            next = price[i - 1];
            if (position.get(cur) < position.get(next)) {
                diff = cur - next;
                if (diff < min) min = diff;
            }
        }

        return (int) min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        long[] price = {20, 7, 8, 2, 5};
        int result = minimumLoss(price);
        System.out.println(result);
    }
}
