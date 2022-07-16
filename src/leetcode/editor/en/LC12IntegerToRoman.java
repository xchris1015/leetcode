package leetcode.editor.en;

public class LC12IntegerToRoman{
    public static void main(String[] args) {
        Solution solution = new LC12IntegerToRoman().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /*
        int[][] to store all roman number info
        since the input has limit
        loop through the roman number,
            while num > current roman number
                num -= current roman number
                append
         */

        private final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        private final String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        public String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();
            // Loop through each symbol, stopping if num becomes 0.
            for (int i = 0; i < values.length && num > 0; i++) {
                // Repeat while the current symbol still fits into num.
                while (values[i] <= num) {
                    num -= values[i];
                    sb.append(symbols[i]);
                }
            }
            return sb.toString();
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}