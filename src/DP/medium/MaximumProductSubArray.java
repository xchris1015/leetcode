package DP.medium;

public class MaximumProductSubArray {
    // n size space complexity
//    public int maxProduct(int[] nums) {
//        // need to thinking about 0 and negative number clearifty before start
//
//        if (nums == null || nums.length == 0) {
//            return 0; //illegalArgumentException();
//        }
//
//        int[][] dp = new int[2][nums.length];
//        dp[0][0] = nums[0];
//        dp[1][0] = nums[0];
//        int max = nums[0];
//
//        for (int i = 1 ; i < dp[0].length ; i++ ) {
//            dp[0][i] = Math.max(nums[i], Math.max(dp[0][i - 1] * nums[i], dp[1][i - 1] * nums[i]));
//
//            dp[1][i] = Math.min(nums[i], Math.min(dp[0][i - 1] * nums[i], dp[1][i - 1] * nums[i]));
//
//            max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
//        }
//
//        return max;
//
//    }

    // O1 space
    public int maxProduct(int[] nums) {
        // need to thinking about 0 and negative number clearifty before start

        if (nums == null || nums.length == 0) {
            return 0; //illegalArgumentException();
        }

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int max = nums[0];

        for (int i = 1 ; i < nums.length ; i++ ) {
            // need to use temp, because we do not have last variable stored
            int tempMax = Math.max(nums[i], Math.max(maxSoFar * nums[i], minSoFar * nums[i]));

            minSoFar = Math.min(nums[i], Math.min(minSoFar * nums[i], maxSoFar * nums[i]));

            maxSoFar = tempMax;

            max = Math.max(max, Math.max(maxSoFar, minSoFar));

        }

        return max;

    }
}
