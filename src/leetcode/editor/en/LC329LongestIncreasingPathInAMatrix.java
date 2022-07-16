package leetcode.editor.en;

public class LC329LongestIncreasingPathInAMatrix{
    public static void main(String[] args) {
        Solution solution = new LC329LongestIncreasingPathInAMatrix().new Solution();
        // TO TEST
        int[][] test = {{9,9,4},{6,6,8},{2,1,1}};
        solution.longestIncreasingPath(test);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /*
        search problem, 4 branches, no visited needed because it is strickly incresing
        pruning: int[][] as dfs(i, j) -> start with i, j the longest cs

        dp? cannot 4 direction ...
         */
        private int globalMax = 0;
        public final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] memo = new int[row][col];

        for (int i = 0 ; i < row ; i++ ) {
            for (int j = 0 ; j < col ; j++ ) {
                dfs(matrix, i, j, memo);
            }
        }

        return globalMax;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] > 0) {
            return memo[i][j];
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int localMax = 1;

        for (int[] direction : DIRECTIONS) {
            int ii = i + direction[0];
            int jj = j + direction[1];

            if (ii < 0 || jj < 0 || ii >= row || jj >= col || matrix[ii][jj] <= matrix[i][j]) {
                continue;
            }

            localMax = Math.max(localMax, 1 + dfs(matrix, ii, jj, memo));
        }

        memo[i][j] = localMax;
        globalMax = Math.max(localMax, globalMax);
        return localMax;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}