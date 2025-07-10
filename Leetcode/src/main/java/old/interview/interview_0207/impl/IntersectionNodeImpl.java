package interview.interview_0207.impl;

import interview.interview_0207.IntersectionNode;
import mode.ListNode;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-22 10:08
 * @Version: 1.0
 */
public class IntersectionNodeImpl implements IntersectionNode {
    @Override
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA, q = headB;
        while (!(p == null && q == null)) {
            if (p == q) {
                return p;
            }
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return null;
    }
}
