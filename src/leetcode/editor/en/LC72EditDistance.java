package leetcode.editor.en;

public class LC72EditDistance{
    public static void main(String[] args) {
        Solution solution = new LC72EditDistance().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        //cc

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // if word1 is null, edit distance = word2.length, verse-vise, 0, 0 is 0
        for (int i = 1 ; i <= word1.length() ; i++ ) {
            dp[i][0] = i;
        }

        for (int j = 1 ; j <= word2.length() ; j++ ) {
            dp[0][j] = j;
        }

        for (int i = 1 ; i <= word1.length() ; i++ ) {
            for (int j = 1 ; j <= word2.length() ; j++ ) {
                int charIdx1 = i - 1, charIdx2 = j - 1;
                if (word1.charAt(charIdx1) == word2.charAt(charIdx2)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int replace = 1 + dp[i - 1][j - 1];
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    dp[i][j] = Math.min(replace, Math.min(insert, delete));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    /*
    search problem, two branch, dfs(idx1, idx2) = s1[0, idx1], s2[0, idx2] min edit distance
    idx1 == idx2 -> no change for edit distance, dfs(idx1, idx2) = dfs(idx1 - 1, idx2 - 1);
    idx1 != idx2
        1. replace 1 + dfs(idx1 - 1, idx2 - 1)
        2. insert  1 + dfs(idx1, idx2 - 1)
        3. delete  1 + dfs(idx1 - 1, idx2)


        cccb
           1
        ccc
          2
     */
}
//leetcode submit region end(Prohibit modification and deletion)

}