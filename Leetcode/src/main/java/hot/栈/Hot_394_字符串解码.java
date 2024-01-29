package hot.栈;

import hot.回溯.Hot_39_组合总和;

import java.util.*;

/**
 * 394. 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 *
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 *
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 *
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 * @author zhuzhiwei
 * @date 2023/12/27 11:08
 */
public class Hot_394_字符串解码 {
    /**
     * 遍历字符串，
     *      将数字、左括号、右括号变成同一个整体List
     * 遍历整体list
     *      遇到数字，入数字栈
     *      遇到'['、字符，入字符栈
     *      遇到']'解码：弹出字符，直到遇到[，并从数字栈取出数字解码，并入栈
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            if (isChar(s.charAt(index))) {
                //获取整体的字符串
                StringBuilder charStr = new StringBuilder();
                charStr.append(s.charAt(index));
                while (++index < s.length() && isChar(s.charAt(index))) {
                    charStr.append(s.charAt(index));
                }
                stack.push(charStr.toString());
            } else if (isNum(s.charAt(index))) {
                //获取整体的数字
                StringBuilder numStr = new StringBuilder();
                numStr.append(s.charAt(index));
                while (++index < s.length() && isNum(s.charAt(index))) {
                    numStr.append(s.charAt(index));
                }
                numStack.push(Integer.valueOf(numStr.toString()));
            } else if (']' == s.charAt(index)) {
                index++;
                //解码
                String popStr = stack.pop();
                String tmpStr = "";
                while (!popStr.equals("[")) {
                    tmpStr = popStr + tmpStr;
                    popStr = stack.pop();
                }
                //弹出数字
                int count = numStack.pop();
                tmpStr = tmpStr.repeat(count);
                stack.push(tmpStr);
            } else {
                //"["：入栈
                stack.push(s.charAt(index++) + "");
            }
        }
        StringBuilder result = new StringBuilder();
        for (String tmpStr : stack) {
            result.append(tmpStr);
        }
        return result.toString();
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isChar(char c) {
        return  (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args) {
//        String abc = "3[abc4[edf]]";
        String abc = "3[a]2[bc]";
//        String abc = "abc";
        String s = new Hot_394_字符串解码().decodeString(abc);
        System.out.println(s);

    }
}
