package hot.子串;

import utils.ArrayUtils;

import java.util.*;

/**
 * 239. 滑动窗口最大值
 * <p>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * @author zhuzhiwei
 * @date 2023/12/11 13:46
 */
public class Hot_239_滑动窗口最大值 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ints = new Hot_239_滑动窗口最大值().maxSlidingWindow2(nums, k);
        System.out.println(ArrayUtils.toString(ints));
    }




    /**
     *
     * 单调列表：
     * 维护一个列表，保证列表中的值是单调递减的
     * while cur >= lastVal: 列表最后一个值出队列
     * cur值入队列
     *
     * 每个值只会放入一次，弹出也只会弹出一次。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length < 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> list = new LinkedList<>();
        for (int i = 0; i < k && i < nums.length; i++) {
            while (!list.isEmpty() && nums[i] >= nums[list.peekLast()]) {
                list.pollLast();
            }
            list.addLast(i);
        }
        result[0] = nums[list.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            while (!list.isEmpty() && nums[i] >= nums[list.peekLast()]) {
                list.pollLast();
            }
            list.addLast(i);
            //判断第一个最大是是否在窗口内
            while (!list.isEmpty() && list.peekFirst() < i - k + 1) {
                list.pollFirst();
            }
            result[i - k + 1] = nums[list.peekFirst()];
        }
        return result;
    }

    /**
     * 分组预处理
     * 将数组按k个数分成以一组，计算nums[i] 到nums[i + k - 1]的最大值，有两种情况：
     * i 是k的倍数：即为该分组的最大值
     * i 不是k的倍数，nums[i]、nums[i + k - 1]跨越两个分组，最大值 = Math.max(前一组的后缀最大值, 后一组的前缀最大值)
     *
     * 前缀最大值：preMax[i]
     *     i是k的倍数    = nums[i]  （分组中第一个元素）
     *     i不是k的倍数  = Math.max(preMax[i - 1], nums[i])
     *
     * 后缀最大值：sufMax[i]
     *      i + 1是k的倍数      = nums[i]   (分组中最后一个元素)
     *      i + 1不是k的倍数    = Math.max(sufMax[i + 1], nums[i])
     *
     * curMax = Math.max(sufMax[i], preMax[i + k - 1])
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length < 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];

        int[] preMaxArr = new int[nums.length], sufMaxArr = new int[nums.length];
        //计算前缀最大值
        for (int i = 0; i < nums.length; i++) {
            if (i % k == 0) {
                preMaxArr[i] = nums[i];
            } else {
                preMaxArr[i] = Math.max(preMaxArr[i - 1], nums[i]);
            }
        }
        //计算后缀最大值
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1 || (i + 1) % k == 0) {
                sufMaxArr[i] = nums[i];
            } else {
                sufMaxArr[i] = Math.max(sufMaxArr[i + 1], nums[i]);
            }
        }
        for (int i = 0; i < nums.length - k + 1; i++) {
            result[i] = Math.max(sufMaxArr[i], preMaxArr[i + k - 1]);
        }
        return result;
    }

}
