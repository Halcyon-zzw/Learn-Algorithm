package old.offer.offer_1_50.offer_22;

import mode.ListNode;

import java.util.Stack;

/**
 *  链表中倒数第k个节点
 *
 * @Author: zhuzw
 * @Date: 2021-04-20 13:36
 * @Version: 1.0
 */
public class GetKthFromEnd {

    public ListNode getKthFromEnd2(ListNode head, int k) {
        Stack<ListNode> stack = new Stack();
        ListNode tempNode = head;
        while (tempNode != null) {
            stack.push(tempNode);
            tempNode = tempNode.next;
        }
        ListNode result = null;
        while (k > 0) {
            result = stack.pop();
            k--;
        }
        return result;
    }

    /**
     * 遍历两次，第一次确定长度，第二次确定遍历的次数
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode tempNode = head;
        int count = 0;
        while (tempNode != null) {
            tempNode = tempNode.next;
            count++;
        }
        int time = count - k;
        if (time < 0) {
            return null;
        }
        tempNode = head;
        while (time > 0) {
            tempNode = tempNode.next;
            time--;
        }
        return tempNode;
    }

    /**
     * 快慢指针，先让快指针走k步，然后两个指针同步走，当快指针走到头时，慢指针就是链表倒数第k个节点。
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd3(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        if (fast == null) {
            return null;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        GetKthFromEnd getKthFromEnd = new GetKthFromEnd();
        int[] arr = {1,2,3,4,5};
        final ListNode head = ListNode.getListNode(arr);

        ListNode kthFromEnd = getKthFromEnd.getKthFromEnd(head, 2);
        System.out.println(kthFromEnd);
    }
}
