package hot.矩阵;

import utils.ArrayUtils;

/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * @author zhuzhiwei
 * @date 2023/12/22 19:10
 */
public class Hot_48_旋转图像 {
    /**
     * 从外向内，一次处理一层
     * 因为数组是n * n，可将每一层按上下左右分为(n - 1)个，
     * 先保存上面的n - 1个数，然后将左边的n-1个数旋转过来。依次处理下面和右边
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        //层数
        int n = matrix.length, level = n / 2;
        int[] tmpNum = new int[matrix.length];
        for (int i = 0; i < level; i++) {
            //暂存
            int count = n - 1 - i * 2;
            for (int k = 0, j = i; k < count; k++, j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        new Hot_48_旋转图像().rotate(matrix);
        System.out.println(ArrayUtils.toString(matrix));
    }
}

//7 4 1
//8 5 2
//9 6 3
//
//1 2 3 4 5
//4 5 6 1 1
//7 8 9 1 1
//1 2 3 4 1
//1 1 1 1 1

//13 9 5 1
//14 10 6 2
//15 11 7 3
//16 12 8 4