package leetcode.editor.en;

public class LC7ReverseInteger{
    public static void main(String[] args) {
        Solution solution = new LC7ReverseInteger().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //TODO
        // need to check integer limit
//        public int reverse(int x) {
//            int input = x > 0 ? x : -x;
//            int result = 0;
//            while (input > 0) {
//                int addValue = input % 10;
//                result = result * 10 + addValue;
//                input = input / 10;
//            }
//            if (x < 0) {
//                return -result;
//            }
//            return result;
//        }

        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10;
                if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
                if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
                rev = rev * 10 + pop;
            }
            return rev;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}