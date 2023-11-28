package mode;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-20 13:35
 * @Version: 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "->" + next;
    }

    public static ListNode getListNode(int[] arr) {
        ListNode cur = null;
        ListNode head = null;
        for (int i : arr) {

            ListNode node = new ListNode(i);
            if (cur != null) {
                cur.next = node;
            }
            if (head == null) {
                head = node;
            }
            cur = node;
        }

        return head;
    }
}
