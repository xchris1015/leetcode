package BDFS.medium;

import java.util.*;

public class LC130 {
    public void solve(char[][] board) {

        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        // change all of the edge O to Y, and bfs them.
        Queue<Point> queue = new LinkedList<>();
        HashSet<Point> visited = new HashSet<>();

        for (int i = 0 ; i < board[0].length ; i++ ) {
            if (board[0][i] == 'O') {
                Point point = new Point(0, i);
                queue.offer(point);
                visited.add(point);
            }

            if (board[board.length - 1][i] == 'O') {
                Point point = new Point(board.length - 1, i);
                queue.offer(point);
                visited.add(point);
            }
        }

        for (int i = 1 ; i < board.length - 1 ; i++ ) {
            if (board[i][0] == 'O') {
                Point point = new Point(i, 0);
                queue.offer(point);
                visited.add(point);
            }

            if (board[i][board[0].length - 1] == 'O') {
                Point point = new Point(i, board[0].length - 1);
                queue.offer(point);
                visited.add(point);
            }
        }

        dfs(board, queue, visited);

        for (int x = 0 ; x < board.length ; x++ ) {
            for (int y = 0 ; y < board[0].length ; y++ ) {
                if (board[x][y] == 'O' && !visited.contains(new Point(x, y))) {
                    board[x][y] = 'X';
                }
            }
        }

        boolean checker = false;
    }

    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    private Set<Point> dfs(char[][] board, Queue<Point> queue, Set<Point> visited) {

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Point current = queue.poll();

                for (int[] dir : DIRECTIONS) {
                    int xx = current.x + dir[0];
                    int yy = current.y + dir[1];
                    Point next = new Point(xx, yy);

                    if (isValid(board, next, visited)) {
                        queue.offer(next);
                        visited.add(next);

                    }
                }
            }
        }

        return visited;
    }

    private boolean isValid(char[][] board, Point next, Set<Point> visited) {
        int x = next.x;
        int y = next.y;

        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited.contains(next) || board[next.x][next.y] != 'O') {
            return false;
        }

        return true;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        LC130 lc = new LC130();
        lc.solve(board);


    }
}
