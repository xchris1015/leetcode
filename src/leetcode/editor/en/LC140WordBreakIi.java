package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC140WordBreakIi{
    public static void main(String[] args) {
        Solution solution = new LC140WordBreakIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /*
        search problem -> all possible solution,
        branch, for each position, cut or not

        TC: 2^n, sc, n

        pruning: memo[start] == false, means there is no more word if you go deeper
        only change in constant factor
         */


    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        for (String w :  wordDict) {
            dict.add(w);
        }
        Boolean[] memo = new Boolean[s.length() + 1];
        dfs(s, 0, dict, new StringBuilder(), result, memo);
        return result;
    }

    private boolean dfs(String s, int start, Set<String> dict, StringBuilder path, List<String> result, Boolean[] memo) {
        if (start >= s.length()) {
            path.setLength(path.length() - 1);
            result.add(path.toString());
            return true;
        }

        if (memo[start] != null && !memo[start]) {
            return false;
        }

        int length = path.length();
        int resultLength = result.size();
        for (int i = start ; i < s.length() ; i++ ) {
            String sub = s.substring(start, i + 1);
            if (dict.contains(sub)) {
                path.append(sub).append(" ");
                dfs(s, i + 1, dict, path, result, memo);
                path.setLength(length);
            }
        }

        if (result.size() > resultLength) {
            memo[start] = true;
            return true;
        }

        memo[start] = false;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}