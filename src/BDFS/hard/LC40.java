package BDFS.hard;

import java.util.*;

public class LC40 {

    // with memo to check size, if the result size still the same, means from this point, it cannot conduct a valid subarray.


    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        Set<String> dict = new HashSet<>(wordDict);
        boolean[] m = new boolean[s.length() + 1];
        Arrays.fill(m, true);

        dfs(s, 0, new StringBuilder(), result, dict, m);
        return result;
    }

    private void dfs(String s, int start, StringBuilder path, List<String> result, Set<String> dict, boolean[] m) {
        // success
        if (start == s.length()) {
            result.add(path.toString());
            return;
        }

        int size = result.size();
        int length = path.length();
        for (int end = start + 1 ; end <= s.length() ; end++ ) {
            String cur = s.substring(start, end);
            if (dict.contains(cur) && m[end]) {
                if (path.length() == 0) {
                    path.append(cur);
                } else {
                    path.append(" " + cur);
                }

                dfs(s, end, path, result, dict, m);
                path.setLength(length);
            }
        }

        if (size == result.size()) {
            m[start] = false;
        }
    }
}
