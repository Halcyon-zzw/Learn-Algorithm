package hot.二分查找;

/**
 * 33. 搜索旋转排序数组
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同。
 * 在传递给函数之前，nums 知在预先未的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 *
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 *
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 *
 * 提示：
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 *
 * @author zhuzhiwei
 * @date 2023/12/21 17:04
 */
public class Hot_33_搜索旋转排序数组 {
    /**
     * 二分法找到递增临界点
     *      if nums[mod] > nums[mod + 1]
     *          return 临界点
     *      else if nums[mod] > nums[length - 1]
     *          i = mod + 1
     *      else
     *          j = mod - 1
     *
     *
     * 二分法分别查找临界点前和临界点后的数组
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int point = nums.length / 2;
        int i = 0, j = nums.length - 1;
        //找到递增临界点
        while (i <= j) {
            int mod = (j - i) / 2 + i;
            if (mod + 1 < nums.length && nums[mod] > nums[mod + 1]) {
                point = mod;
                break;
            } else if (nums[mod] > nums[nums.length - 1]){
                i = mod + 1;
            } else {
                j = mod - 1;
            }
        }
        //在前半部分找
        int searchLeft = search(nums, 0, point, target);
        if (searchLeft >= 0) {
            return searchLeft;
        }
        //在后半部分找
        int searchRight = search(nums, point + 1, nums.length - 1, target);
        if (searchRight >= 0) {
            return searchRight;
        }
        return -1;
    }

    private int search(int[] nums, int start, int end, int target) {
        int i = start, j = end;
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
}
