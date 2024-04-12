package hot.kadane;

/**
 * 18. 环形子数组的最大和
 * 中等
 *
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和。
 *
 * 环形数组 意味着数组的末端将会与开头相连呈环状。
 * 形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 *
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。
 * 形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 *
 *
 * 示例 1：
 * 输入：nums = [1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 *
 * 示例 2：
 * 输入：nums = [5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 *
 * 示例 3：
 * 输入：nums = [3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 *
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 3 * 10^4
 * -3 * 10^4 <= nums[i] <= 3 * 10^4
 *
 * @author zhuzhiwei
 * @date 2024/4/8 19:41
 */
public class Hot_918_环形子数组的最大和 {
    /**
     * dp[i] 表示以i为结尾的子数组最大和
     *
     * dp[0] = 起点为1，以length - 1结尾的子数组最大和 + nums[0]
     *
     * dp[i] = max(dp[i - 1] + nums[i], nums[i])
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
        int pre = nums[1];
        for (int i = 2; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
        }
        pre += nums[0];
        int max = pre;
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }

}
