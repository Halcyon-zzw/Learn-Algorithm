package hot.二分查找;

/**
 * 162. 寻找峰值
 * 中等
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 *
 * @author zhuzhiwei
 * @date 2024/4/8 20:45
 */
public class Hot_162_寻找峰值 {
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        int start = 0, end = length - 1;
        while (start <= end) {
            int mod = (start + end) / 2;

            //查找位置的前一个不同值    后一个不同值
            int pre = mod, last = mod;
            while (pre > start && nums[pre] == nums[mod]) {
                pre--;
            }
            while (last < end && nums[last] == nums[mod]) {
                last++;
            }

            if (nums[mod] >= nums[pre] && nums[mod] >= nums[last]) {
                return mod;
            } else if (nums[mod] < nums[pre]) {
                end = mod - 1;
            } else if (nums[mod] < nums[last]) {
                start = mod + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        int peakElement = new Hot_162_寻找峰值().findPeakElement(arr);
        System.out.println(peakElement);
    }

}
