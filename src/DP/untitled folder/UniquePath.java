package DP.easy;

public class UniquePath {

    public int uniquePaths(int m, int n) {
        // 几个格子到终点， 终点的值就是这几点的Sum
        // f[0][0] = 1
        // f[i][j] = f[i - 1][j] + f[i][j - 1]
        // if i = 0  or j = 0  f[i][j] = 1
        //顺序 从左到右， 然后再从上到下， 因为需要上面和左边的点， 所以要先算上面，再算左边
        // 一定要看好边界的数值

        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] result = new int[m][n];
        result[0][0] = 0;

        for (int i = 0 ; i < m ; i++ ) {
            for (int j = 0 ; j < n ; j++ ) {
                if (i == 0 || j == 0) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }

        return result[m - 1][n - 1];
    }
}
