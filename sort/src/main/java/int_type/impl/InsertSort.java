package int_type.impl;

import int_type.SortInterface;

/**
 * 插入排序
 *
 * @Author: zhuzw
 * @Date: 2021-05-10 15:26
 * @Version: 1.0
 */
public class InsertSort implements SortInterface {
    @Override
    public void apply(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            //移动
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public void sortIntsertion(int arr[]) {
        if (arr == null) {
            return;
        }
        //只有一个元素时必有序，故从第二个元素开始
        for (int i = 1; i < arr.length; i++) {
            //从有序列表的后面开始比较
            int key = arr[i];
            int j = i - 1;
            for (; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }
            //arr[j] < arr[i] ，故arr[j + 1] = arr[i]
            arr[j + 1] = key;
        }
    }

}
