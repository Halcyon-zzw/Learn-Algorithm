package offer.offer_1_50.offer_11;

/**
 * 旋转数组的最小数字
 *
 * @Author: zhuzw
 * @Date: 2021-04-17 20:27
 * @Version: 1.0
 */
public class MinArray11 {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return  -1;
        }
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    /**
     * 二分法实现
     * @param numbers
     * @return
     */
    public int minArray2(int[] numbers) {
        return doMinArray(numbers, 0, numbers.length - 1);
    }

    private int doMinArray(int[] numbers, int start, int end) {
        if (start == end) {
            return numbers[start];
        }
        int mid = (start + end) / 2;
        if (numbers[mid] > numbers[end]) {
            return doMinArray(numbers, mid + 1, end);
        }else if (numbers[mid] < numbers[end]){
            return doMinArray(numbers, start, mid);
        }else {
            return doMinArray(numbers, start, end - 1);
        }
    }
}
