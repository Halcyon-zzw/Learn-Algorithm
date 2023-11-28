package hot.链表;

import mode.ListNode;

/**
 *
 *
 * @author zhuzhiwei
 * @date 2023/11/24 18:14
 */
public class Hot_160_相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = 0, bLength = 0;
        ListNode p1 = headA, p2 = headB;
        while (p1 != null) {
            p1 = p1.next;
            aLength++;
        }
        while (p2 != null) {
            p2 = p2.next;
            bLength++;
        }
        p1 = headA;
        p2 = headB;
        if (aLength > bLength) {
            for (int i = 0; i < aLength - bLength; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < bLength - aLength; i++) {
                p2 = p2.next;
            }
        }
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}