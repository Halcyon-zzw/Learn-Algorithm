package normal.normal_2.impl;

import mode.ListNode;
import normal.normal_2.AddTwoNumbers;
import utils.TestUtils;

/**
 * 模拟相加过程
 *
 * @Author: zhuzw
 * @Date: 2021-05-06 17:14
 * @Version: 1.0
 */
public class AddTwoNumbersImpl implements AddTwoNumbers {
    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carry;
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            }else {
                carry = 0;
            }
            ListNode temp = new ListNode(sum);
            p.next = temp;
            p = temp;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            ListNode temp = new ListNode(carry);
            p.next = temp;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.getListNode(new int[]{2, 4, 9});
        ListNode l2 = ListNode.getListNode(new int[]{5, 6, 4});
        Class<AddTwoNumbersImpl> clazz = AddTwoNumbersImpl.class;
        TestUtils.test(clazz, l1, l2);
    }
}
