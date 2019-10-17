import java.io.IOException;
import java.util.*;

public class Solution {

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        static Point from(int x, int y) {
            return new Point(x, y);
        }

        boolean checkBounds(int from, int to) {
            if (x < from || x > to) return false;
            if (y < from || y > to) return false;
            return true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    private static class Move {
        int dx, dy;

        Move(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Move move = (Move) o;

            if (dx != move.dx) return false;
            return dy == move.dy;
        }

        @Override
        public int hashCode() {
            int result = dx;
            result = 31 * result + dy;
            return result;
        }
    }

    private static class Pattern {
        int dx, dy, shortestDist;
        Set<Move> moves;

        Pattern(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
            initMoves();
        }

        private void initMoves() {
            moves = new HashSet<>();
            moves.add(new Move(dx, dy));
            moves.add(new Move(dx, -dy));
            moves.add(new Move(-dx, dy));
            moves.add(new Move(-dx, -dy));
            moves.add(new Move(dy, dx));
            moves.add(new Move(dy, -dx));
            moves.add(new Move(-dy, dx));
            moves.add(new Move(-dy, -dx));
        }

        private static List<Pattern> getAllPatterns(int from, int to) {
            List<Pattern> patterns = new ArrayList<>();
            for (int i = from; i <= to; i++) {
                for (int j = from; j <= to; j++) {
                    patterns.add(new Pattern(i, j));
                }
            }
            return patterns;
        }

        private void calculateShortestDist(Point start, Point stop, int size) {
            HashMap<Point, Integer> dist = new HashMap<>();
            Deque<Point> deque = new LinkedList<>();

            Point next;

            deque.add(start);
            dist.put(start, 0);

            while (!deque.isEmpty()) {
                Point current = deque.pop();
                if (current.equals(stop)) {
                    shortestDist = dist.get(current);
                    break;
                }

                for (Move move : moves) {
                    next = Point.from(current.x + move.dx, current.y + move.dy);
                    if (next.checkBounds(0, size - 1) && !dist.containsKey(next)) {
                        dist.put(next, dist.get(current) + 1);
                        deque.add(next);
                    }
                }
                if (shortestDist == 0) shortestDist = -1;
            }
        }
    }


    // Complete the knightlOnAChessboard function below.
    static int[][] knightlOnAChessboard(int n) {
        int[][] result = new int[n - 1][n - 1];
        Point start = Point.from(0, 0);
        Point stop = Point.from(n - 1, n - 1);

        List<Pattern> patterns = Pattern.getAllPatterns(1, n - 1);

        for (Pattern pattern : patterns) {
            pattern.calculateShortestDist(start, stop, n);
            result[pattern.dx - 1][pattern.dy - 1] = pattern.shortestDist;
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = 5;
        int[][] result = knightlOnAChessboard(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[][] result = knightlOnAChessboard(n);
//
//        for (int i = 0; i < result.length; i++) {
//            for (int j = 0; j < result[i].length; j++) {
//                bufferedWriter.write(String.valueOf(result[i][j]));
//
//                if (j != result[i].length - 1) {
//                    bufferedWriter.write(" ");
//                }
//            }
//
//            if (i != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
