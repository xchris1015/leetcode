package BDFS.medium;

import java.util.ArrayList;
import java.util.List;

public class LC93 {

    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();

        if (s == null || s.length() == 0 || s.length() > 12) {
            return result;
        }

        dfs(s, 0, 4, new StringBuilder(), result);

        return result;

    }

    private void dfs(String s, int i, int k, StringBuilder current, List<String> result) {

        if (i == s.length() && k == 0) {
            current.setLength(current.length() - 1);
            result.add(current.toString());
            return;
        }

        if (k <= 0 || i == s.length()) {
            return;
        }

        int len = current.length();
        for (int l = 1 ; l <= 3 ;l++ ) {
            if (i + l > s.length()) break;

            int val = Integer.valueOf(s.substring(i, i + l));

            if (val <= 255) {
                current.append(val + ".");
                dfs(s, i + l, k - 1, current, result);
                current.setLength(len);
            }

            if (val == 0) break;
        }
    }
}
