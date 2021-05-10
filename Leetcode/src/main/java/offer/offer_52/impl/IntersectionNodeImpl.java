package offer.offer_52.impl;

import mode.ListNode;
import offer.offer_52.IntersectionNode;

/**
 * 获取两个链表的长度，
 * 长的链表先遍历两个链表长度的差值
 * 若指针处相等，则相遇
 *
 * @Author: zhuzw
 * @Date: 2021-04-25 9:18
 * @Version: 1.0
 */
public class IntersectionNodeImpl implements IntersectionNode {
    @Override
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;

        ListNode pA = headA, pB = headB;
        while (pA != null) {
            lengthA++;
            pA = pA.next;
        }
        while (pB != null) {
            lengthB++;
            pB = pB.next;
        }
        pA = headA;
        pB = headB;
        //长的链表先遍历
        if (lengthA >= lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                pA = pA.next;
            }
        }else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                pB = pB.next;
            }
        }
        while (pA != null) {
            if (pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }
}
