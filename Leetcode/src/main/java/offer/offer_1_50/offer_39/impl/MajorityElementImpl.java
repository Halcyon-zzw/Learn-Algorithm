package offer.offer_1_50.offer_39.impl;

import offer.offer_1_50.offer_39.MajorityElement;

/**
 * 数组中出现次数超过一半的数字
 *
 * 实现思路：
 * if 超过一般：
 *      分成两半后，有一半
 *
 * @Author: zhuzw
 * @Date: 2021-04-22 17:15
 * @Version: 1.0
 */
public class MajorityElementImpl implements MajorityElement {
    @Override
    public int majorityElement(int[] nums) {
        int majority = 0;
        int sum = 0;
        for (int num : nums) {
            if (sum == 0) {
                majority = num;
            }
            sum += (majority == num)? 1 : -1;
        }
        return majority;
    }
}
