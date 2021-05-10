package offer.offer_52.impl;

import mode.ListNode;
import offer.offer_52.IntersectionNode;

/**
 * 改进
 *
 * @Author: zhuzw
 * @Date: 2021-04-25 9:39
 * @Version: 1.0
 */
public class IntersectionNodeOptImpl implements IntersectionNode {
    @Override
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        /**
         * 当短的遍历完后，p_短 从长的开始遍历长链表剩下的长度
         * 原长链表也遍历完后，p_长 从短的开始遍历    此时，两个链表剩余的节点个数相同
         */
        while (pA != pB) {
            pA = pA != null ? pA.next : headB;
            pB = pB != null ? pB.next : headA;
        }

        return pA;
    }
}
