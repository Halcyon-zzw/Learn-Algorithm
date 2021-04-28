package offer.offer_1_50.offer_25.impl;

import offer.mode.ListNode;
import offer.offer_1_50.offer_25.MergeTwoLists;

/**
 * 合并至第一条链表上
 *
 * @Author: zhuzw
 * @Date: 2021-04-20 15:30
 * @Version: 1.0
 */
public class MergeTwoListsByMergeOneImpl implements MergeTwoLists {
    @Override
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        head.next = l1;
        ListNode cur1 = l1, cur2 = l2, pre1 = head, next2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val >= cur2.val) {
                next2 = cur2.next;
                cur2.next = cur1;
                pre1.next = cur2;
                pre1 = pre1.next;
                cur2 = next2;
            }else {
                pre1 = pre1.next;
                cur1 = cur1.next;
            }
        }
        if (cur2 != null) {
            pre1.next = cur2;
        }
        return head.next;
    }
}
