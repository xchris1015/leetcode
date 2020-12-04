package TwoPointer;

public class TargetSumFollowUp {

    //exists 2 non-overlap subarray => sum == target? All numbers are positive.

    public boolean findSubarray(int[] nums, int target) {

        if (nums == null || nums.length <= 1) {
            throw new IllegalArgumentException();
        }

        int start = 0, end, sum = 0;
        int[][] result = new int[2][2];
        int resultIdx = 0;

        for (end = 1 ; end < nums.length ; end++ ) {
            sum += nums[end];

            if (sum < target) {
                continue;
            } else if (sum == target) {
                result[resultIdx] = new int[2];

                for (int i = 0 ; i < result.length ; i++ ) {
                    int idx1 = result[i][0], idx2 = result[i][1];
                    if (start >= idx1 && start <= idx2 || (end >= idx1 && end <= idx2)) {
                        break;
                    } else {
                        result[resultIdx][0] = start;
                        result[resultIdx][1] = end;
                        resultIdx++;
                    }
                }
            } else {
                while (sum > target) {
                    sum -= nums[start++];
                }
            }
        }

        return false;
    }



}
