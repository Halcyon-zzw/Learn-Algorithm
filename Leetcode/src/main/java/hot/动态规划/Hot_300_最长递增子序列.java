package hot.动态规划;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zhuzhiwei
 * @date 2024/2/21 22:20
 */
public class Hot_300_最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        //dp[i]表示以nums结尾的最长递增序列
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //nums[i]可以放在nums[j]的后面
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        int count = new Hot_300_最长递增子序列().lengthOfLIS(nums);
        System.out.println(count);
    }
}
