package DP.easy;

public class HouseRobber {

    //On

    public int rob(int[] nums) {
        // function : dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2 ; i < dp.length ; i++ ) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[dp.length - 1];
    }
}
