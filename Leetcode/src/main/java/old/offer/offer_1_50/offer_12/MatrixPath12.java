package old.offer.offer_1_50.offer_12;

/**
 * 矩阵的路径
 *
 * @Author: zhuzw
 * @Date: 2021-04-17 20:55
 * @Version: 1.0
 */
public class MatrixPath12 {
    public boolean exist(char[][] board, String word) {
        //初始化状态数组
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean result = dfs(board, i, j, chars, 0, isVisited);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param board 原始数组
     * @param i 数组当前位置
     * @param j
     * @param chars 待匹配的字符串
     * @param cur 当前匹配字符串的位置
     * @param isVisited 状态数组
     * @return
     */
    private boolean dfs(char[][] board, int i, int j, char[] chars, int cur, boolean[][] isVisited) {
        //数组越界判断
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }

        if (isVisited[i][j] || board[i][j] != chars[cur]) {
            return false;
        }
        cur++;
        if (cur == chars.length) {
            return true;
        }
        isVisited[i][j] = true;
        //上
        boolean res = dfs(board, i - 1, j, chars, cur, isVisited) ||
                dfs(board, i + 1, j, chars, cur, isVisited) ||
                dfs(board, i, j - 1, chars, cur, isVisited) ||
                dfs(board, i, j + 1, chars, cur, isVisited);
        //完成本次遍历后需要将使用标识设置为false
        isVisited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        MatrixPath12 matrixPath12 = new MatrixPath12();
//        char[][] bora = {{'A'}};
        char[][] bora = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        boolean abcced = matrixPath12.exist(bora, "ABCCED");
        System.out.println(abcced);
    }

}
