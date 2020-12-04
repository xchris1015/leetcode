package DFS.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        if (candidates == null || candidates.length == 0) {
//            return new ArrayList<>();
//        }
//
//        List<List<Integer>> result = new ArrayList<>();
//
//        helper(candidates, target, 0, new ArrayList<>(), result);
//
//        return result;
//    }
//
//    private void helper(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> result) {
//
//        if (target == 0) {
//            result.add(new ArrayList<>(list));
//            return;
//        }
//
//        if (target < 0) {
//            return;
//        }
//
//        for (int i = start ; i < candidates.length ; i++ ) {
//            list.add(candidates[i]);
//            helper(candidates, target - candidates[i], i, list, result);
//            list.remove(list.size() - 1);
//        }
//
//
//
//    }
//
//    // CombinationSum II
//    // do not allow duplicate solution, which we need to sort input first and jump over the same element
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//
//        if (candidates == null || candidates.length == 0) {
//            return new ArrayList<>();
//        }
//
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(candidates);
//        helper(candidates, target, 0, new ArrayList<>(), result);
//
//        return result;
//    }
//
//    private void helper(int[] candidates, int target, int level, List<Integer> list, List<List<Integer>> result) {
//
//        if (target == 0) {
//            result.add(new ArrayList<>(list));
//            return;
//        }
//
//        if (target < 0) {
//            return;
//        }
//
//        for (int i = level ; i < candidates.length ; i++ ) {
//            if (i > level && candidates[i] == candidates[i - 1]) {
//                continue;
//            }
//            list.add(candidates[i]);
//            helper(candidates, target - candidates[i], i + 1, list, result);
//            list.remove(list.size() - 1);
//        }
//
//
//
//    }
//
//
//    //Combination Sum III
//
//    public List<List<Integer>> combinationSum3(int k, int n) {
//        if (n == 0 || k == 0 || k > n) {
//            return new ArrayList<>();
//        }
//
//        List<List<Integer>> result = new ArrayList<>();
//
//        helper(n, k, 1, new ArrayList<>(), result);
//
//        return result;
//    }
//
//    private void helper(int target, int k, int start, List<Integer> list, List<List<Integer>> result) {
//
//        if (target == 0 && list.size() == k) {
//            result.add(new ArrayList<>(list));
//            return;
//        }
//
//        if (target < 0 || list.size() > k) {
//            return;
//        }
//
//        for (int i = start ; i < 10 ; i++ ) {
//            list.add(i);
//            helper(target - i, k, i + 1, list, result);
//            list.remove(list.size() - 1);
//        }
//
//
//
//    }
}
