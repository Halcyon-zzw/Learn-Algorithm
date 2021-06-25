package interview.interview_0504.impl;

import interview.interview_0504.FindClosedNumbers;
import utils.TestUtils;

/**
 * 实现逻辑：
 * <p>
 *     通过分析二进制：（从右往左）
 *     略大数是将第一个1、0值交换；
 *     略小数是将第一个0、1值交换
 *
 * </p>
 *
 * @Author: zhuzw
 * @Date: 2021-05-24 14:29
 * @Version: 1.0
 */
public class FindClosedNumbersByBitImpl implements FindClosedNumbers {
    @Override
    public int[] findClosedNumbers(int num) {

        int next = getNext(num);
        int pre = getPre(num);
        return new int[]{next, pre};
    }

    private int getNext(int num) {
        //p：需要翻转的0的位置   oneCount：p后面1的个数
        int p = 0, oneCount = 0, temp = num;
        //找到非结尾的0
        while ((temp & 1) == 0) {
            p++;
            temp >>= 1;
        }
        while ((temp & 1) == 1) {
            p++;
            oneCount++;
            temp >>= 1;
        }
        if (oneCount >= 31) {
            return -1;
        }
        //翻转p位置的1
        int tempP = 1 << p;
        num = num | tempP;
        //p后边置0
        num = num & ~(tempP - 1);
        //p后边转oneCount个1
        temp = 1 << (oneCount - 1);
        num = num | (temp - 1);

        return num;
    }

    private int getPre(int num) {
        //p：需要翻转的1的位置   oneCount：p后面1的个数
        int p = 0, oneCount = 0, temp = num;
        //找到非结尾的1
        while ((temp & 1) == 1) {
            p++;
            oneCount++;
            temp >>= 1;
        }
        while ((temp & 1) == 0) {
            p++;
            temp >>= 1;
            if (p > 32) {
                return -1;
            }
        }
        if (p > 32) {
            return -1;
        }
        //翻转p位置的0
        int tempP = 1 << p;
        num = num & ~tempP;
        //p后面置0
        num = num & ~(tempP - 1);
        //p后边置oneCount + 1个1
        tempP = tempP - 1;
        int moveCount = p - oneCount - 1;
        tempP = tempP >> moveCount << moveCount;
        num = num | tempP;

        return num;
    }

    public static void main(String[] args) {
        TestUtils.test(FindClosedNumbersByBitImpl.class, 2147483647);
        int i = waysToStep(1);
        System.out.println(i);
    }


    public static int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }else if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2]) % 1000000007 + dp[i - 1];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

}


