package interview.interview_0108.impl;

import interview.interview_0108.Zeroes;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-21 13:50
 * @Version: 1.0
 */
public class ZeroesImpl implements Zeroes {
    @Override
    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> cellSet = new HashSet<>();
        int row = matrix.length, cell = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cell; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    cellSet.add(j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cell; j++) {
                if (rowSet.contains(i) || cellSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
