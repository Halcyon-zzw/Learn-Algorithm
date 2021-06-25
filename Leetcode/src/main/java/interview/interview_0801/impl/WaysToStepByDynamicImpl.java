package interview.interview_0801.impl;

import interview.interview_0801.WaysToStep;

/**
 * <p>
 *     思路：
 *     到达第i阶的方式有：
 *          到达i - 1后，一次迈一步
 *          到达i - 2后，一次迈两步
 *          到达i - 3后，一次迈三步
 *     dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
 *
 *     初始：
 *          dp[1] = 1   1
 *          dp[2] = 2   1、1     2
 *          dp[3] = 4   1、1、1   1、2      2、1    3
 * </p>
 *
 * @Author: zhuzw
 * @Date: 2021-05-25 10:13
 * @Version: 1.0
 */
public class WaysToStepByDynamicImpl implements WaysToStep {
    @Override
    public int waysToStep(int n) {
        if (1 == n) {
            return 1;
        }else if (2 == n) {
            return 2;
        }else if (3 == n) {
            return 4;
        }
        int MOD = 1000000007;
        int a = 1, b = 2, c = 4, result = 0;

        for (int i = 4; i <= n; i++) {
            result = ((a + b) % MOD + c) % MOD;
            a = b;
            b = c;
            c = result;
        }
        return result;
    }
}
