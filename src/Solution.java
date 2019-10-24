import java.io.*;
import java.util.*;
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
            for (int column = i - 1; column >= columns - i; column++) {
                layer.add(matrix.get(rows - i).get(column));
            }
            for (int row = rows - i; row >= i - 1; row--) {
                layer.add(matrix.get(row).get(columns - i));
            }
            if (columns % 2 == 1 && rows == columns && i == layersSize) {
                layer = new ArrayList<>(Arrays.asList(layer.get(0)));
            } else if ((columns % 2 == 1 || rows % 2 == 1) && i == layersSize) {
                layer = layer.stream().limit(layer.size() / 2).collect(Collectors.toList());
            }
            layers.add(layer);
        }
        return layers;
    }

    static List<List<Integer>> fromLayerToMatrix(List<List<Integer>> layers, int rows, int columns) {
        List<List<Integer>> matrix = new ArrayList<>();
        int halfRows = rows % 2 == 1 ? (rows + 1) / 2 : rows / 2;
        int halfColumns = columns % 2 == 1 ? (columns + 1) / 2 : columns / 2;
        for (int row = 0; row < halfRows; row++) {
            for (int l = 0; l <= row && l < layers.size(); l++) {

            }
        }

        return matrix;
    }

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        List<List<Integer>> layers = createLayers(matrix);
        List<List<Integer>> rotatedLayers = new ArrayList<>();
        List<List<Integer>> rotatedMatrix;

        int columns = matrix.size();
        int rows = matrix.get(0).size();
        int realR;

        for (List<Integer> layer : layers) {
            realR = r % layer.size();
            List<Integer> temp = layer.stream().skip(layer.size() - realR).collect(Collectors.toList());
            temp.addAll(layer.stream().limit(layer.size() - realR).collect(Collectors.toList()));
            rotatedLayers.add(temp);
        }

        rotatedMatrix = fromLayerToMatrix(rotatedLayers, rows, columns);

        for (List<Integer> rMatrix : rotatedMatrix) {
            for (Integer number : rMatrix) {
                System.out.print(number + " ");
            }
            System.out.println();
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
