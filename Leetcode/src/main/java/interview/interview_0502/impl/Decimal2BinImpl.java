package interview.interview_0502.impl;

import interview.interview_0502.Decimal2Bin;
import utils.TestUtils;

/**
 * 实现：
 *      不断*2直到小数为0，每次取小数部分
 *
 * @Author: zhuzw
 * @Date: 2021-05-24 14:11
 * @Version: 1.0
 */
public class Decimal2BinImpl implements Decimal2Bin {
    @Override
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        int count = 0;
        while (num != 0) {
            num *= 2;
            if (num >= 1) {
                sb.append("1");
                num -= 1;
            }else {
                sb.append("0");
            }
            if (count++ > 32) {
                return "ERROR";
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TestUtils.test(Decimal2BinImpl.class, 0.2);
    }
}
