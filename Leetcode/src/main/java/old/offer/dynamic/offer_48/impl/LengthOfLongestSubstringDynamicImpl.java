package old.offer.dynamic.offer_48.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态规划实现
 * f(i) = {
 *     if val(i) 未出现过       f(i) = f(i - 1) + 1
 *     if val(i) 出现过
 *          if d > f(i - 1)     f(i) = f(i - 1) + 1
 *          if d <=             f(i) = d
 * }
 *
 * 初始状态: f(0) = 1;
 *
 * @Author: zhuzw
 * @Date: 2021-04-23 17:21
 * @Version: 1.0
 */
public class LengthOfLongestSubstringDynamicImpl implements LengthOfLongestSubstring {
    @Override
    public int lengthOfLongestSubstring(String str) {
        int longest = 1;
        int curLongest = 1;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        charIndexMap.put(str.charAt(0), 0);
        for (int i = 1; i < str.length(); i++) {
            Integer lastIndex = charIndexMap.get(str.charAt(i));
            charIndexMap.put(str.charAt(i), i);
            if (lastIndex == null) {
                curLongest++;
            }else {
                int d = i - lastIndex;
                if (d > curLongest) {
                    curLongest++;
                }else {
                    curLongest = d;
                }
            }
            if (curLongest > longest) {
                longest = curLongest;
            }
        }

        return longest;
    }
}
