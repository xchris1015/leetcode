package leetcode.editor.en;

public class LC122BestTimeToBuyAndSellStockIi{
    public static void main(String[] args) {
        Solution solution = new LC122BestTimeToBuyAndSellStockIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int maxProfit(int[] prices) {
            //cc

            int prevSell = 0;
            int prevBuy = -prices[0];
            for (int i = 1 ; i < prices.length ; i++ ) {
                int curBuy = Math.max(prevBuy, prevSell - prices[i]);
                int curSell = Math.max(prevSell, curBuy + prices[i]);
                prevBuy = curBuy;
                prevSell = curSell;
            }

            return prevSell;
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

    prevBuy = curBuy
    prevSell = prevSell

    */
}
//leetcode submit region end(Prohibit modification and deletion)

}