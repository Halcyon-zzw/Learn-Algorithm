package old.offer.offer_64.impl;

import old.offer.offer_64.SumMaxs;

/**
 * 递归实现
 *
 * 短路实现终止条件
 *
 * @Author: zhuzw
 * @Date: 2021-04-27 16:20
 * @Version: 1.0
 */
public class SumMaxsByRecursionImpl implements SumMaxs {
    @Override
    public int sumNums(int n) {
        // n = 1 时，短路，直接返回n(1)
        boolean a = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
