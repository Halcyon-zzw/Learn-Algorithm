package hot.动态规划;

/**
 * 63. 不同路径 II
 * 中等
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 示例 1：
 * 输入：obstacleGrid = [
 *      [0,0,0],
 *      [0,1,0],
 *      [0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 示例 2：
 * 输入：obstacleGrid =[
 *      [0,1],
 *      [0,0]]
 * 输出：1
 *
 * 提示：
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 *
 * @author zhuzhiwei
 * @date 2024/4/16 17:30
 */
public class Hot_63_不同路径II {
    /**
     * 动态规划
     *
     * dp[i][j]表示从起点到obstacleGrid[i][j]的路径数量
     *
     * 转移方程：
     * dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
     *      1、obstacleGrid[i][j] == 1
     *          dp[i][j] = 0
     *      2、i == 0
     *          dp[i][j] = dp[i][j - 1]
     *      3、j == 0
     *          dp[i][j] = dp[i - 1][j]
     *      else
     *          dp[i][j - 1] + dp[i - 1][j]
     *
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
