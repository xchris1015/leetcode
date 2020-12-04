package DP.hard;

public class JumpGame2 {

    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int times = 0;
        int prevMax = 0;
        int curMax = 0;

        for (int i = 0 ; i < nums.length; i++ ) {
            if (curMax >= nums.length - 1) {
                return times + 1;
            }

            if (i > prevMax) {
                times++;
                prevMax = curMax;
            }

            curMax = Math.max(i + nums[i], curMax);
        }

        if (curMax >= nums.length - 1) {
            return times + 1;
        }

        return 0;
    }
}
