package interview.interview_0108.impl;

import interview.interview_0108.Zeroes;

import java.util.HashSet;
import java.util.Set;

/**
 * O(1)空间
 *
 * 使用第一行和第一列保存本行本列是否存在0
 * 同时使用两个标记标记第一行和第一列
 *
 * @Author: zhuzw
 * @Date: 2021-06-21 14:04
 * @Version: 1.0
 */
public class ZeroesByO1Impl implements Zeroes {
    @Override
    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int row = matrix.length, cell = matrix[0].length;
        boolean firstRowExistZero = false, firstCellExistZero = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                firstCellExistZero = true;
                break;
            }
        }
        for (int i = 0; i < cell; i++) {
            if (matrix[0][i] == 0) {
                firstRowExistZero = true;
                break;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cell; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            if (i == 0 && !firstRowExistZero) {
                break;
            }
            for (int j = cell - 1; j >= 0; j--) {
                if (j == 0 && !firstCellExistZero) {
                    break;
                }
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        ZeroesByO1Impl zeroesByO1 = new ZeroesByO1Impl();
        zeroesByO1.setZeroes(arr);
    }
}
