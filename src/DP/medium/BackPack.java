package DP.medium;

public class BackPack {

    // 很直接的背包问题 result[i][j] 在前i 个物品，在j 容量的情况下的最大容量
    // 空间复杂度可以优化成O(n)

    public int backPack(int m, int[] A) {

        int[][] result = new int[A.length + 1][m + 1];

        for (int i = 0 ; i <= A.length ; i++ ) {
            for (int j = 0 ; j <= m ; j++ ) {
                if (i == 0 || j == 0) {
                    result[i][j] = 0;
                } else if (j >= A[i - 1]) {
                    result[i][j] = Math.max(result[i - 1][j], result[i - 1][j - A[i - 1]] + A[i - 1]);
                } else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }

        return result[A.length][m];
    }
}
