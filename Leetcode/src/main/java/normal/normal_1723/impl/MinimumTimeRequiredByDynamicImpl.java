package normal.normal_1723.impl;

import normal.normal_1723.MinimumTimeRequired;
import utils.TestUtils;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 错误答案
 *
 * @Author: zhuzw
 * @Date: 2021-05-08 11:19
 * @Version: 1.0
 */
public class MinimumTimeRequiredByDynamicImpl implements MinimumTimeRequired {

    public static void main(String[] args) {
        Class clazz = MinimumTimeRequiredByDynamicImpl.class;
        TestUtils.test(clazz, new int[]{3, 2, 3}, 3);
    }

    @Override
    public int minimumTimeRequired(int[] jobs, int k) {
        //排序
        sort(jobs);

        //维护堆，最大的放在最小的堆上（因为堆是最大的在上面，所以堆中的值需要取负维护）
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            queue.offer(0);
        }
        int j = jobs.length - 1;
        while (j >= 0) {
            Integer poll = queue.poll();
            queue.offer(poll + jobs[j]);
            j--;
        }
        int pool = 0;
        while (!queue.isEmpty()) {
            pool = queue.poll();
        }
        //返回堆顶取负数据
        return pool;
    }

    private void sort(int[] jobs) {
        quickSort(jobs, 0, jobs.length -1);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int index = adjustArr(arr, l, r);
            quickSort(arr, l, index);
            quickSort(arr, index + 1, r);
        }

    }

    private int adjustArr(int[] arr, int l, int r) {
        int x = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= x) {
                r--;
            }
            if (l < r) {
                arr[l] = arr[r];
                l++;
            }
            while (l < r && arr[l] <= x) {
                l++;
            }
            if (l < r) {
                arr[r] = arr[l];
                r--;
            }
        }
        arr[l] = x;
        return l;
    }

}
