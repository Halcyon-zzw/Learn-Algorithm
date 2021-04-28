package offer.dynamic.offer_47;

/**
 * f(i, j) = max(f(i - 1, j), f(i, j - 1))
 *
 * 初始f(0, j) = grid(0, j), f()
 *
 * @Author: zhuzw
 * @Date: 2021-04-23 16:35
 * @Version: 1.0
 */
public class MaxValueDynamicImpl implements MaxValue {
    @Override
    public int maxValue(int[][] grid) {
        int[][] valArr = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    valArr[0][0] = grid[0][0];
                    continue;
                }
                if (i == 0) {
                    valArr[i][j] += valArr[i][j - 1] + grid[i][j];
                }else if (j == 0) {
                    valArr[i][j] += valArr[i - 1][j] + grid[i][j];
                }else {
                    valArr[i][j] = Math.max(valArr[i - 1][j], valArr[i][j - 1]) + grid[i][j];
                }
            }
        }
        return valArr[grid.length - 1][grid[0].length - 1];
    }
}
