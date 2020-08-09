package DFS.medium;

import java.util.ArrayList;
import java.util.List;

public class Subset {

//    public List<List<Integer>> subsets(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return new ArrayList<>();
//        }
//
//        List<List<Integer>> result = new ArrayList<>();
//
//        helper(nums, 0, new ArrayList<Integer>(), result);
//
//        return result;
//    }
//
//    private void helper(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {
//
//        result.add(new ArrayList(list));
//
//        for (int i = start ; i < nums.length ; i++ ) {
//            list.add(nums[i]);
//            helper(nums, i + 1, list, result);
//            list.remove(list.size() - 1);
//        }
//    }

    // DFS 2 use select or not select to have an complete tree
//    {}
//    {a} {}
//    {ab} {a} ...

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        helper(nums, 0, new ArrayList<Integer>(), result);

        return result;
    }

    private void helper(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {

        if (start == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[start]);
        helper(nums, start + 1, list, result);
        list.remove(list.size() - 1);

        helper(nums, start + 1, list, result);
    }
}
