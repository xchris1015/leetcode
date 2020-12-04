package BDFS.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        helper(matrix, 0, matrix.length, matrix[0].length, list);
        return list;
    }

    private void helper(int[][] matrix, int offSet, int row, int col, List<Integer> list) {

        if (row <= 0 || col <= 0) {
            return;
        }

        if (row == 1 || col == 1) {
            if (row == 1) {
                for (int i = 0 ; i < col ; i++ ) {
                    list.add(matrix[offSet][offSet + i]);
                }
            } else {
                for (int i = 0 ; i < row ; i++ ) {
                    list.add(matrix[offSet + i][offSet]);
                }
            }
            return;
        }

        //top
        for (int i = 0 ; i < col - 1 ; i++ ) {
            list.add(matrix[offSet][offSet + i]);
        }

        for (int i = 0 ; i < row - 1 ; i++ ) {
            list.add(matrix[offSet + i][offSet + col - 1]);
        }

        for (int i = 0 ; i < col - 1 ; i++ ) {
            list.add(matrix[offSet + row - 1][offSet + col - 1 - i]);
        }

        for (int i = 0 ; i < row - 1 ; i++ ) {
            list.add(matrix[offSet + row - 1 - i][offSet]);
        }

        helper(matrix, offSet + 1, row - 2, col - 2, list);

    }
}
