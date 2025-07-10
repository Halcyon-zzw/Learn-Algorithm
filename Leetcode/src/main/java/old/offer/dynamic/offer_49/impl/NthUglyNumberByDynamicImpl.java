package old.offer.dynamic.offer_49.impl;

import old.offer.dynamic.offer_49.NthUglyNumber;

/**
 * dp(i) = Math.min(min(dp(p2) * 2, dp(p3) * 3), dp(p5) * 5)
 *
 * @Author: zhuzw
 * @Date: 2021-04-23 18:34
 * @Version: 1.0
 */
public class NthUglyNumberByDynamicImpl implements NthUglyNumber {
    @Override
    public int nthUglyNumber(int n) {

        int[] arr = new int[n + 1];
        arr[1] = 1;
        //指向当前最小丑数
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        int num2, num3, num5;
        for (int i = 2; i <= n; i++) {
            num2 = arr[p2] * 2;
            num3 = arr[p3] * 3;
            num5 = arr[p5] * 5;
            arr[i] = Math.min(Math.min(num2, num3), num5);
            //当前丑数相等的丑数向后移动
            if (arr[i] == num2) {
                p2 ++;
            }
            if (arr[i] == num3) {
                p3 ++;
            }
            if (arr[i] == num5) {
                p5 ++;
            }
        }
        return arr[n];
    }
}
