package interview.interview_0802;

import java.util.List;

/**
 * 迷路的机器人
 *
 * <p>
 *     机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）.
 *     寻找机器人从左上角移动到右下角的路径。
 *
 *      网格中的障碍物和空位置分别用 1 和 0 来表示。
 *      返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。
 *      如果没有可行的路径，返回空数组。
 * </p>
 *

 *
 *
 * @Author: zhuzw
 * @Date: 2021-05-25 10:21
 * @Version: 1.0
 */
public interface PathWithObstacles {
    List<List<Integer>> pathWithObstacles(int[][] obstacleGrid);
}
