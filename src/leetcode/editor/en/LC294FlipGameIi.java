package leetcode.editor.en;

public class LC294FlipGameIi{
    public static void main(String[] args) {
        Solution solution = new LC294FlipGameIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //TODO cannot use bit to do questions
    public boolean canWin(String currentState) {
        //cc
        char[] board = currentState.toCharArray();
        int intBoard = 0;

//        return dfs(intBoard);
        return true;
    }

//    private boolean dfs(int board) {
//        if (!canFlip(board)) {
//            return false; // current play cannot filp the board
//        }
//
//        for (int i = 0 ; i < board.length - 1 ; i++ ) {
//            if (board[i] == '+' && board[i + 1] == '+') {
//                //can flip
//                board[i] = '-';
//                board[i + 1] = '-';
//                boolean nextPlayerResult = dfs(board);
//                board[i] = '+';
//                board[i + 1] = '+';
//
//                if (!nextPlayerResult) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }

    private boolean canFlip(char[] board) {
        for (int i = 0 ; i < board.length - 1; i++ ) {
            if (board[i] == '+' && board[i + 1] == '+') {
                return true;
            }
        }

        return false;
    }

    /*
    search problem, branch, for each two conservative position, flip, if other player cannot flip, win

     */
}
//leetcode submit region end(Prohibit modification and deletion)

}