package offer.offer_62.impl;

import offer.offer_62.LastRemaining;

/**
 * f(n, m) = (f(n - 1, m) + m) % n  , n > 1
 *            0  ,  n = 0
 * 参考资料：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/#comment
 * @Author: zhuzw
 * @Date: 2021-04-27 14:59
 * @Version: 1.0
 */
public class LastRemainingDynamicImpl implements LastRemaining {
    @Override
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
