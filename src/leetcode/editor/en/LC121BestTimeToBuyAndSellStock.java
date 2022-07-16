package leetcode.editor.en;

public class LC121BestTimeToBuyAndSellStock{
    public static void main(String[] args) {
        Solution solution = new LC121BestTimeToBuyAndSellStock().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int maxProfit(int[] prices) {
            //cc
            int buy = -prices[0];
            int sell = 0;
            for (int i = 1 ; i < prices.length ; i++ ) {
                buy = Math.max(buy, -prices[i]);
                sell = Math.max(sell, buy + prices[i]);
            }

            return sell;
        }

    /*
    dp[i] = [0, i] max profit
    sell[i] = max(sell[i - 1], price[i] + buy[i]);
    buy[i] = max(buy[i - 1], sell[i - 1] - prices[i]);

    sell[0] = 0;
    buy[0] = -price[0];


    prevBuy = -price[0];
    prevSell = 0;
    curBuy = max(prevbuy, prevSell - price[i]);
    curSell = max(prevSell, curBuy + price[i]);

    return curSell

    */
}
//leetcode submit region end(Prohibit modification and deletion)

}