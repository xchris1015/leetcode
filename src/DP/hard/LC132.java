package DP.hard;

public class LC132 {

    public static int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 0;

        for (int i = len -  1 ; i >= 0 ; i-- ) {
            int min = Integer.MAX_VALUE;
            for (int j = i ; j < len ; j++ ) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub)) {
                    min = Math.min(min, dp[j + 1]);
                }
            }
            dp[i] = min;
        }

        return dp[0];

    }

    private int dfs(String s, int i, int[] dp) {
        if (i == s.length()) {
            dp[i] = 0;
            return dp[i];
        }

        if (dp[i] != 0) {
            return dp[i];
        }

        int min = Integer.MAX_VALUE;
        for (int j = i + 1 ; j < s.length() ; j++ ) {
            String sub = s.substring(i, j + 1);
            if (isPalindrome(sub)) {
                min = Math.min(min, dfs(s, j, dp));
            }
        }

        dp[i] = min;
        return dp[i];
    }

    private static boolean isPalindrome(String s) {
        // cc

        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "aab";
        System.out.println(minCut(input));
    }
}
