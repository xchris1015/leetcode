package DFS.medium;

import java.util.ArrayList;
import java.util.List;

public class ValidateParenthesis {
    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        int right = n, left = n;

        helper(right, left, new StringBuilder(), result);

        return result;
    }

    private void helper(int right, int left, StringBuilder sb, List<String> result) {

        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }

        if (right < left || left < 0 || right < 0) {
            return;
        }

        sb.append("(");
        helper(right, left - 1, sb, result);
        sb.setLength(sb.length() - 1);

        sb.append(")");
        helper(right - 1, left, sb, result);
        sb.setLength(sb.length() - 1);



    }
}
