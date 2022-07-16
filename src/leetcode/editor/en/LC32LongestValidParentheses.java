package leetcode.editor.en;

public class LC32LongestValidParentheses{
    public static void main(String[] args) {
        Solution solution = new LC32LongestValidParentheses().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int longestValidParentheses(String s) {

            int[] dp = new int[s.length()];
            int max = 0;
            for (int i = 1 ; i < s.length() ; i++ ) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    max = Math.max(dp[i], max);
                }
            }

            return max;
        }

    /*
    init idea:
    dp[i] = [0, i] as i be the end, LVP, where i = ')'
    need to check null, length = length + 1
    dp[i] = max(dp[j]) + 2, as 0 <= j < i;
    dp[0] = 0

    correct idea:
    dp[i] = [0, i] as i be the end, LVP, where i = ')'
    dp[i] = dp[i - 2] + 2  => s[i] = ), s[i - 1] = ( => ()
    这个case 实在要画图...
    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2 where s[i] and s[i - 1] = ) and s[i - dp[i - 1] - 1] = (
    */
}
//leetcode submit region end(Prohibit modification and deletion)

}