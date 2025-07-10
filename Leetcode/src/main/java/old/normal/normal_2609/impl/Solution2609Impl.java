package normal.normal_2609.impl;

import normal.normal_2609.Solution2609;

/**
 * if 当前字母是0，且是第一个字母，或者前一个字母是1
 *      count_0 = 1
 *      count_1 = 0
 * else if 当前字母 == 1 {
 *     count1++;
 *     maxLength = max(maxLength, min(count_0, count_1) * 2)
 * } else {
 *     count0++;
 * }
 *
 * @author zhuzhiwei
 * @date 2023/11/8 15:01
 */
public class Solution2609Impl implements Solution2609 {
    @Override
    public final int findTheLongestBalancedSubstring(String s) {

        int maxLength = 0;
        int count0 = 0, count1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (i == 0 || s.charAt(i - 1) == '1') {
                    count0 = 1;
                    count1 = 0;
                } else {
                    count0++;
                }
            } else {
                count1++;
                maxLength = Math.max(maxLength, 2 * Math.min(count0, count1));
            }
        }

        return maxLength;
    }
}
