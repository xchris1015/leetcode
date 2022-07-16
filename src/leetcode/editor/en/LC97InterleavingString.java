package leetcode.editor.en;

public class LC97InterleavingString{
    public static void main(String[] args) {
        Solution solution = new LC97InterleavingString().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            //cc
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }

            boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
            dp[0][0] = true;

            for (int i = 1 ; i <= s1.length() ; i++ ) {
                dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0];
            }

            for (int j = 1 ; j <= s2.length() ; j++ ) {
                dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1];
            }

            for (int i = 1 ; i <= s1.length() ; i++ ) {
                for (int j = 1 ; j <= s2.length() ; j++ ) {
                    int idx1 = i - 1, idx2 = j - 1, k = idx1 + idx2 + 1;

                    if (s1.charAt(idx1) == s3.charAt(k)) {
                        dp[i][j] = dp[i - 1][j];
                    }

                    if (s2.charAt(idx2) == s3.charAt(k)) {
                        dp[i][j] = dp[i][j] || dp[i][j - 1];
                    }
                }
            }

            return dp[s1.length()][s2.length()];

        }

    /*
    search problem: 1. not equal to any, return false;
                    2. equal to s1, idx1 + 1
                    3. equal to s2, idx2 + 1
                    4. both equal, 2 branch, take idx1 or idx2

    s1[0, i], s2[0, j] can interleave s3[0, i + j];
    dp[i][j] = false, s1.charAt(i) || s2.charAt(j) != s3.charAt(i + j);
               dp[i - 1][j]
               dp[i][j - 1]
               dp[i - 1][j] || dp[i][j - 1]
    dp[i][0] = s1[0, i] == s3[0, i]
    dp[0][j] = s2[0, j] == s3[0, j]

    */
}
//leetcode submit region end(Prohibit modification and deletion)

}