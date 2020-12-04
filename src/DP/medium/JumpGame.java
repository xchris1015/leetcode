package DP.medium;

public class JumpGame {

    // DFS without memory

//    public boolean canJump(int[] nums) {
//        // dfs
//
//        if (nums == null || nums.length <= 1) {
//            return true;
//        }
//
//        return helper(nums, 0, nums.length);
//    }
//
//    private boolean helper(int[] nums, int start, int target) {
//
//        if (start >= target) {
//            return true;
//        }
//
//        for (int i = nums[start] ; i >= 0 ; i-- ) {
//            if (helper(nums, start + i, target)) {
//                return true;
//            }
//        }
//
//        return false;
//    }


    // DFS memory
//    public boolean canJump(int[] nums) {
//        // dfs
//
//        if (nums == null || nums.length <= 1) {
//            return true;
//        }
//
//        canJump = new boolean[nums.length];
//        canJump[canJump.length - 1] = true;
//
//        return helper(nums, 0);
//    }
//
//    boolean[] canJump;
//
//    private boolean helper(int[] nums, int position) {
//
//        if (canJump[position]) {
//            return true;
//        }
//
//        for (int i = 1 ; i <= nums[i] ; i++ ) {
//            if (helper(nums, position + i)) {
//                canJump[position] = true;
//                return true;
//            }
//        }
//
//        canJump[position] = false;
//        return false;
//    }


//    public boolean canJump(int[] A) {
//        // dp[i] == from this position would able to access last, scan from right to left;
//
//        if (A == null || A.length == 0) {
//            return true;
//        }
//
//        boolean[] result = new boolean[A.length];
//        result[result.length - 1] = true;
//
//        for (int i = result.length - 2 ; i >= 0 ; i-- ) {
//            for (int j = 1 ; j < A[i] ; j++ ) {
//                if (result[i + j]) {
//                    result[i] = true;
//                    break;
//                }
//            }
//        }
//
//        return result[0];
//    }

    //based on last idea, dp to greedy
//    public boolean canJump(int[] nums) {
//        // 确定状态 和转移方程：i 岛 等于 从 i 之前的岛 j, j 可以， 且 i <= j + A[j]
//
//        if (nums == null || nums.length == 0) {
//            return true;
//        }
//        int lastPosition = nums.length - 1;
//        for (int i = lastPosition ; i >= 0 ; i-- ) {
//            if (i + nums[i] >= lastPosition) {
//                lastPosition = i;
//            }
//        }
//
//        return lastPosition == 0;
//    }

    public boolean canJump(int[] nums) {

        int maxRange = 0;
        for (int i = 0 ; i <= maxRange ; i++ ) {
            maxRange = Math.max(maxRange, nums[i] + i);

            if (maxRange >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
