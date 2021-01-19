package InteviewI;

public class StockIVLC188 {

    public int maxProfit(int k, int[] prices) {
        // dp:
        // buy[k, i] = Math.max(buy[k, i - 1], sell[k - 1, i - 1] - price[i]);
        // sell[k, i] = Math.max(sell[k, i - 1], buy[k, i - 1] + price[i]);

        if (prices == null || prices.length == 0 || prices.length < k) {
            return 0;
        }

        int[][] buy = new int[k + 1][prices.length];
        int[][] sell = new int[k + 1][prices.length];

        for (int times = 1 ; times <= k ; times++ ) {
            buy[times][0] = -prices[0];
            for (int date = 1 ; date < prices.length ; date++ ) {
                buy[times][date] = Math.max(buy[times][date - 1], sell[times - 1][date - 1] - prices[date]);
                sell[times][date] = Math.max(sell[times][date - 1], buy[times][date - 1] + prices[date]);
            }
        }

        return Math.max(buy[k][prices.length - 1], sell[k][prices.length - 1]);
    }
}
