package offer.offer_60.impl;

import offer.offer_60.DicesProbability;
import utils.TestUtils;

import java.util.Arrays;

/**
 * dp[n] = dp[n - 1] * 第n个筛子的概率 ）(相同点数概率需要相加)
 *
 * @Author: zhuzw
 * @Date: 2021-04-26 14:56
 * @Version: 1.0
 */
public class DicesProbabilityByDynamicImpl implements DicesProbability {
    @Override
    public double[] dicesProbability(int n) {
        if (n == 0) {
            return new double[0];
        }
        double[] dp = new double[6];
        Arrays.fill(dp, 1 / 6.0);
        for (int i = 1; i < n; i++) {
            double[] nextDp = new double[5 * (i + 1) + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    nextDp[j + k] += dp[j] / 6.0;
                }
            }
            dp = nextDp;
        }
        return dp;
    }

    public static void main(String[] args) {
        Class thisClass = DicesProbabilityByDynamicImpl.class;
        TestUtils.test(thisClass, 3);
    }
}
