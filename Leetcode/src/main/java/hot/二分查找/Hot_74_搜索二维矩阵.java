package hot.二分查找;

import hot.链表.Hot_21_合并两个有序链表;
import mode.ListNode;

/**
 * 74. 搜索二维矩阵
 *
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 *
 * @author zhuzhiwei
 * @date 2023/12/15 17:15
 */
public class Hot_74_搜索二维矩阵 {
    /**
     * 先找到行，再找列
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        //找到需要查找的行
        int rowI = 0, rowJ = matrix.length - 1;
        //找出[0]不大于target的最大行
        while (rowI < rowJ) {
            int mod = (rowJ - rowI) / 2 + rowI + 1;
            if (matrix[mod][0] <= target) {
                rowI = mod;
            } else {
                rowJ = mod - 1;
            }
        }
        //找到需要查找的列
        int cellI = 0, cellJ = matrix[0].length - 1;

        while (cellI <= cellJ) {
            int mod = (cellI + cellJ) / 2;
            if (matrix[rowI][mod] == target) {
                return true;
            } else if (matrix[rowI][mod] > target) {
                cellJ = mod - 1;
            } else {
                cellI = mod + 1;
            }
        }
        return false;
    }

    /**
     * 一次遍历
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = m * n - 1;
        while (i <= j) {
            int mod = (i + j) / 2;
            int row = mod / n, col = mod % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                j = mod - 1;
            } else {
                i = mod + 1;
            }
        }
        return false;
    }

        public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 13;
        boolean flag = new Hot_74_搜索二维矩阵().searchMatrix(matrix, target);
        System.out.println(flag);
    }
}
