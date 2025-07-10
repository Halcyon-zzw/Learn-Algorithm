package interview.interview_0206.impl;

import interview.interview_0206.Palindrome;
import mode.ListNode;

/**
 * 递归实现
 *
 * @Author: zhuzw
 * @Date: 2021-06-22 9:27
 * @Version: 1.0
 */
public class PalindromeByNamicImpl implements Palindrome {
    ListNode frontPointer;
    @Override
    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return checkPalindrome(head);
    }

    private boolean checkPalindrome(ListNode cur) {
        if (cur != null) {
            if (!checkPalindrome(cur.next)) {
                return false;
            }
            if (cur.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }
}
