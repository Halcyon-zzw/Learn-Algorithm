package interview.interview_0811.impl;

import interview.interview_0811.WayToChange;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-05-29 9:22
 * @Version: 1.0
 */
public class WayToChangeByNamicImpl implements WayToChange {
    @Override
    public int waysToChange(int n) {
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] arr = {25, 10, 5, 1};
        for (int i = 0; i < arr.length; i++) {
            int coin = arr[i];
            for (int j = coin; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % mod;
            }
        }
        return dp[n];
    }
}
