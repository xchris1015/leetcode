package BDFS.hard;

import java.util.ArrayList;
import java.util.List;

public class LC301 {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        if (s == null) {
            return result;
        }

        int delta = 0;
        int leftMove = 0;
        int rightMove = 0;
        for (int i = 0 ; i < s.length() ; i++ ) {
            if (s.charAt(i) == '(') {
                leftMove++;
            } else if (s.charAt(i) == ')') {
                if (leftMove > 0) {
                    leftMove--;
                } else {
                    rightMove++;
                }
            }
        }

        char[] chars = s.toCharArray();

        dfs(chars, 0, leftMove, rightMove, 0, new StringBuilder(), result);

        return result;

    }

    private void dfs(char[] chars, int idx, int leftMove, int rightMove, int delta, StringBuilder path, List<String> result) {

        if (leftMove == 0 && rightMove == 0 && idx == chars.length && delta == 0) {
            result.add(path.toString());
            return;
        }

        if (leftMove < 0 || rightMove < 0 || idx >= chars.length || delta < 0) {
            return;
        }


        // only branch to ( and ), keep and not keep, thats it, no need to branch to other char
        char current = chars[idx];

        if (current == '(') {
            // remove
            dfs(chars, idx + 1, leftMove - 1, rightMove, delta, path, result);

            // deduplicate
            int rep = 1;
            while (idx + rep < chars.length && chars[idx] == chars[idx + rep]) {
                rep++;
            }

            //keep
            path.append(chars, idx, rep);
            dfs(chars, idx + rep, leftMove, rightMove, delta + rep, path, result);
            path.setLength(path.length() - rep);

        } else if (current == ')') {
            dfs(chars, idx + 1, leftMove, rightMove - 1, delta, path, result);

            int rep = 1;
            while (idx + rep < chars.length && chars[idx] == chars[idx + rep]) {
                rep++;
            }

            //keep
            path.append(chars, idx, rep);
            dfs(chars, idx + rep, leftMove, rightMove, delta - rep, path, result);
            path.setLength(path.length() - rep);
        } else {
            path.append(current);
            dfs(chars, idx + 1, leftMove, rightMove, delta, path, result);
            path.setLength(path.length() - 1);
        }
    }
}
