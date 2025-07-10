package normal.normal_494.impl;

import normal.normal_494.FindTargetSumWays;
import utils.TestUtils;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-07 14:56
 * @Version: 1.0
 */
public class FindTargetSumWaysImpl implements FindTargetSumWays {
    @Override
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int[][] dp = new int[nums.length + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }

        return dp[nums.length][neg];
    }

    public static void main(String[] args) {
        TestUtils.test(FindTargetSumWaysImpl.class, new int[]{1, 1, 1, 1, 1}, 3);
    }
}
