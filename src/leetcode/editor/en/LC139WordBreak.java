package leetcode.editor.en;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139WordBreak{
    public static void main(String[] args) {
        Solution solution = new LC139WordBreak().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    search problem
    branch, for each char, determine cut to word inside dictionary or not
    l, le, lee, leet,
    TC 2^n SC, On

    pruning
    leet codecode
    leet codede
    store result based on current index, [i, s.length()) can cut a valid result,
    three conditions: null (init), true, false

    dp
    dp function : dp[i] = set.contains(s[j, i]) && dp[j] where j < i and j < s.length(), i < s.length()
    init : dp[0] = true
    */

        public boolean wordBreak(String s, List<String> wordDict) {
            //cc

            Set<String> set = new HashSet<>();
            for (String word : wordDict) {
                set.add(word);
            }
            // Boolean[] memo = new Boolean[s.length()];
            // return dfs(s, 0, set, memo);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1 ; i <= s.length() ; i++ ) {
                for (int j = 0 ; j < i ; j++ ) {
                    String sub = s.substring(j, i);
                    if (set.contains(sub) && dp[j]) {
                        dp[i] = true;
                    }
                }
            }

            return dp[s.length()];
        }


        private boolean dfs(String s, int start, Set<String> wordDict, Boolean[] memo) {
            if (start == s.length()) {
                return true;
            }

            if (memo[start] != null) {
                return memo[start];
            }

            for (int i = start ; i < s.length() ; i++ ) {
                String sub = s.substring(start, i + 1);
                if (wordDict.contains(sub) && dfs(s, i + 1, wordDict, memo)) {
                    memo[start] = true;
                    return true;
                }
            }

            memo[start] = false;
            return false;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}