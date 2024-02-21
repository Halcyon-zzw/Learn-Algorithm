package hot.贪心;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 55. 跳跃游戏
 * 中等
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 * @author zhuzhiwei
 * @date 2024/2/21 16:04
 */
public class Hot_55_跳跃游戏 {
    /**
     * 贪心：到达最远位置
     *
     * 如果起跳点的最大跳跃距离是3，那么后面3个位置都可以作为起跳点。
     * 遍历所以起跳点，维护能到达的最远距离，
     * 如果最远距离大于length，则返回true，否则false
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < i) {
                //不能到达当前位置
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
