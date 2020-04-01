package DP.medium;

public class JumpGame {
    public boolean canJump(int[] A) {
        // 确定状态 和转移方程：i 岛 等于 从 i 之前的岛 j, j 可以， 且 i <= j + A[j]

        if (A == null || A.length == 0) {
            return true;
        }

        boolean[] result = new boolean[A.length];
        result[0] = true;

        for (int i = 1 ; i < result.length ; i++ ) {
            result[i] = false;
            for (int j = 0 ; j < i ; j++ ) {
                if (result[j] && (i <= j + A[j])) {
                    result[i] = true;
                    break;
                }
            }
        }

        return result[result.length - 1];
    }
}
