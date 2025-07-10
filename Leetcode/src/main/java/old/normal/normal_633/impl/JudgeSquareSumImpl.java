package normal.normal_633.impl;

import normal.normal_633.JudgeSquareSum;

/**
 * 双指针
 *
 * @Author: zhuzw
 * @Date: 2021-04-28 15:47
 * @Version: 1.0
 */
public class JudgeSquareSumImpl implements JudgeSquareSum {
    @Override
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            long temp = i * i + j * j;
            if (temp == c) {
                return true;
            } else if (temp > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
