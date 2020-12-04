package BinaryTree.Medium;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC95Count {

    // pruning
//    public static int generateTrees(int n) {
//
//        if (n <= 0) {
//            return 0;
//        }
//
//        int[] size = new int[n + 1];
//        size[0] = 1;
//
//        return dfs(n, size);
//    }
//
//    private static int dfs(int n, int[] size) {
//        if (size[n] != 0) {
//            return size[n];
//        }
//
//        for (int i = 1 ; i <= n ; i++ ) {
//            int lefts = dfs(i - 1, size);
//            int rights = dfs(n - i, size);
//
//            size[n] += lefts * rights;
//        }
//
//        return size[n];
//    }

    // dp[i], i means size, dp[i] means at size i, the total combination result

    public static int generateTrees(int n) {

        if (n <= 0) {
            return 0;
        }

        int[] dp = new int[n + 1];// need result n;
        dp[0] = 1;

        for (int i = 1 ; i <= n ; i++ ) {
            for (int j = 0 ; j < i ; j++ ) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(generateTrees(4));
    }



}
