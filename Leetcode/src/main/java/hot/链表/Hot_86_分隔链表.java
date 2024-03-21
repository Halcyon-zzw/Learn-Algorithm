package hot.链表;

import mode.ListNode;

/**
 * 86. 分隔链表
 * 中等
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 * 示例 2：
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *
 * @author zhuzhiwei
 * @date 2024/3/21 14:18
 */
public class Hot_86_分隔链表 {
    /**
     * 找到第一个比目标值大（或等于）的节点bigNode,和其前置节点preBigNode
     *
     * 遇到比目标值小的节点，从链表中删除，并插入到preBigNode和bigNode直接
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode preHead = new ListNode(-1, head);
        ListNode bigNode = null, preBigNode = null, p = head, pre = preHead;
        while (p != null) {
            if (p.val >= x && bigNode == null) {
                bigNode = p;
                preBigNode = pre;
            } else if (p.val < x && bigNode != null) {
                //将之后的节点移动
                ListNode tmp = p;
                //删除
                pre.next = p.next;
                //插入
                preBigNode.next = p;
                p.next = bigNode;

                //更新指针
                preBigNode = preBigNode.next;
                p = pre.next;
            } else {
                p = p.next;
                pre = pre.next;
            }
        }
        return preHead.next;
    }
}
