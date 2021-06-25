package int_type.impl;

import int_type.SortInterface;

/**
 * 选择排序
 *
 * @Author: zhuzw
 * @Date: 2021-05-10 17:19
 * @Version: 1.0
 */
public class SelectSort implements SortInterface {
    @Override
    public void apply(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j ++) {
                if (arr[j] < min) {
                    int t = min;
                    min = arr[j];
                    arr[j] = t;
                }
            }
            arr[i] = min;
        }
    }
}
