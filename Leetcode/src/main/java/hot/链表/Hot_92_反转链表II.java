package hot.链表;

import mode.ListNode;

/**
 * 92. 反转链表 II
 * 中等
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 * @author zhuzhiwei
 * @date 2024/3/19 20:03
 */
public class Hot_92_反转链表II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }

        ListNode preHead = new ListNode(-1, head);
        ListNode pre = preHead, next = pre.next;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode p = pre.next.next, leftNode = pre.next, rightNode = pre.next;
        for (int i = 0; i < right - left; i++) {
            next = p.next;
            p.next = rightNode;
            rightNode = p;
            p = next;
        }
        leftNode.next = p;
        pre.next = rightNode;

        return preHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int left = 2, right = 4;

        ListNode listNode = ListNode.getListNode(arr);
        ListNode listNode1 = new Hot_92_反转链表II().reverseBetween(listNode, left, right);
        System.out.println(listNode1.toString());
    }
}
