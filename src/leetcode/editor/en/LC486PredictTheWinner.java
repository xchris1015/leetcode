package leetcode.editor.en;

public class LC486PredictTheWinner{
    public static void main(String[] args) {
        Solution solution = new LC486PredictTheWinner().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean PredictTheWinner(int[] nums) {
            int[][] dp = new int[nums.length][nums.length];
            int len = nums.length;
            int total = 0;
            for (int i = len - 1 ; i >= 0 ; i-- ) {
                total += nums[i];
                for (int j = i ; j < len ; j++ ) {
                    if (i == j) {
                        dp[i][j] = nums[i];
                        continue;
                    }

                    int a = i + 2 > j     ? 0 : dp[i + 2][j];
                    int b = i + 1 > j - 1 ? 0 : dp[i + 1][j - 1];
                    int c = i > j - 2     ? 0 : dp[i][j - 2];

                    dp[i][j] = nums[i] + Math.min(a, b);
                    dp[i][j] = Math.max(dp[i][j], nums[j] + Math.min(b, c));
                }
            }

            return dp[0][nums.length - 1] >= total - dp[0][nums.length - 1];
        }

        //dfs, branch, choose left or choose right, add to current, change current and next to next function
        // tc, 2^n

    /*
    int dp[i][j] : from this i, j, first player maxScore
    dp[i][j] = max(nums[i] + (totalScore[i + 1][j] - dp[i + 1][j]), nums[j] + (totalScore[i][j - 1] - dp[i][j - 1]);
    dp[i][i] = nums[i]

    think about without sum, A player take first,
    take nums[i], b, take i + 1, a take (i + 2, j)
                  b, take j    , a take (i + 1, j - 1)
         nums[j], b, take i    , a take (i + 1, j - 1)
                , b, take j - 1, a take (i, j - 2)


    */
}
//leetcode submit region end(Prohibit modification and deletion)

}