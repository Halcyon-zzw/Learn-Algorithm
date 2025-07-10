package old.offer.offer_1_50.offer_13.impl;

import old.offer.offer_1_50.offer_13.MovingCount;
import utils.MathUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-19 10:36
 * @Version: 1.0
 */
public class MovingCountByBfs implements MovingCount {
    @Override
    public int movingCount(int m, int n, int k) {
        int[][] board = new int[m][n];
        boolean[][] visitedArr = new boolean[m][n];
        return bfs(board, k, visitedArr);
    }
    /**
     * 深度优先遍历
     * @param board 原始数组
     * @param k 阈值
     * @param visitedArr 状态数组
     * @return
     */
    private int bfs(int[][] board, int k, boolean[][] visitedArr) {

        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0, 0});
        int count = 0;
        while (!queue.isEmpty()) {
            int[] pollArr = queue.poll();
            int iIndex = pollArr[0];
            int jIndex = pollArr[1];
            //判断数组范围
            if (iIndex < 0 || iIndex >= board.length || jIndex < 0 || jIndex >= board[0].length) {
                continue;
            }
            if (visitedArr[iIndex][jIndex]) {
                continue;
            }
            if (MathUtil.addEachLocation(iIndex) + MathUtil.addEachLocation(jIndex) > k) {
                continue;
            }
            count++;
            visitedArr[iIndex][jIndex] = true;
            queue.add(new int[]{iIndex - 1, jIndex});
            queue.add(new int[]{iIndex + 1, jIndex});
            queue.add(new int[]{iIndex, jIndex - 1});
            queue.add(new int[]{iIndex, jIndex + 1});
        }

        return count;

    }
}
