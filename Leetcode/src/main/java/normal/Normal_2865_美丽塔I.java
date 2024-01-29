package normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 2865. 美丽塔 I
 * 中等
 *
 * 给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。
 * 你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。
 *
 * 如果以下条件满足，我们称这些塔是 美丽 的：
 * 1、1 <= heights[i] <= maxHeights[i]
 * 2、heights 是一个 山脉 数组。
 * 如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山脉 数组：
 *      对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]
 *      对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]
 * 请你返回满足 美丽塔 要求的方案中，高度和的最大值 。
 *
 * 示例 1：
 * 输入：maxHeights = [5,3,4,1,1]
 * 输出：13
 * 解释：和最大的美丽塔方案为 heights = [5,3,3,1,1] ，这是一个美丽塔方案，因为：
 * - 1 <= heights[i] <= maxHeights[i]
 * - heights 是个山脉数组，峰值在 i = 0 处。
 * 13 是所有美丽塔方案中的最大高度和。
 *
 * 示例 2：
 * 输入：maxHeights = [6,5,3,9,2,7]
 * 输出：22
 * 解释： 和最大的美丽塔方案为 heights = [3,3,3,9,2,2] ，这是一个美丽塔方案，因为：
 * - 1 <= heights[i] <= maxHeights[i]
 * - heights 是个山脉数组，峰值在 i = 3 处。
 * 22 是所有美丽塔方案中的最大高度和。
 *
 * 示例 3：
 * 输入：maxHeights = [3,2,5,5,2,3]
 * 输出：18
 * 解释：和最大的美丽塔方案为 heights = [2,2,5,5,2,2] ，这是一个美丽塔方案，因为：
 * - 1 <= heights[i] <= maxHeights[i]
 * - heights 是个山脉数组，最大值在 i = 2 处。
 * 注意，在这个方案中，i = 3 也是一个峰值。
 * 18 是所有美丽塔方案中的最大高度和。
 *
 * @author zhuzhiwei
 * @date 2024/1/24 19:06
 */
public class Normal_2865_美丽塔I {


    /**
     * i为峰值时，总和 = heights
     * @param maxHeights
     * @return
     */
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long maxSum = 0;
        for (int i = 0; i < maxHeights.size(); i++) {
            Integer cur = maxHeights.get(i);
            int preVal = cur, posVal = cur;
            long preSum = 0, posSum = 0;
            for (int j = i - 1; j >= 0; j--) {
                preVal = Math.min(maxHeights.get(j), preVal);
                preSum += preVal;
            }
            for (int j = i + 1; j < maxHeights.size(); j++) {
                posVal = Math.min(maxHeights.get(j), posVal);
                posSum += posVal;
            }
            maxSum = Math.max(preSum + posSum + cur, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Integer[] arr = {5,4,3,2,1};

        long maxSum = new Normal_2865_美丽塔I().maximumSumOfHeights(Arrays.asList(arr));
        System.out.println(maxSum);
    }


    /**
     * 单调栈
     * @param maxHeights
     * @return
     */
    public long maximumSumOfHeights2(List<Integer> maxHeights) {
        int n = maxHeights.size();
        Stack<Integer> preStack = new Stack<>();
        Stack<Integer> posStack = new Stack<>();
        //保存以i为顶点，顶点前缀和
        long[] preSum = new long[n];
        long[] posSum = new long[n];
        for (int i = 0; i < n; i++) {
            int cur = maxHeights.get(i);
            while (!preStack.isEmpty() && cur < maxHeights.get(preStack.peek())) {
                preStack.pop();
            }
            if (preStack.isEmpty()) {
                //前面的值都比顶点大，i为顶点时，height左边的值都为i
                preSum[i] = (long) cur * (i + 1);
            } else {
                //设preStack.peek() = j，
                //stack不为空时，[0, j]等价于preSum[j]
                //[j + 1, i]都是大于
                preSum[i] = preSum[preStack.peek()] + (long) cur * (i - preStack.peek());
            }
            preStack.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int cur = maxHeights.get(i);
            while (!posStack.isEmpty() && cur < maxHeights.get(posStack.peek())) {
                posStack.pop();
            }
            if (posStack.isEmpty()) {
                posSum[i] = (long) cur * (n - i);
            } else {
                posSum[i] = posSum[posStack.peek()] + (long) cur * (posStack.peek() - i);
            }
            posStack.push(i);
        }
        long max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, preSum[i] + posSum[i] - maxHeights.get(i));
        }
        return max;
    }
}
