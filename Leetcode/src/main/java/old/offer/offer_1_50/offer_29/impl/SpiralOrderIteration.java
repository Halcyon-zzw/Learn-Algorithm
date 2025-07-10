package old.offer.offer_1_50.offer_29.impl;

import old.offer.offer_1_50.offer_29.SpiralOrder;

/**
 * 迭代实现
 *
 * @Author: zhuzw
 * @Date: 2021-04-21 14:00
 * @Version: 1.0
 */
public class SpiralOrderIteration implements SpiralOrder {
    @Override
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) {
            return new int[0];
        }
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int i, j, index = 0;
        int[] resultArr = new int[matrix.length * matrix[0].length];
        while (true) {
            for (j = left; j <= right; j++) {
                resultArr[index++] = matrix[top][j];
            }
            if (top++ >= bottom) {
                break;
            }
            for (i = top; i <= bottom; i++) {
                resultArr[index++] = matrix[i][right];
            }
            if (left >= right--) {
                break;
            }
            for (j = right; j >= left; j--) {
                resultArr[index++] = matrix[bottom][j];
            }
            if (top >= bottom--) {
                break;
            }
            for (i = bottom; i >= top; i--) {
                resultArr[index++] = matrix[i][left];
            }
            if (left++ >= right) {
                break;
            }
        }
        return resultArr;
    }
}
