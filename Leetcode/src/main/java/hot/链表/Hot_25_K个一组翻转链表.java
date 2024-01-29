package hot.链表;

import mode.ListNode;

import java.util.Stack;

/**
 * 25. K 个一组翻转链表
 *
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * @author zhuzhiwei
 * @date 2023/12/12 20:27
 */
public class Hot_25_K个一组翻转链表 {
    /**
     * 栈
     * 遍历链表 p -> head
     *      入栈
     *      if (栈个数 == k):
     *          出栈
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode reverseHead = head;
        for (int i = 0; i < k - 1; i++) {
            reverseHead = reverseHead == null ? null : reverseHead.next;
        }

        ListNode p = head, pre = new ListNode(-1, head);
        Stack<ListNode> stack = new Stack<>();
        while (p != null) {
            stack.push(p);
            p = p.next;
            if (stack.size() == k) {
                while (!stack.isEmpty()) {
                    pre.next = stack.pop();
                    pre = pre.next;
                }
                //串起余下的链表，剩下的元素保持原来的顺序
                pre.next = p;
            }
        }
        return reverseHead == null ? head : reverseHead;
    }

    /**
     * 头插法：
     * 先计算链表的长度，便于对剩下的链表不处理
     *
     * for i : length / k * k
     *     头插法;
     *     if time == k
     *          向后移动k
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode resultHead = null;
        ListNode pre = new ListNode(-1, head), p = head;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }
        p = head;
        int count = 0;
        ListNode tail = null;
        for (int i = 0; i < length / k * k; i++) {
            ListNode pNext = p.next;
            if (count % k == 0) {
                tail = pre.next;
            } else {
                tail.next = pNext;
                p.next = pre.next;
                pre.next = p;
            }
            p = pNext;
            count++;
            if (count == k) {
                resultHead = pre.next;
            }
            if (count % k == 0) {
                for (int j = 0; j < k; j++) {
                    pre = pre.next;
                }
            }
        }
        return resultHead;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode listNode = new Hot_25_K个一组翻转链表().reverseKGroup2(ListNode.getListNode(arr), 3);
        System.out.println(listNode);
    }
}
