package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-16 10:55
 * @Version: 1.0
 */
public class SearchUtils {


    public static int binarySearch(int[] arr, int searched) {

        return doBbinarySearch(arr, searched, 0, arr.length - 1);
    }

    public static int doBbinarySearch(int[] arr, int searched, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (arr[start] > searched || arr[end] < searched ) {
            return -1;
        }
        int mid = (start + end) / 2;
        int midValue = arr[mid];
        if (searched == midValue) {
            return mid;
        }else if (searched > midValue) {
            return doBbinarySearch(arr, searched, mid + 1, end);
        }else {
            return doBbinarySearch(arr, searched, start, mid - 1);
        }
    }

    public static int[] generateData(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int randomInt = random.nextInt();
            arr[i] = randomInt;
        }
        return arr;
    }

    public static int[] generateOrderlyData(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
