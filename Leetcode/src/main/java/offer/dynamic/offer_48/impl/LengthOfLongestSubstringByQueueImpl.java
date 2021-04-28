package offer.dynamic.offer_48.impl;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 通过滑动窗口实现
 *
 * 用一个队列维护当前的不同字串
 * if 不存在:
 *      add
 * else
 *      弹出，直到与该字符相同
 *      add
 *
 * @Author: zhuzw
 * @Date: 2021-04-23 18:13
 * @Version: 1.0
 */
public class LengthOfLongestSubstringByQueueImpl implements LengthOfLongestSubstring {
    @Override
    public int lengthOfLongestSubstring(String str) {
        Queue<Character> queue = new LinkedList<>();
        int longest = 0;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (!queue.contains(c)) {
                ((LinkedList<Character>) queue).addFirst(c);
                longest = Math.max(longest, queue.size());
            }else {
                while (true) {
                    Character character = ((LinkedList<Character>) queue).removeLast();
                    if (character == c) {
                        break;
                    }
                }
            }
        }
        return longest;
    }
}
