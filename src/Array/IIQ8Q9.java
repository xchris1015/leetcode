package Array;

public class IIQ8Q9 {

    //Q9: L48 2D matrix rotate by 90

    private void matrixRotate(int[][] matrix, int offset, int size) {

        if (offset <= 1 || size <= 1) {
            return;
        }

        for (int i = 0 ; i < size - 1 ; i++ ) {
            int temp = matrix[offset][offset + i];
            matrix[offset][offset + i] = matrix[offset + size - 1 - i][offset];
            matrix[offset + size - 1 - i][offset] = matrix[offset + size - 1 - i][offset + size - 1 - i];
            matrix[offset + size - 1 - i][offset + size - 1 - i] = matrix[offset][offset + size - 1 - i];
            matrix[offset][offset + size - 1 - i] = temp;
        }

        matrixRotate(matrix, offset - 1, size - 2);

    }





}
