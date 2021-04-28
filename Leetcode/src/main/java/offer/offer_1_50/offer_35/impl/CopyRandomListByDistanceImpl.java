package offer.offer_1_50.offer_35.impl;

import offer.mode.Node;
import offer.offer_1_50.offer_35.CopyRandomList;

/**
 * 通过与头节点的距离实现random的复制
 *
 * 使用两轮遍历
 * 第一次仅复制next  O(n)
 * 第二次通过头节点到random的距离复制O(N^2)
 *
 * @Author: zhuzw
 * @Date: 2021-04-22 14:06
 * @Version: 1.0
 */
public class CopyRandomListByDistanceImpl implements CopyRandomList {
    @Override
    public Node copyRandomList(Node head) {
        Node p = head;
        Node newHead = new Node(-1);
        Node q = newHead;
        while (p != null) {
            Node newNode = new Node(p.val);
            q.next = newNode;
            q = newNode;
            p = p.next;
        }
        p = head;
        newHead = newHead.next;
        q = newHead;
        Node pHead;
        Node qHead;
        while (p != null) {
            Node random = p.random;
            pHead = head;
            qHead = newHead;
            if (random == null) {
                qHead = null;
            }
            while (random != null && pHead != random) {
                pHead = pHead.next;
                qHead = qHead.next;
            }
            q.random = qHead;
            p = p.next;
            q = q.next;
        }
        return newHead;
    }
}
