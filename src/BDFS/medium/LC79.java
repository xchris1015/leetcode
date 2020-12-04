package BDFS.medium;

public class LC79 {

    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 ||
                word == null || word.length() == 0) {
            return false;
        }

        boolean result = false;
        for (int i = 0 ; i < board.length ; i++ ) {
            for (int j = 0 ; j < board[0].length ; j++ ) {
                if (board[i][j] == word.charAt(0)) {
                    result = result || dfs(board, i, j, word, 0, new boolean[board.length][board[0].length]);
                }
            }
        }

        return result;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int idx, boolean[][] visited) {

        if (idx == word.length()) {
            return true;
        }

        if (!valid(board, i, j, visited) || board[i][j] != word.charAt(idx)) {
            return false;
        }


        visited[i][j] = true;

        boolean result = dfs(board, i + 1, j, word, idx + 1, visited)
                || dfs(board, i - 1, j, word, idx + 1, visited)
                || dfs(board, i, j + 1, word, idx + 1, visited)
                || dfs(board, i, j - 1, word, idx + 1, visited);

        visited[i][j] = false;
        return result;
    }

    private boolean valid(char[][] board, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return false;
        }

        return true;
    }
}
