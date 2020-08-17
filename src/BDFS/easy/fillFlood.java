package BDFS.easy;

import java.util.LinkedList;
import java.util.Queue;

public class fillFlood {

    // BFS

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // BFS

        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0) {
            return image;
        }

        if(image[sr][sc] == newColor) return image;

        int[] direction = new int[]{-1, 0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(sr, sc));

        int value = image[sr][sc];

        int n = image.length;
        int m = image[0].length;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            image[current.x][current.y] = newColor;

            for (int i = 0 ; i < 4 ; i++ ) {
                int nextX = current.x + direction[i];
                int nextY = current.y + direction[i + 1];

                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m && image[nextX][nextY] == value) {
                    queue.offer(new Point(nextX, nextY));
                }
            }
        }

        return image;

    }

    class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }


//    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//        // DFS
//
//        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0) {
//            return image;
//        }
//
//        if(image[sr][sc] == newColor) return image;
//
//        helper(image, sr, sc, newColor, image[sr][sc]);
//
//        return image;
//    }
//
//    private void helper(int[][] image, int r, int c, int newColor, int color){
//        int[][] dirs = {{-1, 0}, {1,0}, {0,-1}, {0,1}};
//        if(image[r][c] == color){
//            image[r][c] = newColor;
//            for(int[] dir : dirs){
//                int nr = dir[0] + r;
//                int nc = dir[1] + c;
//                if(nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length){
//                    helper(image, nr, nc, newColor, color);
//                }
//            }
//        }
//    }
//
//
//}
}
