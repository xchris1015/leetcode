package BDFS.hard;

public class SudukuSolver {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }


    }

    private boolean solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0 ; i < rows ; i++ ) {
            for (int j = 0 ; j < cols ; j++ ) {
                if (board[i][j] == '.') {
                    for (char n = '1' ; n <= '9' ; n++ ) {
                        if (valid(board, i, j, n)) {
                            board[i][j] = n;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int row, int col, char num) {

        for (int i = 0 ; i < 9 ; i++ ) {
            char rowChar = board[i][col];
            char colChar = board[row][i];
            char boxChar = board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3];

            if (rowChar != '.' && num == rowChar) return false;
            if (colChar != '.' && num == colChar) return false;
            if (boxChar != '.' && num == boxChar) return false;
        }

        return true;
    }

}
