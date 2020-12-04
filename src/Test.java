import BDFS.medium.LC130;
import BDFS.medium.LC93;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        if (s == null || s.length() == 0 || s.length() > 12) {
            return result;
        }

        dfs(0, 0, s, new StringBuilder(), result);
        return result;
    }

    private void dfs(int i, int parts, String s, StringBuilder sb, List<String> result) {

        if (parts == 4 && i == s.length()) {
            sb.setLength(sb.length() - 1);
            result.add(sb.toString());
            return;
        }

        if (parts >= 4 || i >= s.length()) {
            return;
        }
        int length = sb.length();
        for (int l = 1 ; l <= 3 ; l++ ) {
            if (i + l > s.length()) {
                break;
            }

            String current = s.substring(i, i + l);
            int val = Integer.valueOf(current);
            if (val >= 0 && val <= 255) {
                sb.append(current + '.');
                dfs(i + l, parts + 1, s, sb, result);
                sb.setLength(length);
            }
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        Test test = new Test();
        test.restoreIpAddresses(s);
    }
}
