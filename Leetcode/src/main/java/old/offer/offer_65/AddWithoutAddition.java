package old.offer.offer_65;

/**
 * 不用加法实现加法运算
 * 二进制相加
 * a(i)     b(i)    无进位     进位
 *  0        0        0         0
 *  0        1        1         0
 *  1        0        1         0
 *  1        1        0         1
 *                   a ^ b     a & b
 * @Author: zhuzw
 * @Date: 2021-04-27 16:34
 * @Version: 1.0
 */
public interface AddWithoutAddition {
    int add(int a, int b);
}
