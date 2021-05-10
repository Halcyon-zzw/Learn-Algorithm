package offer.offer_1_50.offer_24.impl;

import mode.ListNode;
import offer.offer_1_50.offer_24.ReverseListInterface;

/**
 * 遍历链表，
 * 并创建新的链表，采用头插法创建插入节点
 *
 * @Author: zhuzw
 * @Date: 2021-04-20 14:47
 * @Version: 1.0
 */
public class ReverseListByCreateNewListImpl implements ReverseListInterface {
    @Override
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode newHead = null;
        while (cur != null) {
            ListNode next = cur.next;
            //头插，并保证头节点在首位
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }
}
