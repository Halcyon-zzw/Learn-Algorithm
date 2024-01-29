package hot.二分查找;

/**
 * 35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 *
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * @author zhuzhiwei
 * @date 2023/12/15 15:51
 */
public class Hot_35_搜索插入位置 {
    /**
     * 递归：二分法
     * if l > r
     *      return l;
     *
     * if (mid == target)
     *      return ture;
     * else if mid > target
     *      查询后半部分
     * else
     *      查询前半部分
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    public int searchInsert(int[] nums, int target, int i, int j) {
        if (i > j) {
            return i;
        }
        int mod = (i + j) / 2;
        if (nums[mod] == target) {
            return mod;
        } else if (nums[mod] > target){
            return searchInsert(nums, target, i, mod - 1);
        } else {
            return searchInsert(nums, target, mod + 1, j);
        }
    }

    /**
     * 非递归实现
     * while i < j:
     *      if mod == target:
     *          return ture;
     *      else if mod > target:
     *          j = mod - 1;
     *      else
     *          i = mod + 1
     * return i;
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        int i = 0, j = nums.length -1;
        while (i <= j) {
            int mod = (i + j) / 2;
            if (nums[mod] == target) {
                return mod;
            } else if (nums[mod] > target) {
                j = mod - 1;
            } else {
                i = mod + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
