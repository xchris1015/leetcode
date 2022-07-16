package leetcode.editor.en;

public class LC9PalindromeNumber{
    public static void main(String[] args) {
        Solution solution = new LC9PalindromeNumber().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //TODO
        //use logic of reverse number
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;

        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}