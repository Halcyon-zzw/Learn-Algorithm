/**
 * 均为升序排序
 *
 * @Author: zhuzw
 * @Date: 2021-04-15 9:25
 * @Version: 1.0
 */
public class CollectSort {

    /**
     *
     * @param arr
     */
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

    /**
     * 希尔排序
     * @param arr
     */
    public void hillIntsertion(int arr[]) {

    }


    //冒泡
    public void bubbleSort (int[] arr) {
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

    //选择排序
    public void sortSelect(int[] arr) {

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


    public static void main(String[] args) {
        int[] arr = {3, 2 ,1 ,4, 5};
        CollectSort collectSort = new CollectSort();
        collectSort.sortSelect(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
