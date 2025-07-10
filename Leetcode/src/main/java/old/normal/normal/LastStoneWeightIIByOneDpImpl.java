package normal.normal;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-08 14:12
 * @Version: 1.0
 */
public class LastStoneWeightIIByOneDpImpl implements LastStoneWeightII {
    @Override
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int[] dp = new int[sum / 2 + 1];
        for (int i = 0; i < n; i++) {
            for (int j = sum / 2; j >= 0 ; j--) {
                if (j >= stones[i]) {
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                }
            }

        }
        return sum - dp[sum / 2] * 2;
    }
}
