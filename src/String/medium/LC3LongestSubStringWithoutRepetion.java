package String.medium;

import java.util.HashSet;
import java.util.Set;

public class LC3LongestSubStringWithoutRepetion {

    // a b c e f c b b c
    // s
    // f
    //hashset {}

    public int lengthOfLongestSubstring(String s) {
        //cc
        // demo, that we need an hashset/hashmap to save passing elements,

        Set<Character> set = new HashSet<>();
        int slow = 0;
        int max = 0;
        for (int fast = 0 ; fast < s.length() ; fast++ ) {
            char c = s.charAt(fast);
            if (set.contains(c)) {
                max = Math.max(max, fast - slow);
                while (set.contains(c)) {
                    set.remove(s.charAt(slow++));
                }
            }
            set.add(c);
        }

        return max;
    }

}
