package hot.链表;

import mode.ListNode;

import java.util.Stack;

/**
 * 206. 反转链表
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * @author zhuzhiwei
 * @date 2023/11/27 15:59
 */
public class Hot_206_反转链表 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
//        int[] arr = {1};
        final ListNode head = ListNode.getListNode(arr);
        ListNode listNode = new Hot_206_反转链表().reverseListByStack(head);
        System.out.println(listNode);
    }

    /**
     * 头插入法反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode newHead = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }

    public ListNode reverseListByStack(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        //入栈
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        //出栈，反转
        head = stack.pop();
        ListNode p1 = head, p2 = head;
        while (!stack.isEmpty()) {
            p2 = stack.pop();
            p1.next = p2;
            p1 = p2;
        }
        p2.next = null;
        return head;
    }
}

