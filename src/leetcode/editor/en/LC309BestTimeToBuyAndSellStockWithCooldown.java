package leetcode.editor.en;

public class LC309BestTimeToBuyAndSellStockWithCooldown{
    public static void main(String[] args) {
        Solution solution = new LC309BestTimeToBuyAndSellStockWithCooldown().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int maxProfit(int[] prices) {
            //cc

            int prevSell = 0, currentSell = 0, nextSell = 0, currentBuy = -prices[0], nextBuy = currentBuy;

            for (int i = 1 ; i < prices.length ; i++ ) {
                nextBuy = Math.max(currentBuy, prevSell - prices[i]);
                nextSell = Math.max(currentSell, prices[i] + nextBuy);
                prevSell = currentSell;
                currentSell = nextSell;
                currentBuy = nextBuy;
            }

            return nextSell;
        }

    /*
    sell[i] = max(sell[i - 1], prices[i] + buy[i]);
    buy[i] = max(buy[i - 1], sell[i - 2] - prices[i]);
    sell[0] = 0;
    buy[0] = -prices[0];

    prevSell      currentSell      nextSell
    sell[i - 2]    sell[i - 1]       sell[i]
                     currentBuy       nextBuy
                       buy[i - 1]     buy[i]
    */
}
//leetcode submit region end(Prohibit modification and deletion)

}