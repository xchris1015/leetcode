package Array.Hard;

import java.util.HashSet;
import java.util.Set;

public class LongestConsdecutiveSequence {

    // Similar to two sum, us hashset to have O(1) check. Also can use two pointer with sort.

    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        for (int i = 0 ; i < nums.length ; i++ ) {
            set.add(nums[i]);
        }

        int result = helper(nums, set);
        return result;
    }

    private int helper(int[] nums, Set<Integer> map) {

        int result = 0;

        for (int i = 0 ; i < nums.length ; i++ ) {
            int current = 1;

            if (!map.contains(nums[i] + 1)) {
                current = 1;
            } else {
                int number = nums[i];
                while (map.contains(number + 1)) {
                    current += 1;
                    number += 1;
                }

            }
            result = Math.max(current, result);
        }

        return result;

    }
}
