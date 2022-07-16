package leetcode.editor.en;

public class LC123BestTimeToBuyAndSellStockIii{
    public static void main(String[] args) {
        Solution solution = new LC123BestTimeToBuyAndSellStockIii().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int maxProfit(int[] prices) {
            //cc

            int[][] sell = new int[3][prices.length];
            int[][] buy = new int[3][prices.length];
            buy[0][0] = -prices[0];
            for (int k = 1 ; k <= 2 ; k++ ) {
                buy[k][0] = -prices[0];
                for (int i = 1 ; i< prices.length ; i++ ) {
                    sell[k][i] = Math.max(sell[k][i - 1], prices[i] + buy[k][i - 1]);
                    buy[k][i] = Math.max(buy[k][i - 1], sell[k - 1][i - 1] - prices[i]);
                }
            }

            return sell[2][prices.length - 1];
        }

    /*
    sell[k][i] = max(sell[k][i - 1], price[i] + buy[k][i - 1]);
    buy[k][i] = max(buy[k][i - 1], sell[k - 1][i - 1] - price[i])

    sell[0][i] = 0;
    sell[k][0] = 0;
    buy[0][i] = 0;
    buy[k][0] = -price[0]
    */
}
//leetcode submit region end(Prohibit modification and deletion)

}