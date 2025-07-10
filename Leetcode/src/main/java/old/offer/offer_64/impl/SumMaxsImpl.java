package old.offer.offer_64.impl;

import old.offer.offer_64.SumMaxs;

/**
 * 公式实现
 *
 * @Author: zhuzw
 * @Date: 2021-04-27 16:18
 * @Version: 1.0
 */
public class SumMaxsImpl implements SumMaxs {
    @Override
    public int sumNums(int n) {
        return (1 + n) * n / 2;
    }
}
