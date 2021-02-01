package DP;

public class DPtrianglePathSum {

    public int minimunPathSum(int[][] matrix) {

        for (int i = matrix.length - 2 ; i >= 0 ; i++ ) {
            for (int j = 0 ; j < matrix[i].length ; i++ ) {
                matrix[i][j] = Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]) + matrix[i][j];
            }
        }

        return matrix[0][0];
    }
}
