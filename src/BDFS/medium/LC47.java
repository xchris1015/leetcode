package BDFS.medium;

import java.util.*;

public class LC47 {

    public List<List<Integer>> permuteUnique(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        //although input is ajacent, but after swap maybe is not, so cannot only use i = i - 1 to determine.

        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result);

        return result;
    }

    private void dfs(int[] nums, int start, List<List<Integer>> result) {

        if (start == nums.length - 1) {

            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }

            result.add(list);
            return;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = start ; i < nums.length ; i++ ) {
            // so we use a hashset to check the duplicate, if this value appears before, even it has been swapped, we could still get the deduplicate
            if (set.add(nums[i])) {
                swap(nums, i, start);
                dfs(nums, start + 1, result);
                swap(nums, i, start);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
