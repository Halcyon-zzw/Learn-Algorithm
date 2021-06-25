package normal.normal_523;

/**
 * 连续的子数组和
 *
 * <p>
 *     给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 *
 *  
 * </p>
 *
 * @Author: zhuzw
 * @Date: 2021-06-02 16:49
 * @Version: 1.0
 */
public interface CheckSubarraySum {
    boolean checkSubarraySum(int[] nums, int k);
}
