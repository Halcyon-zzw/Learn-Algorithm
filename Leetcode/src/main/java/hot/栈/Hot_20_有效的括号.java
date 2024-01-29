package hot.栈;

import java.util.*;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * @author zhuzhiwei
 * @date 2023/12/27 11:04
 */
public class Hot_20_有效的括号 {
    /**
     * 遍历s
     *      if 左括号，入栈
     *      else 出栈，判断是否匹配
     *          不匹配返回false
     * if stack 是空
     *      return ture
     * else false
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('-');
        char[] chars = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                Character cPop = stack.pop();
                if (!Objects.equals(map.get(c), cPop)) {
                    return false;
                }
            }
        }
        return stack.size() == 1;
    }
}
