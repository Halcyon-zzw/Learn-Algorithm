package hot.链表;

import mode.ListNode;
import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * 234. 回文链表
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * @author zhuzhiwei
 * @date 2023/11/27 16:56
 */
public class Hot_234_回文链表 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1};
        ListNode listNode = ListNode.getListNode(arr);
        System.out.println(new Hot_234_回文链表().isPalindrome(listNode));
    }

    public boolean isPalindrome(ListNode head) {
        return isPalindromeByPointerArr(head);
    }

    /**
     * 快慢指针
     *
     * 先让后半部分链表反转
     *
     * 如果链表长度是偶数，右指针先遍历 n / 2
     * 如果是技术，右指针先遍历 n / 2 + 1。
     *
     * while 右指针不为空
     *      //比较左右指针的值是否相等
     *      if 左右指针不相等
     *          return false;
     *      左、右指针后移
     * return ture;
     * @param head
     * @return
     */
    public boolean isPalindromeByPointer(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode l = head, r = head;
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        for (int i = 0; i < length / 2; i++) {
            r = r.next;
        }
        r = length % 2 == 0 ? r : r.next;
        //TODO 反转链表


        while (r != null) {
            if (l.val != r.val) {
                return false;
            }
            r = r.next;
            l = l.next;
        }
        return true;
    }

    /**
     * 双指针
     *
     * 将链表值赋值到数组中，l从前往后，r从后往前
     * 比较l、r的值是否相等
     *
     * @param head
     * @return
     */
    public boolean isPalindromeByPointerArr(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (!Objects.equals(list.get(i), list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 栈
     *
     * 遍历链表并入栈，同时记录链表长度n
     *
     * 比较栈的前 n / 2个元素和链表的前n / 2个元素是否相等
     * @param head
     * @return
     */
    public boolean isPalindromeByStack(ListNode head) {
        if (head == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        int length = 0;
        while (p != null) {
            stack.push(p);
            length++;
            p = p.next;
        }
        //比较
        p = head;
        ListNode s = stack.pop();
        for (int i = 0; i < length / 2; i++) {
            if (p.val != s.val) {
                return false;
            }
            p = p.next;
            s = stack.pop();
        }
        return true;
    }
}
