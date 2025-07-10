package old.offer.offer_1_50.offer_40;

import java.util.PriorityQueue;

/**
 * 通过PriorityQueue实现
 *
 * @Author: zhuzw
 * @Date: 2021-04-22 18:12
 * @Version: 1.0
 */
public class GetLeastNumbersByPriorityQueueImpl implements GetLeastNumbers {
    @Override
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] resultArr = new int[k];

        if (k == 0 || arr == null || arr.length == 0) {
            return resultArr;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            resultArr[index++] = priorityQueue.poll();
        }
        return resultArr;
    }
}
