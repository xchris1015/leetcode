package String.Hard;

import java.util.HashMap;
import java.util.Map;

public class LC76 {

    public String minWindow(String s, String t) {

        // sliding window with hashset

        Map<Character, Integer> T = new HashMap<>();

        for (int i = 0 ; i < t.length() ; i++ ) {
            T.put(t.charAt(i), T.getOrDefault(t.charAt(i), 0) + 1);
        }

        int sizeRequired = T.size();

        Map<Character, Integer> windows = new HashMap<>();

        int slow = 0, fast, count = 0;

        int start = 0, end = 0, len = -1;;

        for (fast = 0 ; fast < s.length() ; fast++ ) {
            char c = s.charAt(fast);
            windows.put(c, windows.getOrDefault(c, 0) + 1);

            if (T.containsKey(c) && windows.get(c).intValue() == T.get(c).intValue()) {
                count++;
            }

            while (slow <= fast && count == sizeRequired) {
                c = s.charAt(slow);

                if (len == -1 || fast - slow + 1 < len) {
                    len = fast - slow + 1;
                    start = slow;
                    end = fast;
                }

                windows.put(c, windows.get(c) - 1);

                if (T.containsKey(c) && windows.get(c).intValue() < T.get(c).intValue()) {
                    count--;
                }

                slow++;
            }

        }
        return len == -1 ? "" : s.substring(start, end + 1);
    }
}
