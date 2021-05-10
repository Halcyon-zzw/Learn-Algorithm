package int_type.impl;

import int_type.SortInterface;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-05-08 13:54
 * @Version: 1.0
 */
public class QuickSort implements SortInterface {
    @Override
    public void apply(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
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
