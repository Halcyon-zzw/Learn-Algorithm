package hot.滑动窗口;

/**
 * 209. 长度最小的子数组
 * 中等
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续
 * 子数组
 *  [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * @author zhuzhiwei
 * @date 2024/3/19 14:45
 */
public class Hot_209_长度最小的子数组 {
    /**
     * 滑动窗口
     * int l = 0, r = 0, minLength = MAX;
     * sum += nums[0]
     * while l < length && r < length
     *      if sum >= target && 左指针未越界（l < r && l < length）: 左指针移动，minLength = min(min, r - l + 1)，更新sum
     *      if sum < target && 右指针未越界（l < length）: 右指针移动，更新sum
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0, r = 0, min = Integer.MAX_VALUE, sum = nums[0], length = nums.length;
        while (l < length && r < length) {
            if (sum >= target) {
                min = Math.min(min, r - l + 1);
                sum -= nums[l];
                l ++;
            } else {
                r++;
                if (r < length) {
                    sum += nums[r];
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int target = 11;
        int[] nums = {1,2,3,4,5};
        Hot_209_长度最小的子数组 hot_209 = new Hot_209_长度最小的子数组();
        int min = hot_209.minSubArrayLen(target, nums);
        System.out.println(min);
    }
}
