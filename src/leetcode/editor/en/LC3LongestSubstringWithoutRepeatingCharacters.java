package leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

public class LC3LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LC3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
        solution.lengthOfLongestSubstring("aabaab!bb");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /*
        two pointer,
        hashset<character> to duplicate
        abcca
           s
           f
        {c, a}
         */
    public int lengthOfLongestSubstring(String s) {
        //cc
        Set<Character> set = new HashSet<>();
        int max = 0, j = 0;
        for (int i = 0 ; i < s.length() ; i++ ) {
            Character c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                max = Math.max(set.size(), max);
            } else {
                //shrink j
                while (j < i) {
                    if (s.charAt(j) != c) {
                        set.remove(s.charAt(j++));
                    } else {
                        j++;
                        break;
                    }
                }
            }
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}