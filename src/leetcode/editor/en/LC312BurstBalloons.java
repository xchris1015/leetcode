package leetcode.editor.en;

public class LC312BurstBalloons{
    public static void main(String[] args) {
        Solution solution = new LC312BurstBalloons().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int maxCoins(int[] nums) {
            //cc
            int len = nums.length;
            int[][] dp = new int[len][len];

            for (int i = len - 1 ; i >= 0 ; i-- ) {
                for (int j = i ; j < len ; j++ ) {
                    for (int k = i ; k <= j ; k++ ) {
                        int leftRange = k - 1 < 0 ? 0 : dp[i][k - 1];
                        int rightRange = k + 1 > len - 1 ? 0 : dp[k + 1][j];
                        int leftBoundary = i == 0 ? 1 : nums[i - 1];
                        int rightBoundary = j == len - 1 ? 1 : nums[j + 1];
                        dp[i][j] = Math.max(dp[i][j], leftRange + rightRange + nums[k] * leftBoundary * rightBoundary);
                    }
                }
            }

            return dp[0][len - 1];
        }

    /*
    search problem, which go first, which go last
    dfs(i, j) -> max score can get in [i, j]
    for k in i, j
        dfs(i, j) = dfs(i, k - 1) + dfs(k + 1, j) + nums[k] * nums[i - 1] * nums[j + 1];
    to have k take on last, which outside boundary would not change,

    dp[i][j] = dp[i][k - 1] + dp[k + 1][j] + nums[k] * nums[i - 1] * nums[j + 1] where i < k < j
    dp[i][i] = nums[i];
    */
}
//leetcode submit region end(Prohibit modification and deletion)

}