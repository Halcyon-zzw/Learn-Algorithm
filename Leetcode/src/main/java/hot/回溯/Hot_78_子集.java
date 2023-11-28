package hot.回溯;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * @author zhuzhiwei
 * @date 2023/11/23 20:37
 */
public class Hot_78_子集 {
    private final static List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        dfs(nums, new ArrayList<>(), 0);
        return resultList;
    }

    private void dfs(int[] nums, List<Integer> eachList, int index) {
        //遍历到最后位置，结束
        if (index == nums.length) {
            resultList.add(new ArrayList<>(eachList));
            return;
        }
        List<Integer> tmpList = new ArrayList<>(eachList);
        //选当前位置
        eachList.add(nums[index]);
        dfs(nums, eachList, index + 1);
        //不选当前位置
        eachList = new ArrayList<>(tmpList);
        dfs(nums, eachList, index + 1);
    }

    public static void main(String[] args) {
        int[] nums = {0};
        List<List<Integer>> subsets = new Hot_78_子集().subsets(nums);
        System.out.println(ArrayUtils.toString(subsets));
    }
}


