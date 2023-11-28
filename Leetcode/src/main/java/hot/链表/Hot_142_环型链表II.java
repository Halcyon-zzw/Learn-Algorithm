package hot.链表;

import mode.ListNode;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * @author zhuzhiwei
 * @date 2023/11/28 11:37
 */
public class Hot_142_环型链表II {
    /**
     * 证明：
     * a:环前面的长度
     * b:相交点
     * c:相交点距离环口的位置
     *
     * 慢指针一定没走完整的一圈
     *
     * 慢指针走的路：a + b
     * 快指针走的路：a + n(b + c) + b
     * a + n(b + c) + b = 2(a + b)
     * a = n (b + c) - b
     *
     * 故从相交点再遍历a => a + b = n(b + c) - b + b = n(b + c)，
     * 刚好在圆的入口
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode s = head, f = head.next;
        while (s != f) {
            if (f == null || f.next == null) {
                return null;
            }
            s = s.next;
            f = f.next.next;
        }
        //p = head相当于已经走了一步，所以f也需要走一步
        ListNode p = head;
        f = f.next;
        while (p != f) {
            f = f.next;
            p = p.next;
        }
        return f;
    }
}
