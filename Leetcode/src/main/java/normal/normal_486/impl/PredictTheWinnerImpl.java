package normal.normal_486.impl;

import normal.normal_486.PredictTheWinner;

/**
 * 待完善
 *
 * @Author: zhuzw
 * @Date: 2021-06-16 14:17
 * @Version: 1.0
 */
public class PredictTheWinnerImpl implements PredictTheWinner {
    @Override
    public boolean predictTheWinner(int[] nums) {
        if (nums == null) {
            return false;
        }
        int length = nums.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;
    }
}
