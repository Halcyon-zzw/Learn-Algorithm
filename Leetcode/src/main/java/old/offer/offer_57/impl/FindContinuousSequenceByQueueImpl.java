package old.offer.offer_57.impl;

import old.offer.offer_57.FindContinuousSequence;
import utils.TestUtils;

import java.util.*;

/**
 * 和为s的连续正数序列
 *
 * 滑动窗口实现
 *
 * @Author: zhuzw
 * @Date: 2021-04-25 20:09
 * @Version: 1.0
 */
public class FindContinuousSequenceByQueueImpl implements FindContinuousSequence {
    @Override
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int num = 1;
        //因为结果至少两个，所以遍历此需要终止
        while (num <= (target / 2 + 1) ) {
            deque.addLast(num++);
            if (deque.size() > 1) {
                //计算和
                int sum = sumDeque(deque);
                if (sum == target) {
                    result.add(new ArrayList<>(deque));
                    deque.removeFirst();
                }else if (sum < target) {
                    continue;
                }else {
                    while (sum > target) {
                        deque.removeFirst();
                        sum = sumDeque(deque);
                        if (sum == target) {
                            result.add(new ArrayList<>(deque));
                            deque.removeFirst();
                        }
                    }
                }
            }
        }
        int[][] resultArr = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            int[] arr = new int[result.get(i).size()];
            for (int j = 0; j < result.get(i).size(); j++) {
                arr[j] = result.get(i).get(j);
            }
            resultArr[i] = arr;
        }
        return resultArr;
    }

    private int sumDeque(Deque<Integer> deque) {
        return  (deque.getFirst() + deque.getLast()) * deque.size() / 2;
    }

    public static void main(String[] args) {
        TestUtils.test(FindContinuousSequenceByQueueImpl.class, 9);
    }
}
