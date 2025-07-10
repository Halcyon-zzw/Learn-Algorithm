package interview.interview_0802.impl;

import interview.interview_0802.PathWithObstacles;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 *      设行i，列j
 *      到达右下角，则最后一步在[i-1,j]或[i,j-1];
 *
 * 创建一个i * j队列，值存上一个位置的值
 *
 * @Author: zhuzw
 * @Date: 2021-05-25 10:24
 * @Version: 1.0
 */
public class PathWithObstaclesByDynamicImpl implements PathWithObstacles {
    @Override
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {

        List<List<Integer>> list = new ArrayList<>();


        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {

            }
        }

        return null;
    }
}
