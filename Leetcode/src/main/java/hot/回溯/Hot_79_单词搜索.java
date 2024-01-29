package hot.回溯;

/**
 * 79. 单词搜索
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * @author zhuzhiwei
 * @date 2023/12/14 16:40
 */
public class Hot_79_单词搜索 {
    /**
     * 回溯:
     * 遍历数组，找到第一个目标字符。
     * 从该字符开始，上下左右探索，直到找到目标字符串。
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char firstChar = word.charAt(0);
        //标记当前位置是否被使用
        boolean[][] boardFlag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == firstChar) {
                    boardFlag[i][j] = true;
                    if (dfs(board, i, j, boardFlag, 1, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, boolean[][] boardFlag, int equalCount, String word) {
        if (equalCount == word.length()) {
            return true;
        }
        //判断上
        if (i - 1 >= 0 && !boardFlag[i - 1][j] && equalCount < word.length() && board[i - 1][j] == word.charAt(equalCount)) {
            boardFlag[i - 1][j] = true;
            if (dfs(board, i - 1, j, boardFlag, equalCount + 1, word)) {
                return true;
            }
        }
        //判断下
        if (i + 1 < board.length && !boardFlag[i + 1][j] && equalCount < word.length() && board[i + 1][j] == word.charAt(equalCount)) {
            boardFlag[i + 1][j] = true;
            if (dfs(board, i + 1, j, boardFlag, equalCount + 1, word)) {
                return true;
            }
        }
        //判断左
        if (j - 1 >= 0 && !boardFlag[i][j - 1] && equalCount < word.length() && board[i][j - 1] == word.charAt(equalCount)) {
            boardFlag[i][j - 1] = true;
            if (dfs(board, i, j - 1, boardFlag, equalCount + 1, word)) {
                return true;
            }
        }
        //判断右
        if (j + 1 < board[0].length && !boardFlag[i][j + 1] && equalCount < word.length() && board[i][j + 1] == word.charAt(equalCount)) {
            boardFlag[i][j + 1] = true;
            if (dfs(board, i, j + 1, boardFlag, equalCount + 1, word)) {
                return true;
            }
        }
        //当前值不符合，回溯
        boardFlag[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
//        char[][] board = {
//                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
//        };
//        String word = "ABCCED";
        char[][] board = {
                {'C','A','A'},{'A','A','A'},{'B','C','D'}
        };
        String word = "AAB";
        boolean exist = new Hot_79_单词搜索().exist(board, word);
        System.out.println(exist);
    }
}
