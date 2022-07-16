package leetcode.editor.en;

public class LC64MinimumPathSum{
    public static void main(String[] args) {
        Solution solution = new LC64MinimumPathSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //2D DP
        public int minPathSum(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            int[][] dp = new int[row][col];
            dp[0][0] = grid[0][0];
            for (int i = 1 ; i < grid.length ; i++ ) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }

            for (int j = 1 ; j < grid[0].length ; j++ ) {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            }

            for (int i = 1 ; i < grid.length ; i++ ) {
                for (int j = 1 ; j < grid[0].length ; j++ ) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }

            return dp[row - 1][col - 1];
        }

    /*
    dp[i][j] = this point the maximun from left or upper
    dp[0][0] = 1;
    dp[i][0] = dp[i - 1][0] + grid[i][0];
    dp[0][j] = dp[0][j - 1] + grid[0][j];
    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i, j];

    lower space complexity
    */
}
//leetcode submit region end(Prohibit modification and deletion)

}