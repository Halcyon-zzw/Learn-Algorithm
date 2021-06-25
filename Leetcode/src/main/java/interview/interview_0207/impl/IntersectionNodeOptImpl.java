package interview.interview_0207.impl;

import interview.interview_0207.IntersectionNode;
import mode.ListNode;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-22 10:41
 * @Version: 1.0
 */
public class IntersectionNodeOptImpl implements IntersectionNode {
    @Override
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA, q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }
}
