package offer.offer_61.impl;

import offer.offer_61.IsStraight;
import utils.TestUtils;

/**
 * 记录每张牌出现的次数
 * if 存在相同的牌    return false
 * 找出最大和最小的牌
 * if max - min < 5  return true;
 *
 * @Author: zhuzw
 * @Date: 2021-04-26 17:02
 * @Version: 1.0
 */
public class IsStraightImpl implements IsStraight {
    @Override
    public boolean isStraight(int[] nums) {
        int[] arr = new int[14];

        for (int num : nums) {
            arr[num] ++;
            if (num == 0) {
                continue;
            }
            if (arr[num] > 1) {
                //出现两次，不是顺子
                return false;
            }
        }
        if (arr[0] == nums.length) {
            return true;
        }
        int min = 1, max = 13;
        while (arr[min] == 0) {
            min++;
        }
        while (arr[max] == 0) {
            max--;
        }
        if (max - min < nums.length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Class<IsStraightImpl> isStraightClass = IsStraightImpl.class;
        TestUtils.test(isStraightClass, new int[]{0,0,0,0,0});
    }
}
