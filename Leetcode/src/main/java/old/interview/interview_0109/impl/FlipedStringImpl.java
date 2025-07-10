package interview.interview_0109.impl;

import interview.interview_0109.FlipedString;

/**
 * 切片拼接比较
 *
 * @Author: zhuzw
 * @Date: 2021-06-21 14:32
 * @Version: 1.0
 */
public class FlipedStringImpl implements FlipedString {
    @Override
    public boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        for (int i = 1; i < s1.length(); i++) {
            if ((s1.substring(i) + s1.substring(0, i)).equals(s2)) {
                return true;
            }
        }
        return false;
    }
}
