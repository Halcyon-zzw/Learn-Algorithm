package old.offer.offer_66.impl;

import old.offer.offer_66.ConstructArr;
import utils.TestUtils;

/**
 * 代码优化
 *
 * 前n个数的乘积pre[n]    [0, n]
 * 后n个数的乘积post[n]   [n, length - 1]
 *
 * result = pre[n - 1] * post[n + 1]
 *
 * @Author: zhuzw
 * @Date: 2021-04-27 16:54
 * @Version: 1.0
 */
public class ConstructArrOptImpl implements ConstructArr {
    @Override
    public int[] constructArr(int[] a) {
        if (a == null || a.length < 2) {
            return new int[0];
        }
        int[] result = new int[a.length];
        //计算左上角
        result[0] = 1;
        for (int i = 1; i < a.length; i++) {
            result[i] = result[i - 1] * a[i - 1];
        }
        int temp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            //右上角
            temp *= a[i + 1];
            //结果
            result[i] *= temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Class clazz = ConstructArrOptImpl.class;
        TestUtils.test(clazz, new int[]{1, 2, 3, 4, 5});
    }
}
