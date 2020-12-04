package BDFS.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139 {

    //memo

//    public boolean wordBreak(String s, List<String> wordDict) {
//        return dfs(s, 0, new HashSet<>(wordDict), new Boolean[s.length()]);
//    }
//
//    private boolean dfs(String s, int start, Set<String> dict, Boolean[] memo) {
//        if (start == s.length()) {
//            return true;
//        }
//
//        if (memo[start] != null) {
//            return memo[start];
//        }
//
//        for (int end = start ; end <= s.length() ; end++ ) {
//            if (dict.contains(s.substring(start, end)) && dfs(s, end, dict, memo)) {
//                memo[start] = true;
//                return memo[start];
//            }
//        }
//
//        memo[start] = false;
//        return false;
//    }

    //dp

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 1 ; i <= s.length() ; i++ ) {
            for (int j = 0 ; j < i ; j++ ) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
