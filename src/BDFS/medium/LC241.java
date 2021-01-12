package BDFS.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC241 {

    // DFS

//    public List<Integer> diffWaysToCompute(String input) {
//
//        if (input == null) {
//            return new ArrayList<>();
//        }
//
//        return dfs(input, 0, input.length() - 1);
//    }
//
//    // idea of syntax tree, and for every operation, it will be an single root
//
//    private List<Integer> dfs(String input, int start, int end) {
//
//        List<Integer> result = new ArrayList<>();
//
//        if (start > end) {
//            return result;
//        }
//
//        boolean isNum = true;
//
//        for (int i = start ; i <= end ; i++ ) {
//            char ch = input.charAt(i);
//
//            if (ch == '+' || ch == '-' || ch == '*') {
//                isNum = false;
//                List<Integer> left = dfs(input, start, i - 1);
//                List<Integer> right = dfs(input, i + 1, end);
//
//                for (Integer l : left) {
//                    for (Integer r : right) {
//                        result.add(calculator(ch, l, r));
//                    }
//                }
//            }
//        }
//
//        if (isNum) {
//            result.add(Integer.valueOf(input.substring(start, end + 1)));
//        }
//
//        return result;
//    }

    //DFS with pruning

    public List<Integer> diffWaysToCompute(String input) {

        if (input == null) {
            return new ArrayList<>();
        }

        Map<String, List<Integer>> memo = new HashMap<>();

        return dfs(input, 0, input.length() - 1, memo);
    }

    // idea of syntax tree, and for every operation, it will be an single root

    private List<Integer> dfs(String input, int start, int end, Map<String, List<Integer>> memo) {

        String current = input.substring(start, end + 1);

        if (memo.get(current) != null) {
            return memo.get(current);
        }

        List<Integer> result = new ArrayList<>();

        if (start > end) { // not needed
            return result;
        }

        boolean isNum = true;

        for (int i = start ; i <= end ; i++ ) {
            char ch = input.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {
                isNum = false;
                List<Integer> left = dfs(input, start, i - 1, memo);
                List<Integer> right = dfs(input, i + 1, end, memo);

                for (Integer l : left) {
                    for (Integer r : right) {
                        result.add(calculator(ch, l, r));
                    }
                }
            }
        }

        if (isNum) {
            result.add(Integer.valueOf(current));
        }

        memo.put(current, result);
        return result;
    }

    private int calculator (char ch, int l, int r) {
        if (ch == '+') {
            return l + r;
        } else if (ch == '-') {
            return l - r;
        } else if (ch == '*') {
            return l * r;
        }

        return 0;
    }
}
