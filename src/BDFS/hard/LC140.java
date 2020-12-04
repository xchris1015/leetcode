package BDFS.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC140 {
    // pure DFS
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();

        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return result;
        }

        Set<String> set = new HashSet<>();

        for (String word : wordDict) {
            set.add(word);
        }

        dfs(s, set, 0, new StringBuilder(), result);
        return result;
    }

    private void dfs(String s, Set<String> dict, int start, StringBuilder path, List<String> result) {

        if (start == s.length()) {
            path.setLength(path.length() - 1);
            result.add(path.toString());
            return;
        }

        int length = path.length();

        for (int i = start + 1 ; i <= s.length() ; i++ ) {
            String sb = s.substring(start, i);

            if (dict.contains(sb)) {
                path.append(sb + " ");
                dfs(s, dict, i, path, result);
                path.setLength(length);
            }
        }
    }
}
