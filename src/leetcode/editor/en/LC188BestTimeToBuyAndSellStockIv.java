package leetcode.editor.en;

public class LC188BestTimeToBuyAndSellStockIv{
    public static void main(String[] args) {
        Solution solution = new LC188BestTimeToBuyAndSellStockIv().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int maxProfit(int k, int[] prices) {
            //cc
            if (prices == null || prices.length == 0) {
                return 0;
            }

            int[][] sell = new int[k + 1][prices.length];
            int[][] buy = new int[k + 1][prices.length];

            for (int curK = 1 ; curK <= k ; curK++ ) {
                buy[curK][0] = -prices[0];
                for (int i = 1 ; i < prices.length ; i++ ) {
                    sell[curK][i] = Math.max(sell[curK][i - 1], prices[i] + buy[curK][i - 1]);
                    buy[curK][i] = Math.max(buy[curK][i - 1], sell[curK - 1][i - 1] - prices[i]);
                }
            }



            return sell[k][prices.length - 1];
        }

    /*
    int[k][i] dp = from [0, i] use at most ks transaction
    sell[k][i] = not sell, sell[k][i - 1]
                 sell, price[i] + buy[k][i - 1]

    buy[k][i] = not buy, buy[k][i - 1]
                buy, -price[i] + sell[k - 1][i - 1]

    sell[0][i] = 0;
    sell[k][0] = 0;
    buy[0][i] = 0;
    buy[k][0] = -price[0];
    */
}
//leetcode submit region end(Prohibit modification and deletion)

}