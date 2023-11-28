package hot.回溯;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17、电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author zhuzhiwei
 * @date 2023/11/24 10:25
 */
public class Hot_17_电话号码的字母组合 {
    private final List<String> resultList = new ArrayList<>();

    private final static Map<Character, char[]> map = new HashMap<>();
    static {
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
    }
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        StringBuilder sb = new StringBuilder();

        dfs(digits, sb, 0);
        return resultList;
    }

    private void dfs(String digits, StringBuilder sb, int index) {
        //结束
        if (sb.length() == digits.length()) {
            resultList.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        char[] chars = map.get(c);
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            dfs(digits, sb, index + 1);
            sb = new StringBuilder(sb.substring(0, index));
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> strings = new Hot_17_电话号码的字母组合().letterCombinations(digits);
        String s = ArrayUtils.toString(strings);
        System.out.println(s);
    }
}
