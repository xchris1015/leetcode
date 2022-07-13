package leetcode.editor.en;

public class LC198HouseRobber{
    public static void main(String[] args) {
        Solution solution = new LC198HouseRobber().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int rob(int[] nums) {
            if (nums.length <= 1) {
                return nums[0];
            }

            if (nums.length <= 2) {
                return Math.max(nums[0], nums[1]);
            }

            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(dp[0], nums[1]);
            for (int i = 2 ; i < dp.length ; i++ ) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }

            return dp[dp.length - 1];
        }

    /*
    use dp
    dp[i] from index 0 to i, maximun profit, -> take or not
    dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
    dp[0-1] = nums[0-1]
    */
        //TODO space improved dp
}
//leetcode submit region end(Prohibit modification and deletion)

}