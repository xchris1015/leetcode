package leetcode.editor.en;

public class LC5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LC5LongestPalindromicSubstring().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //TODO
        /*
        cbbd
         */
    public String longestPalindrome(String s) {
        int max = 1;
        int resultLeft = 0, resultRight = 0;
        for (int i = 0 ; i < s.length() ; i++ ) {
            int left = i - 1, right = i + 1, localMax = 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    localMax += 2;
                }
                if (localMax > max) {
                    max = localMax;
                    resultLeft = left;
                    resultRight = right;
                }
                left--;
                right++;
            }
        }
        return s.substring(resultLeft, resultRight + 1);

    }


}
//leetcode submit region end(Prohibit modification and deletion)

}