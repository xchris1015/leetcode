package DP.easy;

public class LC121 {
    // 滚动variable
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int days = prices.length;
        int k = 1;
        // use k + 1 to prevent boundary issue, because we need k on the end
        int prevBuy = 0, currentBuy = 0, prevSell = 0, currentSell = 0;

        for (int times = 1 ; times <= k ; times++ ) {
            prevBuy = -prices[0];
            for (int i = 1 ; i < days ; i++ ) {
                // because we can only do one transaction, so every currentBuy need to start from current, which is 0 - price[i], not the prevSell
                currentBuy = Math.max(prevBuy, 0 - prices[i]);
                currentSell = Math.max(prevSell, prevBuy + prices[i]);
                prevBuy = currentBuy;
                prevSell = currentSell;
            }
        }

        return Math.max(currentSell, currentBuy);
    }

    public static void main(String[] args) {
        int[] intput = {7,1,5,3,6,4};
        maxProfit(intput);
    }
}
