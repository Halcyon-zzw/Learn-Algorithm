package offer.offer_57.impl;

import offer.offer_57.FindContinuousSequence;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的连续正数序列
 *
 * 双指针实现
 *
 * sum = (l + r) * (r - l + 1) / 2      （首项 + 末项） * 项数 / 2
 *
 * @Author: zhuzw
 * @Date: 2021-04-25 20:42
 * @Version: 1.0
 */
public class FindContinuousSequenceByDoublePointerImpl implements FindContinuousSequence {
    @Override
    public int[][] findContinuousSequence(int target) {
        int l = 1, r = 2, sum = 0;
        List<int[]> list = new ArrayList<>();
        while (l < r) {
            sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                add(list, l, r);
                l++;
            }else if (sum < target) {
                r++;
            }else {
                l++;
            }

        }
        return list.toArray(new int[list.size()][]);
    }

    private void add(List<int[]> list, int l, int r) {
        int[] arr = new int[r - l + 1];
        int index = 0;
        for (int i = l; i <= r; i++) {
            arr[index++] = i;
        }
        list.add(arr);
    }

    public static void main(String[] args) {
        TestUtils.test(FindContinuousSequenceByDoublePointerImpl.class, 9);
    }
}
