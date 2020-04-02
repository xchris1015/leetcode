package DP.medium;

public class BackPackIX {

    // 使用滚动数组优化了空间复杂度， 为什么要从右往左，
    // 因为这里是取上一层和左边的数字， 但是左边的数字其实现在还是上一层左边的结果， 如果从左往右， 就已经成现在这层的结果了
    public double backpackIX(int n, int[] prices, double[] probability) {
        double[] dp = new double[n + 1];

        for (int i = 0 ; i <= n ; i++ ) {
            dp[i] = 1.0;
        }

        for (int i = 0; i < probability.length; i++) {
            probability[i] = 1 - probability[i];
        }

        for (int a = 0 ; a < probability.length ; a++ ) {
            for (int b = n ; b >= prices[a] ; b-- ) {
                dp[b] = Math.min(dp[b], dp[b - prices[a]] * probability[a]);
            }
        }

        return 1 - dp[n];
    }
}
