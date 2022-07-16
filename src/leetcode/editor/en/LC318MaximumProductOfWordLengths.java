package leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

public class LC318MaximumProductOfWordLengths{
    public static void main(String[] args) {
        Solution solution = new LC318MaximumProductOfWordLengths().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //TODO good article to improve the comparsion and storage
        public int maxProduct(String[] words) {
            //cc
            int globalMax = 0;
            Set<Character> elements = new HashSet<>();
            for (String word : words) {

                for (char ch : word.toCharArray()) {
                    elements.add(ch);
                }

                for (String other : words) {
                    if (word.equals(other)) {
                        continue;
                    }

                    if (word.equals("fcf") && other.equals("dabae")) {
                        int test = 0;
                    }

                    boolean overlap = false;
                    for (char c : other.toCharArray()) {
                        if (elements.contains(c)) {
                            overlap = true;
                            break;
                        }
                    }

                    if (!overlap) {
                        globalMax = Math.max(globalMax, word.length() * other.length());
                    }
                }
                elements.clear();
            }

            return globalMax;
        }

    /*
    for each word
        store all char for this word
        for other each word
            check if there is any matched words,
                if not : compare to gloal max with those two product

    TC: O((n*k)^2) SC: k


    */
}
//leetcode submit region end(Prohibit modification and deletion)

}