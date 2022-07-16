package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class LC13RomanToInteger{
    public static void main(String[] args) {
        Solution solution = new LC13RomanToInteger().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /*
        from left to right,
        take one character, convert to number
        take one further, if bigger than current, take both and convert to number (further - current) (IV)
         */
        public final Map<Character, Integer> map = new HashMap<>();
    public int romanToInt(String s) {
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        //cc
        int i = 0, sum = 0;
        while (i < s.length()) {
            char current = s.charAt(i);
            int currentValue = map.get(current);
            int nextValue = 0;
            if (i + 1 < s.length()) {
                nextValue = map.get(s.charAt(i + 1));
            }

            if (currentValue < nextValue) {
                sum += nextValue - currentValue;
                i += 2;
            } else {
                sum += currentValue;
                i++;
            }
        }

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}