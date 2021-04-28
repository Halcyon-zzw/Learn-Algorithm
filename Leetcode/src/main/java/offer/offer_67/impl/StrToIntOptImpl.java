package offer.offer_67.impl;

import offer.offer_67.StrToInt;
import utils.TestUtils;

/**
 * -21 4748 3648 到 2^31-1=21 4748 3647
 *
 * 边界 bndry = 2147483647 // 10 = 214748364 bndry=2147483647//10=214748364
 * 判断拼接后的值
 * if res > bndry || (res==bndry && val > 7) 超过边界；通过符号判断返回的值
 *
 * @Author: zhuzw
 * @Date: 2021-04-27 18:02
 * @Version: 1.0
 */
public class StrToIntOptImpl implements StrToInt {

    @Override
    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int index = 0, sign = 1, res = 0, bndry = Integer.MAX_VALUE / 10;
        while (str.charAt(index) == ' ') {
            index++;
            if (index == str.length()) {
                return 0;
            }
        }
        char c = chars[index];
        if (c == '-') {
            index++;
            sign = -1;
        }else if (c == '+') {
            index++;
        }
        while (index < str.length()) {
            c = str.charAt(index++);
            if (c < '0' || c > '9') {
                break;
            }
            int cur = c - '0';
            //判断是否越界，不能判断最后的结果。如果越界，值不能标识。在相加前判断
            if (res > bndry || (res == bndry && cur > 7)) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                }else {
                    return Integer.MIN_VALUE;
                }
            }
            res = 10 * res + cur;
        }
        return res * sign;
    }

    public static void main(String[] args) {
        Class<StrToIntOptImpl> clazz = StrToIntOptImpl.class;
        TestUtils.test(clazz, "42");

    }
}
