package hot.动态规划;

/**
 *
 * 322. 零钱兑换
 * 中等
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 *
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * @author zhuzhiwei
 * @date 2024/2/21 22:10
 */
public class Hot_322_零钱兑换 {
    /**
     *
     * dp[n] = dp[n - coins[i]] + 1  0 <= i < coins.length
     * dp[0] = 0
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                //-1表示无用通过硬币兑换
                if (i >= coins[j] && dp[i - coins[j]] != -1) {
                    min = Math.min(min, dp[i - coins[j]] + 1);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
    }
}
