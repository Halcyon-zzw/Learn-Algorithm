package interview.interview_0205.impl;

import interview.interview_0205.AddListNode;
import mode.ListNode;

/**
 * 代码优化
 *
 * @Author: zhuzw
 * @Date: 2021-06-23 14:17
 * @Version: 1.0
 */
public class AddListNodeOptImpl implements AddListNode {
    @Override
    public ListNode addTwoNumbers(ListNode p, ListNode q) {
        //carry：进位
        int carry = 0;
        ListNode result = new ListNode(-1);
        ListNode head = result;
        while (p != null || q != null || carry != 0) {
            int sum = carry;
            if (p != null) {
                sum += p.val;
                p = p.next;
            }
            if (q != null) {
                sum += q.val;
                q = q.next;
            }
            carry = sum / 10;
            result.next = new ListNode(sum % 10);
            result = result.next;
        }
        return head.next;
    }
}
