package old.offer.offer_1_50.offer_03;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中重复的数字
 *
 * <p>
 *     在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 *     数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 *     请找出数组中任意一个重复的数字。
 * </p>
 *
 * @Author: zhuzw
 * @Date: 2021-04-16 10:51
 * @Version: 1.0
 */
public class FindRepeatNumber03 {
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, true);
            }else {
                return num;
            }
        }
        return -1;
    }

    /**
     * 鸽巢原理，因为出现的元素值 < nums.size(); 所以我们可以将见到的元素 放到索引的位置
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                int temp = nums[i];
                if (nums[temp] == nums[i]) {
                    return nums[i];
                }
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
