package hot.链表;

import mode.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 82. 删除排序链表中的重复元素 II
 * 中等
 *
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回已排序的链表 。
 *
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 *
 * @author zhuzhiwei
 * @date 2024/3/20 14:41
 */
public class Hot_82_删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preHead = new ListNode(-1, null);
        Set<Integer> removeSet = new HashSet<>();
        ListNode pre = preHead, p = head;
        while (p != null) {
            if ((p.next != null && p.val == p.next.val) || removeSet.contains(p.val)) {
                removeSet.add(p.val);
                p = p.next;
                continue;
            }
            //尾插法
            ListNode preNext = pre.next, pNext = p.next;
            pre.next = p;
            p.next = preNext;
            pre = pre.next;
            p = pNext;
        }
        return preHead.next;
    }
}
