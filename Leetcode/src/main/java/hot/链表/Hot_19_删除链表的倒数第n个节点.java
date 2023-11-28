package hot.链表;

import hot.回溯.Hot_22_括号生成;
import mode.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * @author zhuzhiwei
 * @date 2023/11/28 13:38
 */
public class Hot_19_删除链表的倒数第n个节点 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ListNode head = ListNode.getListNode(arr);
        ListNode listNode = new Hot_19_删除链表的倒数第n个节点().removeNthFromEndByTwoPointer2(head, 1);
        System.out.println(listNode);
    }

    public ListNode removeNthFromEndByLength(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        if (n > length) {
            return head;
        }
        //删除头节点
        if (n == length) {
            return head.next;
        }
        ListNode pre = head, cur = head.next;
        for (int i = 0; i < length - n - 1; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = cur.next;
        return head;
    }

    public ListNode removeNthFromEndByLength2(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        if (n > length) {
            return head;
        }
        ListNode preHead = new ListNode(0, head);
        ListNode pre = preHead;
        for (int i = 0; i < length - n; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return preHead.next;
    }

    /**
     * 双指针
     *
     * r指针先移动n次
     * if r == null
     *    return head;
     *
     * pre = head、cur = head.next，并r再向后移动一次（因为cur=head.next相当于向后移动一次了）
     * pre、cur、r再一起再移动直到r == null
     *
     * pre.next = cur.next
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndByTwoPointer(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode r = head;
        for (int i = 0; i < n; i++) {
            r = r.next;
            if (r == null && i < n - 1) {
                return head;
            }
        }
        //删除第一个元素
        if (r == null) {
            return head.next;
        }
        //cur向后移动
        ListNode pre = head, cur = head.next;
        r = r.next;
        while (r != null) {
            r = r.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = cur.next;
        return head;
    }

    /**
     * 引入前置节点优化
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndByTwoPointer2(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode r = head;
        for (int i = 0; i < n; i++) {
            r = r.next;
        }
        ListNode preHead = new ListNode(0, head);
        ListNode pre = preHead;
        while (r != null) {
            r = r.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return preHead.next;
    }
}
