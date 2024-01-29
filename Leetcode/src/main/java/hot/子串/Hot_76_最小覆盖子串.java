package hot.子串;

import java.util.*;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：
 * · 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * · 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 *
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 * @author zhuzhiwei
 * @date 2023/12/11 16:38
 */
public class Hot_76_最小覆盖子串 {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        //记录s串中出现t串中字符的位置，遍历只需要遍历这些位子就行
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        char[] sChar = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < sChar.length; i++) {
            if (set.contains(sChar[i])) {
                list.add(i);
            }
        }
        if (list.size() < t.length()) {
            return "";
        }
        //记录t中每个字符出现的次数
        Map<Character, Integer> targetMap = new HashMap<>();
        char[] targetChar = t.toCharArray();
        for (int i = 0; i < targetChar.length; i++) {
            targetMap.put(targetChar[i], targetMap.getOrDefault(targetChar[i], 0) + 1);
        }
        //r直接从第t.length开始就行
        int l = 0, r = 0, resultL = -1, resultR = -1, resultLen = Integer.MAX_VALUE;
        Map<Character, Integer> curMap = new HashMap<>();
        curMap.put(sChar[list.get(0)], 1);
        while (r < list.size()) {
            if (check(curMap, targetMap)) {
                if (list.get(r) - list.get(l) < resultLen) {
                    resultLen = list.get(r) - list.get(l);
                    resultR = r;
                    resultL = l;
                }
                //找到符合的结果，尝试收缩l
                curMap.put(sChar[list.get(l)], curMap.getOrDefault(sChar[list.get(l)], 0) - 1);
                l++;
            } else {
                //没有找到，移动r，扩大窗口
                r++;
                if (r >= list.size()) {
                    break;
                }
                curMap.put(sChar[list.get(r)], curMap.getOrDefault(sChar[list.get(r)], 0) + 1);
            }

        }
        return resultL == -1 ? "" : s.substring(list.get(resultL), list.get(resultR) + 1);
    }

    private boolean check(Map<Character, Integer> curMap, Map<Character, Integer> targetMap) {
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            if (!curMap.containsKey(entry.getKey()) || curMap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "ADOBECODEBANC", t = "ABC";
        String s = "a", t = "b";
        String subStr = new Hot_76_最小覆盖子串().minWindow(s, t);
        System.out.println(subStr);
    }
}
