package BDFS.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LC286 {

    // 是不是分叉问题(branch) 是
    //Tree or graph? What is Vertex and Edge, Directed? Weight?
    // graph, i,j vertex, 4 edge for each vertex, undirected, 1 weight
    //问题本身是图上什么问题？example， 图的表示，查环，拓扑，搜索，Union Find
    // search
    //如果是搜索， 出发点， 做几次搜索
    // start from each gate, 1 search
    // BFS or DFS
    // bfs, shortest

    public void wallsAndGates(int[][] rooms) {

        //cc

        Queue<Integer> queue = new LinkedList<>();
        // visited use check the rooms value
        addAllZeros(rooms, queue);

        int nr = rooms.length;
        int nc = rooms[0].length;

        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int current = queue.poll();

                int r = current / nc;
                int c = current % nc;

                for (int[] direction : DIRECTIONS) {
                    int rr = r + direction[0];
                    int cc = c + direction[1];

                    if (!(rr < 0 || rr >= nr || cc < 0 || cc >= nc || rooms[rr][cc] < 2147483647)) {
                        rooms[rr][cc] = length + 1;
                        queue.offer(rr * nc + cc);
                    }
                }
            }

            length++;
        }
    }

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void addAllZeros(int[][] rooms, Queue<Integer> queue) {
        int nr = rooms.length;
        int nc = rooms[0].length;

        for (int i = 0 ; i < nr ; i++ ) {
            for (int j = 0 ; j < nc ; j++ ) {
                if (rooms[i][j] == 0) {
                    queue.offer(i * nc + j);
                }
            }
        }
    }
}
