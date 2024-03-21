package hot.普通数组;

import java.util.HashMap;
import java.util.Map;

/**
 * 189. 轮转数组
 *
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 *
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *
 * 进阶：
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *
 *
 * @author zhuzhiwei
 * @date 2023/11/21 11:19
 */
public class Hot_189_轮转数组 {

    /**
     * 解法一：
     *
     * 创建新数组
     * 遍历原始数组，计算新位置，复制到新数组
     * 复制回新数组
     */
    public void rotate(int[] nums, int k) {
        int[] resultArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int rotateIndex = (i + k) % nums.length;
            resultArr[rotateIndex] = nums[i];
        }
        for (int i = 0; i < resultArr.length; i++) {
            nums[i] = resultArr[i];
        }
    }


    /**
     * 解法二： 原地旋转
     * rateValue = nums[0]
     * 1、计算向右旋转k后的rateIndex，保存当前位置防止数据覆盖tmp = nums[rateIndex]
     * 2、将当前index的值赋值到rateIndex，nums[rateIndex] = rateValue
     * 3、index = rateIndex，rateValue = tmp
     *
     * [1,2,3,4],k=2时，会存在循环遍历。
     * 需要保存开始的index，如果发现遍历到相同的index时，index需要 + 1
     *
     * initIndex = 0;
     * 4、if initIndex == index
     *      initIndex ++;
     *      index = initIndex;
     *      rateValue = nums[index]
     * 循环nums.length次
     *
     *
     */
    public void rotate2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return;
        }
        int rateValue = nums[0];
        int initIndex = 0;
        int index = 0;
        int count = 0;
        while (true) {
            int rateIndex = (index + k) % nums.length;
            int tmp = nums[rateIndex];
            nums[rateIndex] = rateValue;
            rateValue = tmp;
            index = rateIndex;
            count++;
            if (count == nums.length) {
                break;
            }
            //循环遍历了
            if (index == initIndex) {
                initIndex++;
                index = initIndex;
                rateValue = nums[initIndex];
            }

        }
    }

    /**
     * 向右移动k个元素，数组尾部k mod n个元素会移动到数组头部，其他元素向后移动k mod n个位置
     *
     * 1、数组全量翻转，数组尾部的数字移动到头部，头部的数字移动到尾部
     * 2、翻转[0, k mod n - 1]，得到头部翻转后结果
     * 3、翻转[k mod n, n - 1]，得到尾部翻转后的结果
     *
     *
     * 初始   k = 3                        [1, 2, 3, 4, 5, 6, 7]
     * 翻转所有                            [7, 6, 5, 4, 3, 2, 1]
     * 翻转[0, k mod n - 1] -> [0, 2]     [5, 6, 7, 4, 3, 2, 1]
     * 翻转[k mod n, n - 1] -> [3, 6]     [5, 6, 7, 1, 2, 3, 4]
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return;
        }
        rotateArr(nums, 0, nums.length - 1);
        rotateArr(nums, 0, k % nums.length - 1);
        rotateArr(nums, k % nums.length, nums.length - 1);

    }

    public void rotateArr(int[] nums, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int k = 1;
        new Hot_189_轮转数组().rotate2(nums, k);
        for (int num : nums) {
            System.out.println(num + " ");
        }
    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        int n = nums.length;
        //将所有的小于等于0的元素设置为n + 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        //打标记，如果num[i]绝对值（因为有可能当前位置以及被标记）在[1, n]，则num[i-1]打上标记
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if (abs >= 1 && abs <= n && nums[i - 1] > 0) {
                nums[i - 1] *= -1;
            }
        }
        //遍历获取结果
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    /**
     * map保存每种颜色出现的次数，按照制定顺序给数组赋值
     */
    public void sortColors1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < map.getOrDefault(i, 0); j++) {
                nums[index++] = i;
            }
        }
    }

    /**
     * 单指针：
     * 第一次遍历将0移动到头部
     * 第二次遍历将1移动到0的后面
     */
    public void sortColors2(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[p];
                nums[p++] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                nums[i] = nums[p];
                nums[p++] = 1;
            }
        }
    }


    /**
     * 双指针：
     * 维护指针l、r
     * l初始等于0，r初始等于nums.length - 1
     *
     * for i : nums:
     *      0 <-> 1
     *      if nums[i] == 0
     *          nums[l++] <=> nums[i];
     *      if nums[i] == 2
     *          nums[j--] <=> nums[i]
     */
    public void sortColors3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int l = 0, r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[l];
                nums[l++] = 0;
            } else if (nums[i] == 2){
                nums[i] = nums[r];
                nums[r--] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int[] ints = new Solution().twoSum(nums, 6);
        for (int num : ints) {
            System.out.println(num + " ");
        }
    }

    /**
     * map记录 值 -> index
     * 遍历数组
     *      判断当前数字是否满足答案即判断map是否存在target - nums[1]的key
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key) && map.get(key) != i) {
                return new int[]{i, map.get(key)};
            }
        }
        return new int[2];
    }
}

