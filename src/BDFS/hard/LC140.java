package BDFS.hard;

import java.util.*;

public class LC140 {
    // pure DFS
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        List<String> result = new ArrayList<>();
//
//        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
//            return result;
//        }
//
//        Set<String> set = new HashSet<>();
//
//        for (String word : wordDict) {
//            set.add(word);
//        }
//
//        dfs(s, set, 0, new StringBuilder(), result);
//        return result;
//    }
//
//    private void dfs(String s, Set<String> dict, int start, StringBuilder path, List<String> result) {
//
//        if (start == s.length()) {
//            path.setLength(path.length() - 1);
//            result.add(path.toString());
//            return;
//        }
//
//        int length = path.length();
//
//        for (int i = start + 1 ; i <= s.length() ; i++ ) {
//            String sb = s.substring(start, i);
//
//            if (dict.contains(sb)) {
//                path.append(sb + " ");
//                dfs(s, dict, i, path, result);
//                path.setLength(length);
//            }
//        }
//    }

    // with pruning, no imporve in big o

    public List<String> wordBreak(String s, List<String> wordDict) {

        //cc
        Set<String> dict = new HashSet<>();

        for (String string : wordDict) {
            dict.add(string);
        }

        List<String> result = new ArrayList<>();
        boolean[] memo = new boolean[s.length() + 1];
        Arrays.fill(memo, true);

        dfs(s, 0, dict, new StringBuilder(), result, memo);

        return result;
    }

    private void dfs(String s, int idx, Set<String> dict, StringBuilder sb, List<String> result, boolean[] memo) {

        if (idx == s.length()) {
            sb.setLength(sb.length() - 1);
            result.add(sb.toString());
            return;
        }

        int size = result.size();
        int length = sb.length();

        for (int i = idx + 1; i <= s.length(); i++) {
            String sub = s.substring(idx, i);
            if (dict.contains(sub) && memo[i]) {
                sb.append(sub + " ");
                dfs(s, i, dict, sb, result, memo);
                sb.setLength(length);
            }
        }

        if (size == result.size()) {
            memo[idx] = false;
        }

    }
}
