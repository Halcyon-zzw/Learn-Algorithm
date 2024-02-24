package hot.动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zhuzhiwei
 * @date 2024/2/21 22:20
 */
public class Hot_139_单词拆分 {
    /**
     * 动态规划
     *
     * dp[n]表示s字符串中，ture表示起始点到n处可以由wordDict组成，false表示起始点到n处不能由wordDict组成
     *
     * 假设某处n能被wordDict组成，那么该字符串由wordDict中的单词wordX结尾且dp[n - wordX.length] = true
     *
     * 起始dp[0] = true
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            for (String word : wordDict) {
                if (sub.endsWith(word) && dp[i - word.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean b = new Hot_139_单词拆分().wordBreak(s, wordDict);
        System.out.println(b);
    }
}
