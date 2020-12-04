package BDFS.hard;

import java.util.*;

public class LC472 {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length <= 1) {
            return result;
        }
        Set<String> dict = new HashSet<>();
        Arrays.stream(words).filter(word-> word != null && !word.isEmpty()).forEach(word-> dict.add(word));

        for (String word : words) {
            boolean[] memo = new boolean[word.length() + 1];
            if (word == null || word.isEmpty()) continue;
            dict.remove(word);
            if (dfs(dict, word, 0, memo)) {
                result.add(word);
            }
            dict.add(word);
        }

        return result;
    }

    private boolean dfs(Set<String> dict, String s, int start, boolean[] memo) {

        if (start == s.length()) {
            return true;
        }

        if (start >= s.length()) {
            return false;
        }

        if (memo[start]) {
            return true;
        }

        for (int end = start + 1 ; end <= s.length() ; end++ ) {
            String sub = s.substring(start, end);
            if (dict.contains(sub) && dfs(dict, s, end, memo)) {
                memo[start] = true;
                return memo[start];
            }
        }

        memo[start] = false;
        return memo[start];
    }
}
