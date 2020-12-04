package DP.hard;

public class LC188 {

    public static int maxProfit(int k, int[] prices) {
        // two dimensional dp array, buy and sell

        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }

        int days = prices.length;
        // use k + 1 to prevent boundary issue, because we need k on the end
        int[][] buy = new int[k + 1][days];
        int[][] sell = new int[k + 1][days];

        for (int times = 1 ; times <= k ; times++ ) {
            buy[times][0] = -prices[0];
            for (int i = 1 ; i < days ; i++ ) {
                buy[times][i] = Math.max(buy[times][i - 1], sell[times - 1][i - 1] - prices[i]);
                sell[times][i] = Math.max(sell[times][i - 1], buy[times][i - 1] + prices[i]);
            }
        }

        return Math.max(buy[k][days - 1], sell[k][days - 1]);
    }

    public static void main(String[] args) {
        int[] intput = {3,2,6,5,0,3};
        maxProfit(2, intput);
    }
}
