package BDFS.medium;

import java.util.HashMap;
import java.util.Map;

public class LC294 {

    // pruning

    public boolean canWin(String s) {
        Map<String, Boolean> memo = new HashMap<>();
        return dfs(s.toCharArray(), memo);
    }

    private boolean dfs(char[] board, Map<String, Boolean> memo) {// need to care about the string address and hashcode

        String s = new String(board);

        Boolean result = memo.get(s);

        if (result != null) {
            return result;
        }

        for (int i = 0 ; i < board.length - 1 ; i++ ) {
            if (board[i] == '+' && board[i + 1] == '+') {
                board[i] = '-';
                board[i + 1] = '-';
                result = dfs(board, memo);
                board[i] = '+';
                board[i + 1] = '+';

                if (!result) {
                    memo.put(new String(board), true);
                    return true;
                }
            }
        }

        memo.put(new String(board), false);
        return false;
    }
}
