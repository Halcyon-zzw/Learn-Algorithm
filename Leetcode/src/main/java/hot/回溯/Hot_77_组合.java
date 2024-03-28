package hot.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 中等
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 * @author zhuzhiwei
 * @date 2024/3/21 19:30
 */
public class Hot_77_组合 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        List<Integer> eachList = new ArrayList<>();
        dfs(eachList, 1, n, k);
        return result;
    }

    private void dfs(List<Integer> eachList, int i, int n, int k) {
        if (eachList.size() == k) {
            result.add(new ArrayList<>(eachList));
        }
        if (i > n || eachList.size() >= k) {
            return;
        }
        eachList.add(i);
        dfs(eachList, i + 1, n, k);
        eachList.remove(eachList.size() - 1);
        dfs(eachList, i + 1, n, k);
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new Hot_77_组合().combine(4, 2);
        System.out.println(combine);
    }
}
