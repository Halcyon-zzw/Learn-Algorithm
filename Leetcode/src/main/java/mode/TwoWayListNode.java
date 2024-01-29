package mode;

/**
 * 双向链表
 *
 * @Author: zhuzw
 * @Date: 2021-04-20 13:35
 * @Version: 1.0
 */
public class TwoWayListNode {
    public int key;

    public int val;

    public TwoWayListNode pre;

    public TwoWayListNode next;

    public TwoWayListNode(int x) {
        val = x;
    }

    public TwoWayListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public TwoWayListNode(int x, TwoWayListNode pre, TwoWayListNode next) {
        this.val = x;
        this.pre = pre;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "->" + next;
    }

//    public static TwoWayListNode getListNode(int[] arr) {
//        TwoWayListNode cur = null;
//        TwoWayListNode head = new TwoWayListNode(0);
//        for (int i : arr) {
//
//            TwoWayListNode node = new TwoWayListNode(i);
//            if (cur != null) {
//                cur.next = node;
//                node.pre = cur;
//            }
//            if (head == null) {
//                head = node;
//            }
//            cur = node;
//        }
//
//        return head;
//    }
}
