package hot.贪心;

/**
 * 45. 跳跃游戏 II
 * 中等
 *
 * 给定一个长度为n的 0索引 整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 * @author zhuzhiwei
 * @date 2024/2/21 16:04
 */
public class Hot_45_跳跃游戏II {
    /**
     * 前提：1、如果起跳点的跳跃距离是3，那么之后的三个位置都可以作为起跳点
     * 2、起跳点下一个位置到上一次最远距离做为下一次起跳点的尝试，
     * 维护能跳跃的最远距离
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        return jump2(nums);
    }
    public int jump1(int[] nums) {
        int count = 0, max = 0;
        int begin = 0, end = 0;
        while (max < nums.length - 1) {
            count++;
            for (int i = begin; i <= end; i++) {
                max = Math.max(max, i + nums[i]);
            }
            begin = end + 1;
            end = max;
        }
        return count;
    }

    public int jump2(int[] nums) {
        int count = 0, max = 0, end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            //上一次跳跃的最大位置
            if (end == i) {
                count++;
                end = max;
            }
        }
        return count;
    }
}
