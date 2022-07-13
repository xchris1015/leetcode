package leetcode.editor.en;

public class LC174DungeonGame{
    public static void main(String[] args) {
        Solution solution = new LC174DungeonGame().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //TODO
        public int calculateMinimumHP(int[][] dungeon) {
            int row = dungeon.length;
            int col = dungeon[0].length;
            int[][] dp = new int[row + 1][col + 1];

            for (int y = 0 ; y < dp.length ; y++ ) {
                dp[y][col] = Integer.MAX_VALUE;
            }

            for (int x = 0 ; x < dp[0].length ; x++ ) {
                dp[row][x] = Integer.MAX_VALUE;
            }

            dp[row][col - 1] = 1;
            dp[row - 1][col] = 1;

            for (int y = row - 1 ; y >= 0 ; y-- ) {
                for (int x = col - 1 ; x >= 0 ; x-- ) {
                    dp[y][x] = Math.max(1, Math.min(dp[y + 1][x], dp[y][x + 1]) - dungeon[y][x]);
                }
            }

            return dp[0][0];
        }

    /*
    dp[i][j] = from i, j to bottom right, minimun HP needed
    for each dp[i][j] min is 1 for alive, max is MAX
    for out of boundary, use MAX
    */
}
//leetcode submit region end(Prohibit modification and deletion)

}