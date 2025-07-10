package old.offer.offer_1_50.offer_42.impl;

import old.offer.offer_1_50.offer_42.MaxSubArray;

/**
 * 动态规划实现：连续子数组的最大和
 *
 * @Author: zhuzw
 * @Date: 2021-04-22 19:34
 * @Version: 1.0
 */
public class MaxSubArrayByDynamicImpl implements MaxSubArray {
    @Override
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dynamicArr = new int[nums.length];
        dynamicArr[0] = nums[0];
        int maxSubArray = dynamicArr[0];
        for (int i = 1; i < nums.length; i++) {
            dynamicArr[i] = Math.max(dynamicArr[i - 1] + nums[i], nums[i]);
            maxSubArray = Math.max(dynamicArr[i], maxSubArray);
        }

        return maxSubArray;
    }
}
