package hot.二分查找;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *
 *
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * @author zhuzhiwei
 * @date 2023/12/21 20:23
 */
public class Hot_4_寻找两个正序数组的中位数 {
    /**
     * 奇数，获取第 n + 1 / 2小元素
     * 偶数，获取第 n + 1 / 2小元素及下个元素的平均值
     * 综上：先获取第(n + 1) / 2小元素，偶数时，再多获取一个元素
     * k = (n + 1) / 2
     * 比较num1、num2的第k / 2个元素，
     * if num1[k / 2] > num2[k / 2]
     *      则排除num2的前 k / 2个元素
     * else
     *      则排除num1的前 k / 2个元素
     *
     *
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int k = (n + 1) / 2;
        int i = 0, j = 0;
        while (k > 1) {
            int tmpK = k / 2;
            //其中一个数组被剔除完，直接返回
            if (nums1.length == 0 || i >= nums1.length) {
                j += k - 1;
                break;
            }
            if (nums2.length == 0 || j >= nums2.length) {
                i += (k - 1);
                break;
            }
            //计算下一次比较的位置
            int iNext = i + tmpK - 1, jNext = j + tmpK - 1;
            if (iNext >= nums1.length) {
                //下一个位置操作数组最大值
                iNext = nums1.length - 1;
            }
            if (jNext >= nums2.length) {
                jNext = nums2.length - 1;
            }
            if (nums1[iNext] > nums2[jNext] || (nums1[iNext] == nums2[jNext] && nums1[i] > nums2[j])) {
                //剔除数组2，并减去剔除的数量
                k = k - (jNext - j + 1);
                j = jNext + 1;
            } else if (nums1[iNext] < nums2[jNext] || (nums1[iNext] == nums2[jNext] && nums1[i] <= nums2[j])){
                //剔除数组1，并减去剔除的数量
                k = k - (iNext - i + 1);
                i = iNext + 1;
            }
        }
        if (n % 2 != 0) {
            //奇数
            if (i >= nums1.length) {
                //i超过边界
                return nums2[j];
            } else if (j >= nums2.length){
                //j超过边界
                return nums1[i];
            }
            return Math.min(nums1[i], nums2[j]);
        }
        //偶数

        if (i >= nums1.length) {
            //i超过边界
            return (nums2[j] + nums2[j + 1]) * 1.0 / 2;
        } else if (j >= nums2.length) {
            //j超过边界
            return (nums1[i] + nums1[i + 1]) * 1.0 / 2;
        }
        if (nums1[i] > nums2[j]) {
            if (j + 1 >= nums2.length) {
                //越界
                return (nums1[i] + nums2[j]) * 1.0 / 2;
            }
            return (nums2[j] + Math.min(nums1[i], nums2[j + 1])) * 1.0 / 2;
        }
        if (i + 1 >= nums1.length) {
            //越界
            return (nums1[i] + nums2[j]) * 1.0 / 2;
        }
        return (nums1[i] + Math.min(nums1[i + 1], nums2[j])) * 1.0 / 2;
    }


    public int getKth(int[] nums1, int[] nums2, int k) {
        int i = 0, j = 0;
        while (k > 0) {
            if (nums1.length == 0 || i >= nums1.length) {
                return nums2[j + k - 1];
            }
            if (nums2.length == 0 || j >= nums2.length) {
                return nums1[i + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[i], nums2[j]);
            }
            int tmpK = k / 2;
            int iNext = i + tmpK - 1, jNext = j + tmpK - 1;
            if (iNext >= nums1.length) {
                iNext = nums1.length - 1;
            }
            if (jNext >= nums2.length) {
                jNext = nums2.length - 1;
            }
            if (nums1[iNext] > nums2[jNext] || (nums1[iNext] == nums2[jNext] && nums1[i] > nums2[j])) {
                //剔除数组2，并减去剔除的数量
                k = k - (jNext - j + 1);
                j = jNext + 1;
            } else if (nums1[iNext] < nums2[jNext] || (nums1[iNext] == nums2[jNext] && nums1[i] <= nums2[j])){
                //剔除数组1，并减去剔除的数量
                k = k - (iNext - i + 1);
                i = iNext + 1;
            }
        }
        return -1;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int k = (n + 1) / 2;
        if (n % 2 != 0) {
            //奇数
            return getKth(nums1, nums2, k);
        }
        return (getKth(nums1, nums2, k) + getKth(nums1, nums2, k + 1)) * 0.5;
    }

    public static void main(String[] args) {
//        int[] nums1 = {3};
//        int[] nums12 = {-2, -1};
        int[] nums1 = {1};
        int[] nums12 = {2, 3, 4, 5, 6, 7};
        double median = new Hot_4_寻找两个正序数组的中位数().findMedianSortedArrays(nums1, nums12);
        System.out.println(median);

    }
}
