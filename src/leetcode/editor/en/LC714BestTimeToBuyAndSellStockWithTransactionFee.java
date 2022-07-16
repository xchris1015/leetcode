package leetcode.editor.en;

public class LC714BestTimeToBuyAndSellStockWithTransactionFee{
    public static void main(String[] args) {
        Solution solution = new LC714BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int maxProfit(int[] prices, int fee) {
            //cc

            int prevSell = 0, prevBuy = -prices[0], currentSell = 0, currentBuy = prevBuy;

            for (int i = 1 ; i < prices.length ; i++ ) {
                currentBuy = Math.max(prevBuy, prevSell - prices[i]);
                currentSell = Math.max(prevSell, prevBuy + prices[i] - fee);
                prevBuy = currentBuy;
                prevSell = currentSell;
            }

            return currentSell;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}