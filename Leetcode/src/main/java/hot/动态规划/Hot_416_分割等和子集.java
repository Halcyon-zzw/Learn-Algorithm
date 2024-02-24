package hot.动态规划;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 * 中等
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 * @author zhuzhiwei
 * @date 2024/2/21 22:22
 */
public class Hot_416_分割等和子集 {
    /**
     * 求出nums所有元素总和
     * if sum为奇数，直接return false;
     *
     * 问题转变为 => 从nums中的选部分元素是否可以得到和为 sum / 2的结果
     * 0-1背包问题
     *
     * dp[i][j] => 从nums数组的[0,i]范围中，是否可以得到和为j的结果
     *
     * 转移方程：
     * 不选择nums[i]: dp[i][j] = dp[i - 1][j]
     * 选择nums[j]:
     *      if nums[i] == j   dp[i][j] = true
     *      if nums[i] < j    dp[i][j] = dp[i - 1][j - nums[j]]
     * 初始化：dp[i][j] = false;
     *
     * 返回：dp[nums.length -1][sum / 2]
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int n = sum / 2;
        boolean[][] dp = new boolean[nums.length][n + 1];
        //第一行单独考虑
        if (nums[0] <= n) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= n; j++) {
                //不选nums[i],直接复制上一行结果
                dp[i][j] = dp[i - 1][j];
                //选nums[i]
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j && dp[i - 1][j - nums[i]]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[nums.length - 1][n];
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,4,5};
        boolean b = new Hot_416_分割等和子集().canPartition(nums);
        System.out.println(b);
    }
}
