package normal.normal_633.impl;

import normal.normal_633.JudgeSquareSum;

/**
 * 遍历实现
 * 超时
 *
 * @Author: zhuzw
 * @Date: 2021-04-28 15:48
 * @Version: 1.0
 */
public class JudgeSquareSumTraverseImpl implements JudgeSquareSum {
    /**
     * 超时
     * @param c
     * @return
     */
    @Override
    public boolean judgeSquareSum(int c) {
        for (int i = 0; i <= Math.sqrt(c); i++) {
            for (int j = 0; j <= Math.sqrt(c); j++) {
                long temp = i * i + j * j;
                if (temp == c) {
                    return true;
                }else if (temp > c) {
                    break;
                }
            }
        }
        return false;
    }
}
