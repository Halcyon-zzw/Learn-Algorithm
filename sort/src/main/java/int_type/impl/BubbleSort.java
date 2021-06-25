package int_type.impl;

import int_type.SortInterface;

/**
 * 冒泡排序
 *
 * @Author: zhuzw
 * @Date: 2021-05-10 17:18
 * @Version: 1.0
 */
public class BubbleSort implements SortInterface {
    @Override
    public void apply(int[] arr) {
        //控制趟数
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length -1 - i; j ++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }
}
