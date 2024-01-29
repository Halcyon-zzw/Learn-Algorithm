package hot.堆;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 提示：
 * 1 <= nums.length <= 10^5
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 *
 * @author zhuzhiwei
 * @date 2024/1/5 17:25
 */
public class Hot_347_前K个高频元素 {
    /**
     * 方法一：堆
     *
     *
     * 方法二：桶排序法
     * 统计每个元素出现的频率；
     * 将元素出现的频率作为数组的下标，存到对应的数组中；
     * 取数组最后的几个数字
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] resultArr = new int[k];
        //频次 -> 对应的值
        Map<Integer, List<Integer>> countValueMap = new HashMap<>();
        map.forEach((num, count) -> {
            if (!countValueMap.containsKey(count)) {
                countValueMap.put(count, new ArrayList<>());
            }
            countValueMap.get(count).add(num);
        });
        int index = 0;
        for (int i = nums.length; i > 0; i--) {
            if (index >= k) {
                break;
            }
            if (countValueMap.containsKey(i)) {
                List<Integer> valueList = countValueMap.get(i);
                for (Integer num : valueList) {
                    resultArr[index++] = num;
                }

            }
        }
        return resultArr;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //维护小堆顶
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (map.get(key) > map.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }
        int[] resultArr = new int[k];
        while (!priorityQueue.isEmpty()) {
            resultArr[--k] = priorityQueue.remove();
        }
        return resultArr;
    }
}
