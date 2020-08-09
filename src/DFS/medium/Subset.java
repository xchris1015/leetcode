package DFS.medium;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        helper(nums, 0, new ArrayList<Integer>(), result);

        return result;
    }

    private void helper(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {

        result.add(new ArrayList(list));

        for (int i = start ; i < nums.length ; i++ ) {
            list.add(nums[i]);
            helper(nums, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}
