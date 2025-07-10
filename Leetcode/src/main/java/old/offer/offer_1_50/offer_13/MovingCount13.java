package old.offer.offer_1_50.offer_13;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-17 22:33
 * @Version: 1.0
 */
public class MovingCount13 {
    public int movingCount(int m, int n, int k) {
        int[][] board = new int[m][n];
        boolean[][] visitedArr = new boolean[m][n];
        int count = 0;
        return dfs(board, 0, 0, k, visitedArr);
    }
    /**
     * 深度优先遍历
     * @param board 原始数组
     * @param i 数组当前位置
     * @param j
     * @param k 阈值
     * @param visitedArr 状态数组
     * @return
     */
    private int dfs(int[][] board, int i, int j, int k, boolean[][] visitedArr) {
        //判断数组范围
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return 0;
        }
        if (visitedArr[i][j]) {
            return 0;
        }
        if (addEachLocation(i) + addEachLocation(j) > k) {
            return 0;
        }
        visitedArr[i][j] = true;
        return 1 + dfs(board, i - 1, j, k, visitedArr) +
                dfs(board, i + 1, j, k, visitedArr) +
                dfs(board, i, j - 1, k, visitedArr) +
                dfs(board, i, j + 1, k, visitedArr);

    }

    public int addEachLocation(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    public String[][] createIndexArr(int m, int n) {
        String[][] indexArr = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                indexArr[i][j] = "[" + i + "," + j + "]";
            }
        }
        return indexArr;
    }

    public static void main(String[] args) {
        MovingCount13 movingCount13 = new MovingCount13();
        int i = movingCount13.movingCount(16, 8, 4);
        System.out.println(i);
        String[][] indexArr = movingCount13.createIndexArr(16, 5);
        for (int i1 = 0; i1 < indexArr.length; i1++) {
            for (int i2 = 0; i2 < indexArr[i1].length; i2++) {
                System.out.print(indexArr[i1][i2]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
