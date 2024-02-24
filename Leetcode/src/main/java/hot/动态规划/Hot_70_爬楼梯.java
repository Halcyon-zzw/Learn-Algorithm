package hot.动态规划;

/**
 * 70. 爬楼梯
 * 简单
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 * 提示：
 * 1 <= n <= 45
 *
 * Related Topics
 * 记忆化搜索
 * 数学
 * 动态规划
 *
 *
 * @author zhuzhiwei
 * @date 2024/2/21 22:10
 */
public class Hot_70_爬楼梯 {
    /**
     * n = 1 => 1
     * n = 2 => 2
     * n = 3 => 先到达1走两步 或者 先到达2走一步，及dp[3] = dp[1] + dp[2]
     * n > 3 => dp[n] = dp[n - 1] + dp[n - 2]
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int dp = 0, dp1 = 1, dp2 = 2;
        for (int i = 3; i <= n; i++) {
            dp = dp1 + dp2;
            dp1 = dp2;
            dp2 = dp;
        }
        return dp;
    }

    public int climbStairs2(int n) {

        int dp = 0, dp1 = 0, dp2 = 1;
        for (int i = 1; i <= n; i++) {
            dp = dp1 + dp2;
            dp1 = dp2;
            dp2 = dp;
        }
        return dp;
    }
}
