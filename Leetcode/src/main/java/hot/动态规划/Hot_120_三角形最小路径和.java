package hot.动态规划;

import utils.ArrayUtils;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * 中等
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * 示例 1：
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 示例 2：
 * 输入：triangle = [[-10]]
 * 输出：-10
 * <p>
 * 提示：
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -10^4 <= triangle[i][j] <= 10^4
 * <p>
 * <p>
 * 进阶：
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 *
 * @author zhuzhiwei
 * @date 2024/4/12 14:16
 */
public class Hot_120_三角形最小路径和 {

    /**
     * sum[i][j] 表示 从上到(i, j)位置的最小路径和
     * sum[i][j] = min(sum[i - 1][j], sum[i - 1], [j - 1]) + triangle[i][j]
     * 特殊情况:
     * j == 0;  = sum[i - 1][j] + triangle[i][j]
     * j == i(triangle[i].length) = sum[i - 1][j - 1] + triangle[i][j]
     * 初始值: sum[0][0] = triangle[0][0]
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] sum = new int[size][triangle.get(size - 1).size()];
        sum[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int min;
                sum[i][j] = triangle.get(i).get(j);
                if (j == 0) {
                    min = sum[i - 1][j];
                } else if (j == i) {
                    min = sum[i - 1][j - 1];
                } else {
                    min = Math.min(sum[i - 1][j - 1], sum[i - 1][j]);
                }
                sum[i][j] = min + triangle.get(i).get(j);
            }
        }
        int min = sum[size - 1][0];
        for (int i = 1; i < sum[size - 1].length; i++) {
            min = Math.min(min, sum[size - 1][i]);
        }
        return min;
    }

    /**
     * 优化：
     * 只需要保存上一行的sum[i][j]
     * <p>
     * sum[j]表示当前行位置中选择位置j的最小路径和
     * sum[j] = min(sum[j], sum[j - 1]) + triangle[i][j]
     * 特殊值：
     * j == 0  = sum[j] + triangle[i][j]
     * j == i  = sum[j - 1] + triangle[i][j]
     * 初始值：sum[0] = triangle[0][0]
     *
     * 注意：计算sum[j]时需要使用到sum[j - 1]，
     * 如果从前向后计算sum，j - 1会被刷新为当前行的值，所以计算sum[j]需要从后往前计算
     *
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] sum = new int[triangle.get(size - 1).size()];
        sum[0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                int min;
                if (j == 0) {
                    min = sum[j];
                } else if (j == i) {
                    min = sum[j - 1];
                } else {
                    min = Math.min(sum[j - 1], sum[j]);
                }
                sum[j] = min + triangle.get(i).get(j);
            }
        }
        int min = sum[0];
        for (int i = 1; i < sum.length; i++) {
            min = Math.min(min, sum[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };
        List<List<Integer>> lists = ArrayUtils.toList(arr);
        int min = new Hot_120_三角形最小路径和().minimumTotal2(lists);
        System.out.println(min);
    }
}
