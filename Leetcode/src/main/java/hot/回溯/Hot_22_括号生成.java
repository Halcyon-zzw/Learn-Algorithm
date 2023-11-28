package hot.回溯;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *
 * 提示：
 * 1 <= n <= 8
 *
 * @author zhuzhiwei
 * @date 2023/11/24 16:38
 */
public class Hot_22_括号生成 {

    private final List<String> resultList = new ArrayList<>();


    /**
     * 前提：生成了左括号才能生成右括号
     * lNum表示已经生成的左括号数量，rNum：已经生成的右括号数量
     *
     * 生成逻辑：
     *      生成左括号或者右括号
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {

        StringBuilder sb = new StringBuilder();
        int lNum = 0, rNum = 0;
        dfs(n, sb, lNum, rNum);

        return resultList;
    }

    private void dfs(int n, StringBuilder sb, int lNum, int rNum) {
        if (sb.length() == n * 2) {
            resultList.add(sb.toString());
            return;
        }
        if (lNum < n) {
            sb.append("(");
            dfs(n, sb, lNum + 1, rNum);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (lNum > rNum) {
            sb.append(")");
            dfs(n, sb, lNum, rNum + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> resultList = new Hot_22_括号生成().generateParenthesis(3);
        System.out.println(ArrayUtils.toString(resultList));
    }
}