package hot.动态规划;

/**
 * 5. 最长回文子串
 * 中等
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * @author zhuzhiwei
 * @date 2024/4/17 09:57
 */
public class Hot_5_最长回文子串 {
    public String longestPalindrome(String s) {
        return longestPalindrome1(s);
    }
    /**
     * 中心扩展方法：
     * 计算以每个字符串为中心的最大回文子串
     *
     * 1、确定位置i，left = i - 1, right = i + 1
     * 2、i左边等于i位置字符时，left--; i右边等于i位置字符时right++;
     * 3、s.charAt(left) == s.chatAt(right)时，left--、right++;
     * 最大回文子串 = right - left - 1
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int startIndex = 0, endIndex = 0, maxLength = 0;
        int left, right;
        for (int i = 0; i < s.length(); i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(i) == s.charAt(left)) {
                left--;
            }
            while (right < s.length() && s.charAt(i) == s.charAt(right)) {
                right++;
            }
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right - left - 1 > maxLength) {
                startIndex = left + 1;
                endIndex = right;
                maxLength = right - left - 1;
            }
        }
        return s.substring(startIndex, endIndex);
    }


    /**
     * 动态规划
     *
     * dp[l][r] 表示l到r是否为回文串
     *
     * dp[l][r] =
     *      r - l <= 2 && s.charAt(l) == s.charAt(r)  说明: l == r时同样满足
     *          true
     *      else
     *          dp[l + 1][r - 1] && s.charAt(l) == s.charAt(r)
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int startIndex = 0, endIndex = 0, maxLength = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        //以index=1的结尾开始遍历
        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLength) {
                        maxLength = r - l + 1;
                        startIndex = l;
                        endIndex = r;
                    }
                }
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }
}
