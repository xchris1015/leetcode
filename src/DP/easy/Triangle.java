package DP.easy;

import java.util.List;

public class Triangle {

    // DFS without memory 2^n

//    public int minimumTotal(List<List<Integer>> triangle) {
//        if (triangle == null || triangle.size() == 0 || triangle.get(0) == null || triangle.size() == 0) {
//            return 0;
//        }
//
//        return helper(triangle, 0, 0);
//
//    }
//
//    private int helper(List<List<Integer>> triangle,
//                       int level,
//                       int col) {
//
//        if (level == triangle.size()) {
//            return 0;
//        }
//
//        int left = helper(triangle, level + 1, col);
//        int right = helper(triangle, level + 1, col + 1);
//
//        return triangle.get(level).get(col) + Math.min(left, right);
//
//    }
    //TODO

    public int minimumTotal(List<List<Integer>> triangle) {
        //dp base case
        int n = triangle.size();
        int[] dp = new int[triangle.get(n - 1).size()];
        for (int i = 0 ; i < n ; i++ ) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // from bottom to top

        for (int i = n - 2 ; i >= 0 ; i-- ) {
            for (int j = 0 ; j < triangle.get(i).size() ; j++ ) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }


}
