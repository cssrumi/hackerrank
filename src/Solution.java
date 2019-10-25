import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {


    static class Point {
        int row, col, value;

        Point(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public String toString() {
//            return Integer.toString(value);
            return "P{" +
                    "" + row +
                    "," + col +
                    "," + value +
                    '}';
        }
    }

    private static List<List<Point>> createLayers(List<List<Integer>> matrix) {
        List<List<Point>> layers = new ArrayList<>();

        int columns = matrix.get(0).size();
        int rows = matrix.size();

        int lowerValue = Integer.min(columns, rows);
        int layersSize = lowerValue % 2 == 1 ? (lowerValue + 1) / 2 : lowerValue / 2;

        for (int i = 1; i <= layersSize; i++) {
            List<Point> layer = new ArrayList<>();
            for (int column = columns - i; column >= i - 1; column--) {
                layer.add(new Point(i - 1, column, matrix.get(i - 1).get(column)));
            }
            for (int row = i; row < rows - i; row++) {
                layer.add(new Point(row, i - 1, matrix.get(row).get(i - 1)));
            }
            for (int column = i - 1; column < columns - i; column++) {
                layer.add(new Point(rows - i, column, matrix.get(rows - i).get(column)));
            }
            for (int row = rows - i; row > i - 1; row--) {
                layer.add(new Point(row, columns - i, matrix.get(row).get(columns - i)));
            }
            if (i == layersSize) {
                if (columns % 2 == 1 && rows == columns) {
                    layer = new ArrayList<>(Arrays.asList(layer.get(0)));
                } else if (columns % 2 == 1 && rows > columns) {
                    layer = new ArrayList<>();
                    for (int row = i - 1; row <= rows - i; row++) {
                        layer.add(new Point(row, i - 1, matrix.get(row).get(i - 1)));
                    }
                } else if (rows % 2 == 1 && columns > rows) {
                    layer = new ArrayList<>();
                    for (int column = columns - i; column >= i - 1; column--) {
                        layer.add(new Point(i - 1, column, matrix.get(i - 1).get(column)));
                    }
                }
            }
            layers.add(layer);
        }
        return layers;
    }

    static int[][] fromLayerToMatrix(List<List<Point>> layers, int rows, int columns) {
        int[][] matrix = new int[rows][columns];

        for (List<Point> layer: layers) {
            for (Point point: layer) {
                matrix[point.row][point.col] = point.value;
            }
        }

        return matrix;
    }

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        List<List<Point>> layers = createLayers(matrix);
        List<List<Point>> rotatedLayers = new ArrayList<>();
        int[][] rotatedMatrix;

        int columns = matrix.get(0).size();
        int rows = matrix.size();
        int realR;

        for (List<Point> layer : layers) {
            List<Point> finalLayer = new ArrayList<>();

            realR = r % layer.size();
            List<Point> temp = layer.stream().skip(layer.size() - realR).collect(Collectors.toList());
            temp.addAll(layer.stream().limit(layer.size() - realR).collect(Collectors.toList()));

            for (int i = 0; i < layer.size(); i++) {
                finalLayer.add(new Point(
                        layer.get(i).row,
                        layer.get(i).col,
                        temp.get(i).value));
            }

            rotatedLayers.add(finalLayer);
        }

        rotatedMatrix = fromLayerToMatrix(rotatedLayers, rows, columns);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                System.out.print(rotatedMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        List<List<Integer>> matrix = IntStream.range(0, 3)
                .mapToObj(i -> Arrays.asList(i * 3 + 1, i * 3 + 2, i * 3 + 3, i * 3 + 1, i * 3 + 2))
                .collect(Collectors.toList());

        matrixRotation(matrix, 1);
    }
}
