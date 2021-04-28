package offer.offer_63.impl;

import offer.offer_63.MaxProfit;

/**
 * 买卖一次最大值
 *
 * 动态规划：
 *      dp[i] = max(dp[i - 1], prices[i] - minPrices)
 *      dp[0] = 0;
 *
 * @Author: zhuzw
 * @Date: 2021-04-27 15:24
 * @Version: 1.0
 */
public class MaxProfitOnceImpl implements MaxProfit {
    @Override
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int dp = 0, minPrices = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrices = Math.min(minPrices, prices[i]);
            dp = Math.max(dp, prices[i] - minPrices);
        }
        return dp;
    }
}
