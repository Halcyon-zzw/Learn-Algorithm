package hot.动态规划;

/**
 * 279. 完全平方数
 * 中等
 * 给你一个整数 n ，返回和为 n 的完全平方数的最少数量。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 示例 1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 *
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *
 * @author zhuzhiwei
 * @date 2024/2/21 22:10
 */
public class Hot_279_完全平方数 {
    /**
     * n = n - j * j
     * dp[n] = min(dp[n - j * j] + 1), 1 <= j <= sqrt(n)
     * dp[0] = 0
     * dp[1] = 1
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = i;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int numSquares = new Hot_279_完全平方数().numSquares(12);
        System.out.println(numSquares);
    }
}
