package normal;

import java.util.Arrays;
import java.util.List;

/**
 * 2859. 计算 K 置位下标对应元素的和
 * 简单
 *
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * 请你用整数形式返回 nums 中的特定元素之 和 ，这些特定元素满足：其对应下标的二进制表示中恰存在 k 个置位。
 * 整数的二进制表示中的 1 就是这个整数的 置位 。
 *
 * 例如，21 的二进制表示为 10101 ，其中有 3 个置位。
 *
 * 示例 1：
 * 输入：nums = [5,10,1,5,2], k = 1
 * 输出：13
 * 解释：下标的二进制表示是：
 * 0 = 000
 * 1 = 001
 * 2 = 010
 * 3 = 011
 * 4 = 100
 * 下标 1、2 和 4 在其二进制表示中都存在 k = 1 个置位。
 * 因此，答案为 nums[1] + nums[2] + nums[4] = 13 。
 *
 * 示例 2：
 * 输入：nums = [4,3,2,1], k = 2
 * 输出：1
 * 解释：下标的二进制表示是：
 * 0 = 002
 * 1 = 012
 * 2 = 102
 * 3 = 112
 * 只有下标 3 的二进制表示中存在 k = 2 个置位。
 * 因此，答案为 nums[3] = 1 。
 *
 * @author zhuzhiwei
 * @date 2024/1/25 20:07
 */
public class Normal_2859_计算K置位下标对应元素的和 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int aNum = -1, sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            int count = 0, tmpNum = i;
            while ((tmpNum & aNum) != 0) {
                if ((tmpNum & 1) == 1) {
                    count++;
                }
                tmpNum = tmpNum >> 1;
            }
            if (count == k) {
                sum += nums.get(i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Integer[] arr = {5,10,1,5,2};
        int k = 1;
        int sum = new Normal_2859_计算K置位下标对应元素的和().sumIndicesWithKSetBits(Arrays.asList(arr), k);
        System.out.println(sum);
    }
}
