package DP.medium;

public class LC300 {

    // DFS version, the dfs is the LIS end on the current i, thats the reason why we need an outter loop

//    public int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int max = 1;
//
//        for (int i = 0 ; i < nums.length ; i++ ) {
//            max = Math.max(max, dfs(nums, i));
//        }
//        return max;
//    }
//
//    private int dfs(int[] nums, int i) { // i means from 0 to i, LIS
//        if (i == 0) {
//            return 1;
//        }
//
//        int max = 1;
//
//        for (int j = 0 ; j < i ; j++ ) {
//            if (nums[j] < nums[i]) {
//                max = Math.max(max, 1 + dfs(nums, j));
//            }
//        }
//
//        return max;
//    }
//
//    // with mem
//
//    public int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int[] mem = new int[nums.length];
//        int max = 1;
//        for (int i = 0 ; i < nums.length ; i++ ) {
//            mem[i] = 1;
//            max = Math.max(max, dfs(nums, i, mem));
//        }
//        return max;
//    }
//
//    private int dfs(int[] nums, int i, int[] mem) { // i means from 0 to i, LIS
//        if (i == 0) {
//            return mem[0];
//        }
//
//        if (mem[i] > 1) {
//            return mem[i];
//        }
//
//        for (int j = 0 ; j < i ; j++ ) {
//            if (nums[j] < nums[i]) {
//                mem[i] = Math.max(mem[i], 1 + dfs(nums, j, mem));
//            }
//        }
//
//        return mem[i];
//    }

    // regular dp
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0 ; i < nums.length ; i++ ) {
            dp[i] = 1;
            for (int j = 0 ; j < i ; j++ ) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] input = {1,3,6,7,9,4,10,5,6};
        lengthOfLIS(input);
    }
}
