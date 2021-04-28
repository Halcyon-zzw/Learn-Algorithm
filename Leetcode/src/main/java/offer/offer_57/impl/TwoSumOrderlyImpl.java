package offer.offer_57.impl;

import offer.offer_57.TwoSum;

/**
 * 数组为有序情况
 *
 * 双指针：
 * left、right
 * 当nums[left] + nums[right] < target时left++;
 * 当nums[left] + nums[right] > target时right++;
 * if nums[left] + nums[right] ;return
 * if right < left return
 *
 * @Author: zhuzw
 * @Date: 2021-04-25 19:48
 * @Version: 1.0
 */
public class TwoSumOrderlyImpl implements TwoSum {
    @Override
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[0];
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            }else if (nums[left] + nums[right] > target) {
                right--;
            }else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[0];
    }
}
