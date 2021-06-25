package offer.offer_52;

import mode.ListNode;

/**
 * 链表交点
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 *
 * @Author: zhuzw
 * @Date: 2021-04-25 9:18
 * @Version: 1.0
 */
public interface IntersectionNode {
    ListNode getIntersectionNode(ListNode headA, ListNode headB);
}
