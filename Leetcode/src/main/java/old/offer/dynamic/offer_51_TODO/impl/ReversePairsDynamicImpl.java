package old.offer.dynamic.offer_51_TODO.impl;

import old.offer.dynamic.offer_51_TODO.ReversePairs;

/**
 * dp[i] = dp[i - 1] + for(0 : i-1) > i 的个数
 *
 *
 *
 * @Author: zhuzw
 * @Date: 2021-04-24 22:34
 * @Version: 1.0
 */
public class ReversePairsDynamicImpl implements ReversePairs {
    @Override
    public int reversePairs(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            //[0,i)中，大于i的个数
            int count = 0;
            //遍历比较可优化；每次遍历记录前面每个数字出现的次数
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    count++;
                }
            }
            arr[i] += count;
        }
        return arr[nums.length - 1];
    }

    /**
     * 不创建arr
     * @param nums
     * @return
     */
    public int reversePairsWithoutArr(int[] nums) {
        int pre = 0;
        //记录当前0-9的个数
        for (int i = 1; i < nums.length; i++) {
            //[0,i)中，大于i的个数
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    count++;
                }
            }
            pre += count;
        }
        return pre;
    }
}
