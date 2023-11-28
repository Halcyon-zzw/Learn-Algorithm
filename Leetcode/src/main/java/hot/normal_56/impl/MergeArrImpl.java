package hot.normal_56.impl;

import hot.normal_56.MergeArr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 *
 * @author zhuzhiwei
 * @date 2023/11/21 10:07
 */
public class MergeArrImpl implements MergeArr {
    /**
     * 1、数组以第一个元素排序：(1, 2)、(1, 1)、(2, 3)
     * 2、相邻两个数组存在两种情况
     *      - 重叠 当前arr[i][0] 小于等于 结果数组中最后一个值的右边界值
     *          更新结果数组中最后一个值的右边界值，值为Math(结果数组中最后一个值的右边界值, arr[i][1])
     *      - 不重叠 i == 0 || 当前arr[i][0] 大于 结果数组中最后一个值的右边界值
     *          当前结果加入到结果数组中
     *
     */
    @Override
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
