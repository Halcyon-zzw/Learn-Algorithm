package old.offer.offer_59_I.impl;

import old.offer.offer_59_I.MaxSlidingWindow;
import utils.TestUtils;

/**
 * 动态规划实现
 * max[i]:
 * if nums[i] >= max[i - 1]     max[i] = num[i]     maxIndex = i
 * if num[i] < max[i - 1] :
 *      if i - k < maxIndex (在窗口内)，
 *      else 重新计算[i - k + 1, i]
 *
 * @Author: zhuzw
 * @Date: 2021-04-26 11:19
 * @Version: 1.0
 */
public class MaxSlidingWindowByDynamicImpl implements MaxSlidingWindow {
    @Override
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return new int[0];
        }

        int[] maxArr = new int[nums.length - k + 1];
        int maxIndex = getMaxIndex(nums, 0, k);
        maxArr[0] = nums[maxIndex];
        for (int i = k; i < nums.length; i++) {
            if (nums[i] >= maxArr[i - k]) {
                maxArr[i - k + 1] = nums[i];
                maxIndex = i;
            }else {
                if (i - k > maxIndex) {
                    //在窗口内
                    maxArr[i - k + 1] = maxArr[i - k];
                }else {
                    //重新计算
                    maxIndex = getMaxIndex(nums, i + 1 - k ,i + 1);
                    maxArr[i - k + 1] = nums[maxIndex];
                }
            }
        }

        return maxArr;
    }

    /**
     * 获取[start, end)中的最大值的下标
     * if值相同，返回下标较大的
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int getMaxIndex(int[] nums, int start, int end) {
        int max = nums[end - 1];
        int maxIndex = end - 1;
        for (int i = end - 1; i >= start; i--) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Class thisClass = MaxSlidingWindowByDynamicImpl.class;
        TestUtils.test(thisClass, new int[]{1, -1}, 1);
        TestUtils.test(thisClass, new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }
}
