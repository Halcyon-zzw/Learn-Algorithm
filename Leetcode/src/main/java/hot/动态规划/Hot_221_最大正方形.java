package hot.动态规划;

/**
 * 221. 最大正方形
 * 中等
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * 示例 1：
 * 输入：matrix = [
 *      ["1","0","1","0","0"],
 *      ["1","0","1","1","1"],
 *      ["1","1","1","1","1"],
 *      ["1","0","0","1","0"]]
 * 输出：4
 *
 *  示例 2：
 * 输入：matrix = [
 *      ["0","1"],
 *      ["1","0"]]
 * 输出：1
 *
 * 示例 3：
 * 输入：matrix = [["0"]]
 * 输出：0
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 *
 * @author zhuzhiwei
 * @date 2024/4/23 16:03
 */
public class Hot_221_最大正方形 {
    /**
     * 动态规划
     *
     * dp[i][j]表示以i,j为正方形右下角的最大边长
     *
     * 如果matrix[i][j] == 0，则dp[i][j] = 0(构成不了正方形)
     * 如果matrix[i][j] == 1，若以i,j为右下角需要构成正方形，取决于右上角、上方、左方的结果
     *      dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
     *
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //预处理第一行和第一列，可以减少边界值的判断
        int[][] dp = new int[m + 1][n + 1];
        int maxSide = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    int min = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                    dp[i][j] = Math.min(dp[i][j - 1], min) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        char[][] arr = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int i = new Hot_221_最大正方形().maximalSquare(arr);

    }
}
