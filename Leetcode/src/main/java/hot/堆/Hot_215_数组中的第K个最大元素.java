package hot.堆;

import java.util.Deque;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *
 * 提示：
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 *
 * @author zhuzhiwei
 * @date 2024/1/5 17:24
 */
public class Hot_215_数组中的第K个最大元素 {

    /**
     * 快速选择
     * @param _nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] _nums, int k) {
        int n = _nums.length;
        return quickselect(_nums, 0, n - 1, n - k);
    }

    private int quickselect(int[] nums, int l, int r, int k) {
        //确定轴值位置
        int index = getIndex(nums, l, r, k);
        if (index == k) {
            return nums[index];
        } else if (index > k) {
            return quickselect(nums, l, index - 1, k);
        } else {
            return quickselect(nums, index + 1, r, k);
        }
    }

    private int getIndex(int[] nums, int l, int r, int k) {
        int val = nums[l];
        while (l < r) {
            //找到第一个比val小的值
            while (r > l && nums[r] >= val) {
                r--;
            }
            //将小于val的移到左边
            nums[l] = nums[r];
            //找到第一个比val小的值
            while (l < r && nums[l] < val) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[r] = val;
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1};
        int k = 1;
        int kthLargest = new Hot_215_数组中的第K个最大元素().findKthLargest(nums, k);
        System.out.println(kthLargest);
    }
}



