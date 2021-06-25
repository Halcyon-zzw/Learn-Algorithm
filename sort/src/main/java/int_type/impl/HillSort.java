package int_type.impl;

import int_type.SortInterface;

/**
 * 希尔排序
 *
 * @Author: zhuzw
 * @Date: 2021-05-10 16:48
 * @Version: 1.0
 */
public class HillSort implements SortInterface {
    @Override
    public void apply(int[] arr) {
        int length = arr.length;
        for (int step = length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                int temp = arr[i];
                int target = i - step;
                while (target >= 0 && arr[target] > temp) {
                    arr[target + step] = arr[target];
                    target -= step;
                }
                arr[target + step] = temp;
            }
        }
    }
}
