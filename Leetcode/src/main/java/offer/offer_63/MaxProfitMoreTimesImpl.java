package offer.offer_63;

import utils.TestUtils;

/**
 * 交易多次最大值
 * 贪心实现:收割所有差价
 *
 * @Author: zhuzw
 * @Date: 2021-04-27 15:49
 * @Version: 1.0
 */
public class MaxProfitMoreTimesImpl implements MaxProfit {
    @Override
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Class clazz = MaxProfitMoreTimesImpl.class;
        TestUtils.test(clazz, new int[]{7,1,5,3,6,4});
    }
}
