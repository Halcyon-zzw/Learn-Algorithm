package hot.普通数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. 插入区间
 * 中等
 *
 * 给你一个无重叠的，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，
 * 并且 intervals 按照 starti 升序排列。
 * 同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 * 返回插入之后的 intervals。
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 *
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 *
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * @author zhuzhiwei
 * @date 2024/3/19 15:31
 */
public class Hot_57_插入区间 {

    /**
     * S1[l1, r1]，S2[l2, r2]
     * 如果没有交集
     *      S1在S2左侧，r1 < l2
     *      S1在S2右侧，l1 > r2
     * 如果右交集，新集合：[min(l1, l2), max(r1, r2)]
     *
     * int l = newInterval[0], r = newInterval[1]
     * 遍历intervals
     *      if cur 在 插入集合的左侧 r1 < l
     *          add(cur)
     *      else if cur 在 插入集合的右侧 l1 > r
     *          //防止重复添加
     *          if (!未添加)
     *              add(newInterval)
     *              flag = true;
     *          add(cur)
     *      else
     *          //有重叠
     *          计算新的集合
     *          l = min(l, cur[0]);
     *          r = max(r, cur[1]);
     *
     * if (!未添加) add(new int[]{l, r})
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null) {
            return new int[0][];
        }
        int l = newInterval[0], r = newInterval[1];
        //是否插入新集合
        boolean flag = false;
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] < l) {
                //当前集合在插入集合的左边，插入当前集合
                result.add(new int[]{interval[0], interval[1]});
            } else if (interval[0] > r) {
                //当前集合在插入集合的右边，插入需要插入的集合
                if (!flag) {
                    result.add(new int[]{l, r});
                    flag = true;
                }
                result.add(new int[]{interval[0], interval[1]});
            } else {
                //重叠，计算新的集合值
                l = Math.min(l, interval[0]);
                r = Math.max(r, interval[1]);
            }
        }
        if (!flag) {
            result.add(new int[]{l, r});
        }
        return result.toArray(new int[result.size()][]);
    }
}
