package hot.矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * @author zhuzhiwei
 * @date 2023/12/22 19:09
 */
public class Hot_54_螺旋矩阵 {
    /**
     * 模拟旋转
     * 从外向内一层一层遍历
     *
     * 考虑特殊情况，最后一行或一列
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = 0;
        List<Integer> resultList = new ArrayList<>();
        while (i < m && j < n) {
            //左 -> 右
            for (int k = j; k < n; k++) {
                resultList.add(matrix[i][k]);
            }
            //上 -> 下
            for (int k = i + 1; k < m; k++) {
                resultList.add(matrix[k][n - 1]);
            }
            //右 -> 左 && 排除和 左->右同行的情况
            for (int k = n - 2; k >= j && m - 1 != i; k--) {
                resultList.add(matrix[m - 1][k]);
            }
            //下 -> 上
            for (int k = m - 2; k >= i + 1 && j != n - 1; k--) {
                resultList.add(matrix[k][j]);
            }
            i++;
            j++;
            m--;
            n--;
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
        };
        new Hot_54_螺旋矩阵().spiralOrder(matrix);
    }
}
