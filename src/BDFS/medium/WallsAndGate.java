package BDFS.medium;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGate {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
            return;
        }

        Queue<Point> queue = new LinkedList<>();

        addAllZeros(rooms, queue);

        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0 ; i < size ; i++ ) {
                Point current = queue.poll();

                for (int[] direct : DIRECTIONS) {
                    int x = current.x + direct[0];
                    int y = current.y + direct[1];

                    if (x >= 0 && y >= 0 && x < rooms.length && y < rooms[0].length && rooms[x][y] == Integer.MAX_VALUE) {
                        rooms[x][y] = count;
                        queue.offer(new Point(x, y));
                    }
                }
            }

            count++;
        }
    }

    private void addAllZeros(int[][] rooms, Queue<Point> queue) {
        for (int i = 0 ; i < rooms.length ; i++ ) {
            for (int j = 0 ; j < rooms[0].length ; j++ ) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Point(i, j));
                }
            }
        }
    }

    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) {
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        WallsAndGate wallsAndGate = new WallsAndGate();
        wallsAndGate.wallsAndGates(rooms);
    }
}
