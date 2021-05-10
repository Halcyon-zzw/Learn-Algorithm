package mode;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-22 14:04
 * @Version: 1.0
 */
public class Node {
    public int val;
    public Node next;

    public Node random;

    public Node(int x) {
        val = x;
    }

    public static Node getListNode(int[] arr) {
        Node cur = null;
        Node head = null;
        for (int i : arr) {

            Node node = new Node(i);
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
