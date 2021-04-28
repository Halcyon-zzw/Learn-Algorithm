package offer.offer_1_50.offer_25.impl;

import offer.mode.ListNode;
import offer.offer_1_50.offer_25.MergeTwoLists;

/**
 * 合并到新的有序链表中
 *
 * @Author: zhuzw
 * @Date: 2021-04-20 15:15
 * @Version: 1.0
 */
public class MergeTwoListsByCreateNewImpl implements MergeTwoLists {
    @Override
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                cur.next = new ListNode(p2.val);
                p2 = p2.next;
            }else {
                cur.next = new ListNode(p1.val);
                p1 = p1.next;
            }
            cur = cur.next;
        }
        while (p1 != null) {
            cur.next = new ListNode(p1.val);
            p1 = p1.next;
            cur = cur.next;
        }
        while (p2 != null) {
            cur.next = new ListNode(p2.val);
            p2 = p2.next;
            cur = cur.next;
        }
        return newHead.next;
    }
}
