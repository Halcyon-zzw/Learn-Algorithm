package hot.动态规划;

/**
 * 72. 编辑距离
 * 中等
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数。
 *
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 示例 1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * 示例 2：
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 *
 * 提示：
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 *
 * @author zhuzhiwei
 * @date 2024/4/23 14:09
 */
public class Hot_72_编辑距离 {
    /**
     * 动态规划
     * dp[i][j]表示word1的前i个字符到word2的编辑距离
     *
     * 需要求出dp[i][j]可以有下列三种操作：
     * 1、在word1最后的字符插入一个字符： dp[i][j - 1] + 1
     * 2、在word1后删除一个字符: dp[i - 1][j] + 1
     * 3、替换最后的字符:
     *      最后的字符相等时: dp[i - 1][j - 1]
     *      最后的字符不相等时: dp[i - 1][j - 1] + 1
     *
     * dp[i][j] = min(上述三种操作)
     *
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        dp[0][0] = 0;
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + 1;
                } else {
                    int min = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                    int replaceNum = dp[i - 1][j - 1];
                    if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                        replaceNum++;
                    }
                    dp[i][j] = Math.min(min, replaceNum);
                }
            }
        }
        return dp[l1][l2];
    }
}
