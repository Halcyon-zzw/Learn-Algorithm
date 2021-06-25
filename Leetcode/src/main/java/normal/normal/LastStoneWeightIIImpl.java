package normal.normal;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-08 13:53
 * @Version: 1.0
 */
public class LastStoneWeightIIImpl implements LastStoneWeightII {
    @Override
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int[][] dp = new int[n + 1][sum / 2 + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                if (j >= stones[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return sum - dp[n][sum / 2] * 2;
    }
}
