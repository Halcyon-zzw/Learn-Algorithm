package offer.offer_61.impl;

import offer.offer_61.IsStraight;
import utils.TestUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 代码优化
 *
 * @Author: zhuzw
 * @Date: 2021-04-26 17:30
 * @Version: 1.0
 */
public class IsStraightOptImpl implements IsStraight {
    @Override
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 14, max = 0;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return max - min < nums.length;
    }

    public static void main(String[] args) {
        Class isStraightClass = IsStraightOptImpl.class;
        TestUtils.test(isStraightClass, new int[]{0,0,0,0,0});
    }
}
