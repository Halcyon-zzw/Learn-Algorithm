package offer.offer_66.impl;

import offer.offer_66.ConstructArr;
import utils.TestUtils;

/**
 * 便于理解
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
public class ConstructArrImpl implements ConstructArr {
    @Override
    public int[] constructArr(int[] a) {
        if (a == null || a.length < 2) {
            return new int[0];
        }
        int[] pre = new int[a.length];
        int[] post = new int[a.length];
        int[] result = new int[a.length];

        pre[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            pre[i] = pre[i - 1] * a[i];
        }
        post[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            post[i] = post[i + 1] * a[i];
        }
        for (int i = 1; i < a.length - 1; i++) {
            result[i] = pre[i - 1] * post[i + 1];
        }
        result[0] = post[1];
        result[a.length - 1] = pre[a.length - 2];
        return result;
    }

    public static void main(String[] args) {
        Class clazz = ConstructArrImpl.class;
        TestUtils.test(clazz, new int[]{1, 2, 3, 4, 5});
    }
}
