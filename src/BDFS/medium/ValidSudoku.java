package BDFS.medium;

import java.util.HashMap;

public class ValidSudoku {


    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }

        // for each row and cols and box, count the numbers, if there is an number exist before return false;

        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];

        for (int i = 0 ; i < 9 ; i++ ) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int i = 0 ; i < 9 ; i++ ) {
            for (int j = 0 ; j < 9 ; j++ ) {
                if (board[i][j] == '.') {
                    continue;
                }

                int current = (int) board[i][j];
                int boxIndex = (i / 3) * 3 + j / 3; // i / 3 define the col

                rows[i].put(current, rows[i].getOrDefault(current, 0) + 1);
                cols[j].put(current, cols[j].getOrDefault(current, 0) + 1);
                boxes[boxIndex].put(current, boxes[boxIndex].getOrDefault(current, 0) + 1);

                if (rows[i].get(current) > 1 || cols[j].get(current) > 1 || boxes[boxIndex].get(current) > 1 ) {
                    return false;
                }


            }
        }

        return true;

    }
}
