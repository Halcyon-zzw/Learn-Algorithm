package hot.回溯;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 *
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 *
 * 示例 2：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * 示例 3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 *
 * @author zhuzhiwei
 * @date 2023/11/24 14:39
 */
public class Hot_39_组合总和 {

    private final List<List<Integer>> resultList = new ArrayList<>();

    private int sum = 0;
    /**
     * 升序排序
     *
     * dfs(candidates, index, target) {
     *      if (sum > target) {
     *          return;
     *      }
     *      if ((target - sum) % candidates[index] == 0 || target - candidates[i] == 0) {
     *          //记录结果
     *          return;
     *      }
     *      sum += candidates[index];
     *      dfs(candidates, index + 1, target)
     * }
     */

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> eachList = new ArrayList<>();

        dfs(candidates, eachList, 0, target);
        return resultList;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> eachList = new ArrayList<>();
        dfs(candidates, eachList, 0, target);
        return resultList;
    }

    private void dfs(int[] candidates, List<Integer> eachList, int index, int target) {
        if (sum > target || index >= candidates.length) {
            return;
        }
        if (target == sum) {
            resultList.add(new ArrayList<>(eachList));
            return;
        }
        eachList.add(candidates[index]);
        sum += candidates[index];
        dfs(candidates, eachList, index, target);
        sum -= candidates[index];
        eachList.remove(eachList.size() - 1);
        if (target - sum <= candidates[index]) {
            return;
        }
        dfs(candidates, eachList, index + 1, target);

    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = new Hot_39_组合总和().combinationSum(candidates, target);
        System.out.println(ArrayUtils.toString(lists));
    }

}
