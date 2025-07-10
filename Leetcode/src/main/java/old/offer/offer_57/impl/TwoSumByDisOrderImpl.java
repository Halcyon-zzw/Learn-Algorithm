package old.offer.offer_57.impl;

import old.offer.offer_57.TwoSum;
import utils.TestUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组为无序情况
 *
 * 使用Hash集合判断目标差值是否存在
 * 如：判断target - nums[0] 是否在集合中，如果没在，则将当前值加入集合。
 *
 * @Author: zhuzw
 * @Date: 2021-04-25 19:54
 * @Version: 1.0
 */
public class TwoSumByDisOrderImpl implements TwoSum {
    @Override
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            int subVal = target - num;
            if (set.contains(subVal)) {
                return new int[]{num, subVal};
            }
            set.add(num);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TestUtils.test(TwoSumByDisOrderImpl.class, new int[]{2,7,11,15}, 9);
    }
}
