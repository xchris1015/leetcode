package DFS.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
//
//    public List<List<Integer>> subsets(int[] nums) {
//
//        if (nums == null || nums.length == 0) {
//            return new ArrayList<>();
//        }
//
//        List<List<Integer>> result = new ArrayList<>();
//        Queue<List<Integer>> queue = new LinkedList<>();
//        queue.offer(new ArrayList<>());
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//
//            for (int i = 0 ; i < size ; i++ ) {
//                List<Integer> current = queue.poll();
//                result.add(new ArrayList<>(current));
//                int start;
//
//                if (current.isEmpty()) {
//                    start = 0;
//                } else {
//                    start = current.get(current.size() - 1);
//                    start = indexOf(nums, start) + 1;
//                }
//
//                for (int j = start ; j < nums.length ; j++ ) {
//                    current.add(nums[j]);
//                    queue.offer(current);
//                    current.remove(current.size() - 1);
//                }
//            }
//        }
//
//        return result;
//    }

    private int indexOf(int[] nums, int value) {
        for (int i = 0 ; i < nums.length ; i++ ) {
            if (nums[i] == value) return i;
        }

        return -1;
    }

    public List<List<Integer>> subsets(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>());
        int level = 0;
        while (level < nums.length) {
            int size = queue.size();

            for (int i = 0 ; i < size ; i++ ) {
                List<Integer> current = queue.poll();

                queue.offer(new ArrayList<>(current));
                current.add(nums[level]);
                queue.offer(new ArrayList<>(current));
            }
            level++;
        }

        return (List) queue;
    }




    // DFS 2 use select or not select to have an complete tree
//    {}
//    {a} {}
//    {ab} {a} ...

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
//        if (start == nums.length) {
//            result.add(new ArrayList<>(list));
//            return;
//        }
//
//        list.add(nums[start]);
//        helper(nums, start + 1, list, result);
//        list.remove(list.size() - 1);
//
//        helper(nums, start + 1, list, result);
//    }
}
