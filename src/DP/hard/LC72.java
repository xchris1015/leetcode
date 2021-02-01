package DP.hard;

public class LC72 {

    public int minDistance(String word1, String word2) {
        // dp, string1 i, to string2 j distance

        // a b c , a b
        // 1 delete 1
        // 2 add 1
        // 2 add 1

        //  0 a b c
        //0 0 1 2 3
        //b 1
        //c 2

        // could be optimize to 1d array + variable
        // 2 3 4 5
        // v...

        //cc

        //dp[i][j] = dp[i - 1][j - 1] if 1i = 2j
        //            min(dp[i][j - 1], dp[i - 1][j - 1], dp[i - 1][j]) + 1

        // dp[i][0] = i, dp[0][j] = j

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];// use + 1 because start at 1

        for (int i = 0 ; i <= word1.length() ; i++ ) {
            dp[i][0] = i;
        }

        for (int j = 0 ; j <= word2.length() ; j++ ) {
            dp[0][j] = j;
        }

        for (int i = 1 ; i < word1.length() + 1 ; i++ ) {
            for (int j = 1 ; j < word2.length() + 1 ; j++ ) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    // how  about one edit distance?
    // only three case:
    // a b c d
    // a b x c d

    // a b c d
    // a b x d

    // a b x c d
    // a b c d

    // for loop until two pointer difference, then, start with i - 1, i, or j - 1 to loop
    // loop the shorter one,

    // return longer one has one on the tail or not
}
