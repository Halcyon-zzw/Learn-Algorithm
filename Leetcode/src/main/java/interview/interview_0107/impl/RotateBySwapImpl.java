package interview.interview_0107.impl;

import interview.interview_0107.Rotate;
import utils.TestUtils;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-21 11:16
 * @Version: 1.0
 */
public class RotateBySwapImpl implements Rotate {
    @Override
    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int n = matrix.length;
        int row = n / 2, cell = (n + 1) / 2;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cell; j++) {
                swap(matrix, i, j, j, n - 1 - i);
                swap(matrix, i, j, n - 1 - i, n - 1 - j);
                swap(matrix, i, j, n - 1 - j, i);
            }
        }
    }

    private void swap(int[][] matrix, int oldRow, int oldCell, int newRow, int newCell) {
        int temp = matrix[oldRow][oldCell];
        matrix[oldRow][oldCell] = matrix[newRow][newCell];
        matrix[newRow][newCell] = temp;
    }

    public static void main(String[] args) {
        int[][] arr = {{5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}};
        RotateBySwapImpl rotateBySwap = new RotateBySwapImpl();
        rotateBySwap.rotate(arr);
    }
}
