package DP.hard;

public class LC123 {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int days = prices.length;
        int k = 2;
        int prevBuy = -prices[0], prevSell = 0, currentBuy = 0, currentSell = 0;
        int prevBuy2 = -prices[0], prevSell2 = 0, currentBuy2 = 0, currentSell2 = 0;

        for (int i = 1 ; i < days ; i++ ) {
            currentBuy = Math.max(prevBuy, 0 - prices[i]);
            currentSell = Math.max(prevSell, currentBuy + prices[i]);

            currentBuy2 = Math.max(prevBuy2, prevSell - prices[i]);
            currentSell2 = Math.max(prevSell2, currentBuy + prices[i]);

            prevSell = currentSell;
            prevBuy = currentBuy;
            prevSell2 = currentSell2;
            prevBuy2 = currentBuy2;
        }

        return Math.max(currentSell2, currentSell);
    }

    public static void main(String[] args) {
        int[] intput = {3,3,5,0,0,3,1,4};
        maxProfit(intput);
    }
}
