package interview.interview_0208.impl;

import interview.interview_0208.DetectCycle;
import mode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 * @Author: zhuzw
 * @Date: 2021-05-10 14:28
 * @Version: 1.0
 */
public class DetectCycleByHashSetImpl implements DetectCycle {
    @Override
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (set.contains(p)) {
                return p;
            }
            set.add(p);
            p = p.next;
        }
        return null;
    }
}
