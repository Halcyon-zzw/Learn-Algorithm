package hot.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 *
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 *
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 * @author zhuzhiwei
 * @date 2023/11/29 20:46
 */
public class Hot_15_三数之和 {
    /**
     * 排序 + 双指针
     *
     * 1、排序
     * 2、特判：
     *      nums为null || nums.length < 3，返回空集合
     * 3、遍历数组 for i in nums
     *      l = i + 1, r = nums.length - 1
     *      while l < r:
     *          判断和是否为0
     *          if nums[i] + nums[l] + nums[r] == 0:
     *              //记录结果
     *              break;
     *          else if > 0:
     *              //值太大，因为数组有序，所以r--
     *              r--;
     *              //重复值判断
     *              if nums[r] == nums[r + 1]:
     *                  r--;
     *              break;
     *         else if < 0:
     *              //值太小，因为数组有序，所以l--
     *              l++;
     *              //重复值判断
     *              if num[l] == nums[l - 1]:
     *                  l++;
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[r] + nums[l];
                if (sum == 0) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[l]);
                    tmpList.add(nums[r]);
                    resultList.add(tmpList);
                    r--;
                    while (nums[r] == nums[r + 1] && l < r) {
                        r--;
                    }
                    l++;
                    while (nums[l] == nums[l - 1] && l < r) {
                        l++;
                    }
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = new Hot_15_三数之和().threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
