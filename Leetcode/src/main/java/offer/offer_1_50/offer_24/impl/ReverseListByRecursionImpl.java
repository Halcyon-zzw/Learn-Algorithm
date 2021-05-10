package offer.offer_1_50.offer_24.impl;

import mode.ListNode;
import offer.offer_1_50.offer_24.ReverseListInterface;

/**
 * 递归实现
 *
 * @Author: zhuzw
 * @Date: 2021-04-20 15:04
 * @Version: 1.0
 */
public class ReverseListByRecursionImpl implements ReverseListInterface {
    @Override
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
