import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {


    static List<List<Integer>> createLayers(List<List<Integer>> matrix) {
        List<List<Integer>> layers = new ArrayList<>();

        int columns = matrix.size();
        int rows = matrix.get(0).size();

        int lowerValue = Integer.min(columns, rows);
        int layersSize = lowerValue % 2 == 1 ? (lowerValue + 1) / 2 : lowerValue / 2;

        for (int i = 1; i <= layersSize; i++) {
            List<Integer> layer = new ArrayList<>();
            for (int column = columns - i; column >= i - 1; column--) {
                layer.add(matrix.get(i - 1).get(column));
            }
            for (int row = i - 1; i >= rows - i; row++) {
                layer.add(matrix.get(row).get(i - 1));
            }
        }

    }

    static List<List<Integer>> fromLayerToList(List<List<Integer>> layers) {

    }

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        List<List<Integer>> layers = createLayers(matrix);
        int realR;
        for (List<Integer> layer: layers) {
            realR = r % layer.size();
        }
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
