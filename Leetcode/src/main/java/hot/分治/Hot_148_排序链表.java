package hot.分治;

import mode.ListNode;

/**
 * 148. 排序链表
 * 中等
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表。
 *
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * @author zhuzhiwei
 * @date 2024/4/1 19:18
 */
public class Hot_148_排序链表 {

    /**
     * 自上向下归并排序
     *
     * 1、通过快慢指针，找到链表的中间位置，将链表分成左右两个链表
     * 2、针对拆分后的左右链表，执行步骤1。直到链表长度为1。
     * 3、合并链表
     *
     * 合并左右链表 => 合并有序链表
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        //分成两个链表
        ListNode rightListNode = slow.next;
        slow.next = null;

        ListNode leftListNode = sortList(head);
        rightListNode = sortList(rightListNode);

        return mergedSortListNode(leftListNode, rightListNode);
    }


    /**
     * 自底向上
     *
     * 遍历链表
     *      1、每次合并长度为i（i初始为1，下次为2、4依次类推）的子链表合并。
     *          => 将链表分为三部分：h1、h2、剩余的链表
     *      2、子链表长度翻倍，重复步骤1，直到i长度 >= 链表长度
     *
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHead = new ListNode(-1, head);
        ListNode p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }

        for (int subLength = 1; subLength < length; subLength <<= 1) {

            ListNode cur = preHead.next, pre = preHead;
            while (cur != null) {
                //拆分h1
                ListNode h1 = cur;
                for (int i = 1; i < subLength; i++) {
                    //cur 在次肯定不会为空
                    if (cur.next != null) {
                        cur = cur.next;
                    }
                }
                //断开h1
                ListNode h2 = cur.next;
                cur.next = null;
                cur = h2;

                //拆分h2
                for (int i = 1; i < subLength; i++) {
                    if (cur != null && cur.next != null) {
                        cur = cur.next;
                    }
                }
                //断开h2
                if (cur != null) {
                    //剩下的链表
                    ListNode more = cur.next;
                    cur.next = null;
                    cur = more;
                }
                //合并h1、h2
                ListNode mergeListNode = mergedSortListNode(h1, h2);
                //将合并后的链表连接起来
                pre.next = mergeListNode;

                //移动pre
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
        }
        return preHead.next;
    }

    /**
     * 合并有序链表
     * @param list1
     * @param list2
     * @return
     */
    private ListNode mergedSortListNode(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode preHead = new ListNode(-1, list1);
        ListNode pre = preHead, p = list1, q = list2;
        while (p != null && q != null) {
            while (p != null && p.val < q.val) {
                pre = pre.next;
                p = p.next;
            }
            ListNode qNext = q.next;
            pre.next = q;
            q.next = p;
            pre = pre.next;
            q = qNext;
        }
        if (q != null) {
            pre.next = q;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,1,3};
        ListNode listNode = ListNode.getListNode(arr);
        ListNode listNode1 = new Hot_148_排序链表().sortList2(listNode);
        System.out.println(listNode1);
    }

}
