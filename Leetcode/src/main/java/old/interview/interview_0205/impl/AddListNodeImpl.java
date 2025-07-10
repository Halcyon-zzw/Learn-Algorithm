package interview.interview_0205.impl;

import interview.interview_0205.AddListNode;
import mode.ListNode;
import utils.TestUtils;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-21 17:00
 * @Version: 1.0
 */
public class AddListNodeImpl implements AddListNode {
    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p = l1, q = l2;
        //a:链表1的值，b:链表2的值，carry：进位
        int a = 0, b = 0, carry = 0;
        ListNode result = new ListNode(-1);
        ListNode head = result;
        while (p != null || q != null || carry != 0) {
            if (p != null) {
                a = p.val;
                p = p.next;
            }else {
                a = 0;
            }
            if (q != null) {
                b = q.val;
                q = q.next;
            }else {
                b = 0;
            }
            int sum = a + b + carry;
            carry = sum / 10;
            result.next = new ListNode(sum % 10);
            result = result.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        TestUtils.test(AddListNodeImpl.class, new ListNode(5), new ListNode(5));
    }
}
