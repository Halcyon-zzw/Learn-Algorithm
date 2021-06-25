package interview.interview_0501.impl;

import interview.interview_0501.InsertBits;
import utils.TestUtils;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-23 17:19
 * @Version: 1.0
 */
public class InsertBitsImpl implements InsertBits {
    @Override
    public int insertBits(int N, int M, int i, int j) {
        //不用直接移动(j + 1),但j=31时，直接移动无效，需要先移动j再移动1
        int left = N >> j >> 1 << (j + 1);  // int left = j == 31 ? 0 : N >> (j + 1) << (j + 1)
        int right = ((1 << i) - 1) & N;
        int mid = M << i;
        return left | right | mid;
    }

    public static void main(String[] args) {
        TestUtils.test(InsertBitsImpl.class,1143207437,
                1017033,
                11,
                31);
    }
}
