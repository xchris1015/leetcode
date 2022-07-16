package leetcode.editor.en;

public class LC132PalindromePartitioningIi{
    public static void main(String[] args) {
        Solution solution = new LC132PalindromePartitioningIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //TODO
        public int minCut(String s) {
            //cc

            int[] dp = new int[s.length() + 1];
            dp[s.length()] = 0;

            for (int i = s.length() - 1 ; i >= 0 ; i-- ) {
                int localMin = s.length() - i;
                for (int j = i ; j < s.length() ; j++ ) {
                    if (isPalidrome(s, i, j)) {
                        localMin = Math.min(localMin, dp[j + 1] + 1);
                    }
                }
                dp[i] = localMin;
            }

            return dp[0] - 1;
        }

        private boolean isPalidrome(String s, int i, int j) {
            while (i <= j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }

            return true;
        }
    /*
    //TODO dp[i] = [i, len) not minCut... is number of substring....
    dp[len] = 0;
    dp[i] = min(dp[j]) + 1, where i <= j < len and [i, j] is palidrome
    */
}
//leetcode submit region end(Prohibit modification and deletion)

}