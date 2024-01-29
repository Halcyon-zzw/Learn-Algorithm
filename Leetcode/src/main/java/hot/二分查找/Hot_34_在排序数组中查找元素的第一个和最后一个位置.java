package hot.二分查找;

import utils.ArrayUtils;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 *
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * @author zhuzhiwei
 * @date 2023/12/21 16:36
 */
public class Hot_34_在排序数组中查找元素的第一个和最后一个位置 {
    /**
     * 二分法
     * if 找到目标值
     *      在前半部分查找起始位置
     *      在后半部分查找结束位置
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int index = find(nums, target);
        if (index == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{findLeft(nums, target, index), findRight(nums, target, index)};
    }

    private int findRight(int[] nums, int target, int index) {
        int i = index + 1, j = nums.length - 1;
        int right = index;
        while (i <= j) {
            int mod = (j - i) / 2 + i;
            if (nums[mod] == target) {
                right = mod;
                i = mod + 1;
            } else {
                j = mod - 1;
            }
        }
        return right;
    }

    private int findLeft(int[] nums, int target, int index) {
        int i = 0, j = index - 1;
        int left = index;
        while (i <= j) {
            int mod = (j - i) / 2 + i;
            if (nums[mod] == target) {
                left = mod;
                j = mod - 1;
            } else {
                i = mod + 1;
            }
        }
        return left;
    }

    private int find(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mod = (j - i) / 2 + i;
            if (nums[mod] == target) {
                return mod;
            } else if (nums[mod] > target) {
                j = mod - 1;
            } else {
                i = mod + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        int[] result = new Hot_34_在排序数组中查找元素的第一个和最后一个位置().searchRange(nums, target);
        System.out.println(ArrayUtils.toString(result));
    }
}
