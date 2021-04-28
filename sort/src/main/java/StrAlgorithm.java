import java.util.*;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-16 9:40
 * @Version: 1.0
 */
public class StrAlgorithm {
    /**
     * 动态规划实现
     * @param str
     * @return
     */
    public int lengthOfLongestSubstring1(String str) {
        int maxSubStrLength = 0;
        int curStrlength = 0;
        char[] chars = str.toCharArray();
        //字符上一次出现的位置
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Integer lastIndex = charIndexMap.get(chars[i]);
            charIndexMap.put(chars[i], i);
            if (lastIndex == null) {
                curStrlength ++;
            }else {
                int d = i - lastIndex;
                if (d > curStrlength) {
                    curStrlength++;
                }else {
                    curStrlength = d;
                }
            }
            if (maxSubStrLength < curStrlength) {
                maxSubStrLength = curStrlength;
            }
        }
        return maxSubStrLength;
    }

    /**
     * 滑动窗口实现
     * @param str
     * @return
     */
    public int lengthOfLongestSubstring2(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] chars = str.toCharArray();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (deque.contains(chars[i])) {
                while (deque.getFirst() != chars[i]) {
                    deque.removeFirst();
                }
                deque.removeFirst();
            }
            deque.addLast(chars[i]);

            max = Math.max(max, deque.size());
        }
        return max;
    }
}
