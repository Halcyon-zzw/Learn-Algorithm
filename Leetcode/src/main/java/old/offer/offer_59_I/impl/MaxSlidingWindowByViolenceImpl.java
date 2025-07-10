package old.offer.offer_59_I.impl;

import old.offer.offer_59_I.MaxSlidingWindow;

/**
 * 暴力实现，双重for
 * Violence
 *
 * max[i] = (max[i - 1], nums[i])
 *
 * @Author: zhuzw
 * @Date: 2021-04-26 10:57
 * @Version: 1.0
 */
public class MaxSlidingWindowByViolenceImpl implements MaxSlidingWindow {
    @Override
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return new int[0];
        }

        int[] maxArr = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            maxArr[i] = Math.max(getMax(nums, i, i + k), nums[i + k - 1]);
        }
        return maxArr;
    }

    /**
     * 获取[start, end)中的最大值
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int getMax(int[] nums, int start, int end) {
        int max = nums[start];
        for (int i = start + 1; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
