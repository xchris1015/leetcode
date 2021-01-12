package BDFS.medium;

import java.util.ArrayList;
import java.util.List;

public class LC320 {

    public List<String> generateAbbreviations(String word) {

        //cc

        List<String> result = new ArrayList<>();

        dfs(word, 0, 0, new StringBuilder(), result);

        return result;
    }

    private void dfs(String word, int idx, int count, StringBuilder sb, List<String> result) {

        if (idx == word.length()) {
            if (count > 0) {
                sb.append(count);
            }
            result.add(sb.toString());
            return;
        }

        int length = sb.length();

        //keep
        if (count > 0) {
            sb.append(count);
        }
        sb.append(word.charAt(idx));
        dfs(word, idx + 1, 0, sb, result);
        sb.setLength(length);

        //add to Num

        dfs(word, idx + 1, count + 1, sb, result);
    }
}
