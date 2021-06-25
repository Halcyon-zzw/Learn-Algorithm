package interview.interview_0109.impl;

import interview.interview_0109.FlipedString;

/**
 * s2自身拼接，如果s2包含s1则是旋转所得
 *
 * @Author: zhuzw
 * @Date: 2021-06-21 14:50
 * @Version: 1.0
 */
public class FlipedStringBySplicingImpl implements FlipedString {
    @Override
    public boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        return  (s2 + s2).contains(s1);
    }
}
