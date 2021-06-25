package normal.normal_523.impl;

import normal.normal_523.CheckSubarraySum;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-02 16:49
 * @Version: 1.0
 */
public class CheckSubarraySumImpl implements CheckSubarraySum {
    @Override
    public boolean checkSubarraySum(int[] nums, int k) {
        if (null == nums || nums.length < 2) {
            return false;
        }
        int temp = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            temp = (temp + nums[i]) % k;
            Integer index = map.get(temp);
            if (index == null) {
                map.put(temp, i);
            }else {
                if (i - index >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
