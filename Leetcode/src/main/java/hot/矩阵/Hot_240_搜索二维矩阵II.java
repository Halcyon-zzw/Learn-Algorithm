package hot.矩阵;

/**
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * @author zhuzhiwei
 * @date 2023/12/22 19:11
 */
public class Hot_240_搜索二维矩阵II {
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix1(matrix, target);
    }

    /**
     * 每一行使用二分查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (searchMatrix(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    private boolean searchMatrix(int[] matrix, int target) {
        int i = 0, j = matrix.length - 1;
        while (i <= j) {
            int mod = (j - i) / 2 + i;
            if (matrix[mod] == target) {
                return true;
            } else if (matrix[mod] > target) {
                j = mod - 1;
            } else {
                i = mod + 1;
            }
        }
        return false;
    }

    /**
     * 以右上角开始查找。右上角特征：左边都小于该值，下边都大于该值
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
