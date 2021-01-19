package String.easy;

public class LC26 {

    public int removeDuplicates(int[] nums) {

        // 0 1 2 3 4 2 2 3 3 4
        //                     i
        //           j

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int j = 0;

        for (int i = 0 ; i < nums.length ; i++ ) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            nums[j++] = nums[i];
        }

        return j;
    }
}
