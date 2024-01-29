package hot.矩阵;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 示例 1：
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 * 示例 2：
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 * @author zhuzhiwei
 * @date 2023/12/22 18:37
 */
public class Hot_73_矩阵置零 {
    public void setZeroes(int[][] matrix) {
        setZeroes1(matrix);
    }

    /**
     * 使用标记数组
     * 列数组记录对应的列是否存在0
     * 行数组记录对应的行是否存在0
     *
     * @param matrix
     */
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] cellZeroFlagArr = new boolean[n];
        boolean[] rowZeroFlagArr = new boolean[m];


        //使用第一列、第一行记录是否存在0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    cellZeroFlagArr[j] = true;
                    rowZeroFlagArr[i] = true;
                }
            }
        }
        //置0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowZeroFlagArr[i] || cellZeroFlagArr[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 使用两个标记记录第一行和第一列是否存在0
     * 第一行记录对应的列是否存在0
     * 第一列记录对应的行是否存在0
     *
     * 再使用行标识、列标识处理第一行和第一列
     *
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean rowZeroFlag = false, cellZeroFlag = false;
        //遍历第一行
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                rowZeroFlag = true;
            }
        }
        //遍历第一列
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                cellZeroFlag = true;
            }
        }

        //使用第一列、第一行记录是否存在0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //置0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //处理第一行
        if (rowZeroFlag) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        //处理第一列
        if (cellZeroFlag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
