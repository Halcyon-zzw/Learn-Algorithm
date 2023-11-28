package hot.链表;

import mode.ListNode;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * @author zhuzhiwei
 * @date 2023/11/28 11:37
 */
public class Hot_141_环型链表 {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode s = head, f = head.next;

        while (s != f) {
            if (f == null || f.next == null) {
                return false;
            }
            s = s.next;
            f = f.next.next;
        }
        return false;
    }
}
