package hot.动态规划;

/**
 * 97. 交错字符串
 * 中等
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干非空子字符串：
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 *
 * 示例 1：
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 *
 * 示例 2：
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 *
 * 示例 3：
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 *
 *
 * 提示：
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 *
 *
 * 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它?
 *
 * @author zhuzhiwei
 * @date 2024/4/23 14:00
 */
public class Hot_97_交错字符串 {
    public boolean isInterleave(String s1, String s2, String s3) {
        return isInterleave2(s1, s2, s3);
    }
    /**
     * 动态规划
     * 类似于每次只能向右或向下移动，求从左上角是否能到达右下角
     * s1的字符做为行，s2的字符做为列，位置都从下标1开始
     * 向右移动表示选择s2的字符，向下移动表示选择s1的字符。
     * 能否移动则判断s3的当前字符是否等于需要选择的字符
     *      s3当前的字符：s3.chatAt(i + j - 1)
     *      向右移动：s2.chatAt(j - 1)
     *      向下移动：s1.chat(i - 1)
     *
     * dp[i][j]表示从左上角是否能到达arr[i][j]位置
     *
     * dp[0][0] = true
     * dp[i][j] =
     *      i == 0: = dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt[j - 1]
     *      j == 0：= dp[i - 1][j] && s3.chatAt(i + j - 1) == s1.chatAt[i - 1]
     *      i > 0 && j > 0:
     *              = (dp[i - 1][j] && s3.chatAt(i + j - 1) == s1.chatAt[i - 1])
     *              || (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt[j - 1])
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                char cur3 = s3.charAt(i + j - 1);
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && cur3 == s2.charAt(j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && cur3 == s1.charAt(i - 1);
                } else {
                    dp[i][j] = (dp[i][j - 1] && cur3 == s2.charAt(j - 1))
                            || (dp[i - 1][j] && cur3 == s1.charAt(i - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    /**
     * 空间复杂度优化
     * 第i行的结果只和i-1行有关系，采用滚动数据优化
     *
     * dp[j] 表示当前行的结果
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[] dp = new boolean[s2.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                char cur3 = s3.charAt(i + j - 1);
                if (i == 0) {
                    dp[j] = dp[j - 1] && cur3 == s2.charAt(j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && cur3 == s1.charAt(i - 1);
                } else {
                    dp[j] = (dp[j - 1] && cur3 == s2.charAt(j - 1))
                            || (dp[j] && cur3 == s1.charAt(i - 1));
                }
            }
        }
        return dp[s2.length()];
    }
}
