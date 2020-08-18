package DP.easy;

public class FNumber {

    public int fib(int N) {
        if (N == 0) {
            return 0;
        }

        if (N == 1) {
            return 1;
        }

        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2 ; i <= N ; i++ ) {
            if (i % 3 == 2) {
                dp[2] = dp[0] + dp[1];
            } else if (i % 3 == 0){
                dp[0] = dp[1] + dp[2];
            } else {
                dp[1] = dp[0] + dp[2];
            }

        }

        return dp[N % 3];
    }
}
