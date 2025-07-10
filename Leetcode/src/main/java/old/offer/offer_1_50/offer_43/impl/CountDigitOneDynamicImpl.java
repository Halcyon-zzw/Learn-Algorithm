package old.offer.offer_1_50.offer_43.impl;

import old.offer.offer_1_50.offer_43.CountDigitOne;

/**
 * 1～n 整数中 1 出现的次数
 *
 * 动态规划实现
 * 思路：
 *  设n的位数为num；
 *  最大num位数1的个数为f(num)
 *  1 - n 中1的个数 = X(n)
 *  推导公式：
 *      f(num) = 10 * f(num - 1) + 10 ^ (n - 1)
 *      解释：10 * f(num - 1)表示num位数0 - 9开头的1的个数
 *          10^(n - 1)表示，num位数1开头的个数
 *      初始状态：f(1) = 1
 *
 *      X(n) = f(n的位数) +
 *
 *
 *
 *
 *
 * @Author: zhuzw
 * @Date: 2021-04-22 20:08
 * @Version: 1.0
 */
public class CountDigitOneDynamicImpl implements CountDigitOne {
    int[] digitArr = null;
    @Override
    public int countDigitOne(int n) {
        if (n == 0) {
            return 0;
        }
        //获取位数
        int digitCount = getDigitCount(n);
        digitArr = getDigitSumOfOneArr(digitCount);
        return recursionCountDigitOne(n);
    }

    private int getHightDigitVal(int n, int digitCount) {
        return (int)(n / Math.pow(10, digitCount - 1));
    }

    private int getDigitCount(int n) {
        int digitCount = 0;
        while (n > 0) {
            n /= 10;
            digitCount++;
        }
        return digitCount;
    }

    private int recursionCountDigitOne(int n) {
        if (n < 10) {
            if (n >= 1) {
                return 1;
            }
            else {
                return 0;
            }
        }
        int count = 0;
        //获取位数
        int digitCount = getDigitCount(n);
        //获得最高位
        int hightDigitVal = getHightDigitVal(n, digitCount);
        //除去最高位的数字
        int nextDigitNum = (int)(n % (Math.pow(10, digitCount - 1)));
        count = hightDigitVal * digitArr[digitCount - 1] + recursionCountDigitOne(nextDigitNum);

        if (hightDigitVal > 1) {
            count += (int)Math.pow(10, digitCount -1);
        }else {
            count += nextDigitNum + 1;
        }
        return count;
    }

    /**
     * 动态规划实现几位数中1出现的个数
     * @return
     */
    private int[] getDigitSumOfOneArr(int disits) {
        int[] disitArr = new int[disits + 1];
        disitArr[1] = 1;
        for (int i = 2; i <= disits; i++) {
            disitArr[i] = disitArr[i - 1] * 10 + (int)Math.pow(10, i -1);
        }
        return disitArr;
    }
}
