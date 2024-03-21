package hot.普通数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 中等
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author zhuzhiwei
 * @date 2023/11/20 13:38
 */
public class Hot_56_合并区间 {
    /**
     * 1、数组以第一个元素排序：(1, 2)、(1, 1)、(2, 3)
     * 2、相邻两个数组存在两种情况
     *      - 重叠 当前arr[i][0] 小于等于 结果数组中最后一个值的右边界值
     *          更新结果数组中最后一个值的右边界值，值为Math(结果数组中最后一个值的右边界值, arr[i][1])
     *      - 不重叠 i == 0 || 当前arr[i][0] 大于 结果数组中最后一个值的右边界值
     *          当前结果加入到结果数组中
     *
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }
//        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);

        Arrays.sort(intervals, Comparator.comparing((arr) -> arr[0]));
        List<int[]> mergeList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            //不重叠
            if (i == 0 || l > mergeList.get(mergeList.size() - 1)[1]) {
                mergeList.add(new int[]{l, r});
            } else {
                //重叠，更新结果数组中最后一个值的右边界值
                int[] arr = mergeList.get(mergeList.size() - 1);
                arr[1] = Math.max(r, arr[1]);
            }
        }
        return mergeList.toArray(new int[mergeList.size()][]);
    }
}
