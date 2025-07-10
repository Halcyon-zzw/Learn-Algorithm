package old.offer.offer_62.impl;

import mode.ListNode;
import old.offer.offer_62.LastRemaining;
import utils.TestUtils;

/**
 * 模拟删除
 *
 * 因为
 *   1 <= n <= 10^5
 *   1 <= m <= 10^6
 * 所以超时
 *
 * @Author: zhuzw
 * @Date: 2021-04-26 19:03
 * @Version: 1.0
 */
public class LastRemainingImpl implements LastRemaining {
    @Override
    public int lastRemaining(int n, int m) {
        if (m == 1) {
            return n - 1;
        }
        ListNode head = createNode(n);
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode p = head;
        int size = n;
        //移动的次数 , 删除第几即移动m - 1 次
        int time = (m - 1) % size;
        while (true) {
            if (p == null) {
                p = head;
            }
            if (pre == null) {
                pre = head;
            }
            if (time > 0) {
                //移动
                pre = pre.next;
                p = p.next;
                time--;
            }else if (time == 0){
                //删除
                System.out.print(p.val + " ");
                if (p == head) {
                    head = head.next;
                }
                if (pre.next == null) {
                    p = p.next;
                }else {
                    p = p.next;
                    pre.next = p;
                }
                if (--size == 1) {
                    break;
                }
                time = (m - 1) % size;
            }
        }
        return head.val;
    }

    private ListNode createNode(int n) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int i = 0; i < n; i++) {
            ListNode listNode = new ListNode(i);
            p.next = listNode;
            p = listNode;
        }
        return head.next;
    }

    public static void main(String[] args) {

//        TestUtils.test(LastRemainingImpl.class, 5, 3);
//        TestUtils.test(LastRemainingImpl.class, 10, 17);
//        TestUtils.test(LastRemainingImpl.class, 5, 1);
//        TestUtils.test(LastRemainingImpl.class, 6, 7);  //4
        TestUtils.test(LastRemainingImpl.class, 70866, 116922);  //4
    }
}
