package interview.interview_0811.impl;

import interview.interview_0811.WayToChange;
import utils.TestUtils;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-05-29 9:12
 * @Version: 1.0
 */
public class WayToChangeByMathImpl implements WayToChange {
    @Override
    public int waysToChange(int n) {
        int mod = 1000000007;
        int count25 = n / 25;
        int count = 0;
        for (int i = 0; i <= count25; i++) {
            int r = n - i * 25;
            int a = r / 10;
            int b = r % 10 / 5;
            count = (count + (int)((long)(a + 1) * (a + b + 1) % mod)) % mod;

//            count = (count + (int) ((long) (a + 1) * (a + b + 1) % mod)) % mod;
        }
        return count;
    }

    public static void main(String[] args) {
        TestUtils.test(WayToChangeByMathImpl.class, 900750);
        TestUtils.test(WayToChangeByNamicImpl.class, 900750);
    }
}
