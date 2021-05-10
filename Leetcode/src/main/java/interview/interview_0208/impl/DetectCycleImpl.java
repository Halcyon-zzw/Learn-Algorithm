package interview.interview_0208.impl;

import interview.interview_0208.DetectCycle;
import mode.ListNode;

/**
 *  <p>
 *      题解：
 *      使用快慢指针，一倍速和两倍速
 *      如果相遇必存在环。类似跑道，一定相遇。因为距离每次缩短1，所以不存在跨过的情况
 *
 *      环开头的位置：
 *      A------B------C
 *             |      |
 *             -------
 *     A为链表头、B为环开头、C为相遇点;CB指，从相遇点到环开头的距离;n：表示快指针遍历的完整圈数
 *     2(AB + BC) = AB + BC + n*len(环)
 *    =>AB + BC = n * len(环)
 *    =>AB + BC = n * (BC + CB)
 *    =>AB = (n - 1)(BC + CB) + CB
 *    =>AB = (n - 1)len(环) + CB
 *    =>所以，找到指针相遇点时，再使用两个指针，一个从链表头开始，一个从相遇点开始；
 *      相遇时，即是环开头。
 *  </p>
 *
 * @Author: zhuzw
 * @Date: 2021-05-10 13:58
 * @Version: 1.0
 */
public class DetectCycleImpl implements DetectCycle {
    @Override
    public ListNode detectCycle(ListNode head) {
        //是否存在环
        ListNode slow = head, fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow == fast) {
            //存在环
            //找环的位置
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }
}
