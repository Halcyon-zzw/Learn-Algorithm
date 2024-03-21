package hot.链表;

import mode.ListNode;

/**
 * 61. 旋转链表
 * 中等
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 示例 2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *
 * 提示：
 * 链表中节点的数目在范围 [0, 500] 内
 *
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 *
 * @author zhuzhiwei
 * @date 2024/3/20 20:24
 */
public class Hot_61_旋转链表 {
    /**
     * 获取链表长度n
     * 需要旋转的数量k = k % n
     *
     *
     * 第n - k个数为旋转后的尾
     * 第n- k + 1个数为旋转后的头
     *
     * last.next = pre.next;
     * preHead.next = newHead;
     * tail.next = null
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode preHead = new ListNode(-1, head);
        ListNode p = head, q = preHead;
        int n = 0;
        while (p != null) {
            p = p.next;
            q = q.next;
            n++;
        }
        //将链表尾部接到链表头部
        q.next = preHead.next;

        //寻找旋转后的头部和尾部
        k = k % n;
        p = preHead;
        for (int i = 0; i < n - k; i++) {
            p = p.next;
        }
        ListNode tail = p, newHead = p.next;
        tail.next = null;
        preHead.next = newHead;
        return preHead.next;
    }
}
