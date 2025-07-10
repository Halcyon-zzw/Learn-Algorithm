package interview.interview_0107.impl;

import interview.interview_0107.Rotate;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-18 17:29
 * @Version: 1.0
 */
public class RotateImpl implements Rotate {
    @Override
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] tempArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tempArr[i][j] = matrix[i][j];
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                matrix[j][n - i - 1] = tempArr[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        RotateImpl rotate = new RotateImpl();
        rotate.rotate(arr);
    }
}
