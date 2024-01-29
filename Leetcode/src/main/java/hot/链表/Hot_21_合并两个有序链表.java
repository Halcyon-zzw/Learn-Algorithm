package hot.链表;

import mode.ListNode;

/**
 * 21. 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author zhuzhiwei
 * @date 2023/11/28 11:50
 */
public class Hot_21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode pre1Head = new ListNode(-1, list1);
        ListNode p1 = list1, p2 = list2, pre1 = pre1Head;

        while (p1 != null && p2 != null) {
            while (p1 != null && p1.val < p2.val) {
                pre1 = pre1.next;
                p1 = p1.next;
            }
            ListNode p2Next = p2.next;
            p2.next = pre1.next;
            pre1.next = p2;
            pre1 = p2;
            p2 = p2Next;
        }
        if (p2 != null) {
            pre1.next = p2;
        }
        return pre1Head.next;
    }

    public static void main(String[] args) {
        int[] listArr1 = {1, 2, 4};
        int[] listArr2 = {1, 3, 4};

        ListNode listNode = new Hot_21_合并两个有序链表().mergeTwoLists(ListNode.getListNode(listArr1), ListNode.getListNode(listArr2));

        System.out.println(listNode);
    }
}
