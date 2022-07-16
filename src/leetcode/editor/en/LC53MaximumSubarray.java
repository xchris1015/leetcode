package leetcode.editor.en;

public class LC53MaximumSubarray{
    public static void main(String[] args) {
        Solution solution = new LC53MaximumSubarray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = nums[0];
            for (int i = 1 ; i < nums.length ; i++ ) {
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
                max = Math.max(max, dp[i]);
            }

            return max;
        }

    /*
    two pointer, i, j two for loop n^2,

    dp[i] = [0, i] from 0 to i, i as end, the maximun subarray sum
    dp[0] = -2;
    dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
    */
}
//leetcode submit region end(Prohibit modification and deletion)

}