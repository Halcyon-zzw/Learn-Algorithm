package offer.offer_1_50.offer_24.impl;

import mode.ListNode;
import offer.offer_1_50.offer_24.ReverseListInterface;

import java.util.Stack;

/**
 * 通过栈得到链表的反序值，
 * 后通过后插法生成新的链表
 *
 * @Author: zhuzw
 * @Date: 2021-04-20 14:19
 * @Version: 1.0
 */
public class ReverseListByStackImpl implements ReverseListInterface {
    @Override
    public ListNode reverseList(ListNode head) {
        ListNode curNode = head;
        Stack<Integer> stack = new Stack<>();
        while (curNode != null) {
            stack.push(curNode.val);
            curNode = curNode.next;
        }
        ListNode newHead = null;
        ListNode lastNode = null;
        while (!stack.isEmpty()) {
            Integer val = stack.pop();
            curNode = new ListNode(val);
            if (newHead == null) {
                newHead = curNode;
            }
            if (lastNode != null) {
                lastNode.next = curNode;
            }
            lastNode = curNode;
        }
        return newHead;
    }
}
