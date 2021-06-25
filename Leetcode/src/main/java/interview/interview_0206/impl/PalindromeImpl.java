package interview.interview_0206.impl;

import interview.interview_0206.Palindrome;
import mode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 数组双指针实现，可以比用栈少比较一半的次数
 *
 * @Author: zhuzw
 * @Date: 2021-06-22 9:12
 * @Version: 1.0
 */
public class PalindromeImpl implements Palindrome {
    @Override
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        for (int i = 0, j = list.size() - 1; i < j; i++, j --) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
        }
        return true;
    }
}
