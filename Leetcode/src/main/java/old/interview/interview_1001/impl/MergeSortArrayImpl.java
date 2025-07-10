package interview.interview_1001.impl;

import interview.interview_1001.MergeSortArray;

import java.util.*;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-05-31 15:41
 * @Version: 1.0
 */
public class MergeSortArrayImpl implements MergeSortArray {
    @Override
    public void merge(int[] A, int m, int[] B, int n) {
        int index = m + n - 1, max;
        m--;
        n--;
        while (n >= 0) {
//            if (m < 0) {
//                A[index--] = B[n--];
//            }else {
//                A[index--] = A[m] >= B[n] ? A[m--] : B[n--];
//            }
            A[index--] = (m >= 0 && A[m] >= B[n]) ? A[m--] : B[n--];
        }
    }
}
