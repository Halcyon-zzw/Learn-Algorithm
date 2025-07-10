package old.offer.offer_65.impl;

import old.offer.offer_65.AddWithoutAddition;

/**
 * 二进制相加
 * a(i)     b(i)    无进位     进位
 *  0        0        0         0
 *  0        1        1         0
 *  1        0        1         0
 *  1        1        0         1
 *                   a ^ b      a & b
 *
 * @Author: zhuzw
 * @Date: 2021-04-27 16:38
 * @Version: 1.0
 */
public class AddWithoutAdditionImpl implements AddWithoutAddition {
    @Override
    public int add(int a, int b) {
        //没有进位时停止
        while (b != 0) {
            //无进位
            int withoutCarry = a ^ b;
            int carry = (a & b) << 1;
            a = withoutCarry;
            b = carry;
        }
        return a;
    }
}
