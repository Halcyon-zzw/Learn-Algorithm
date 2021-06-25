package offer.offer_1_50.offer_35.impl;

import mode.Node;
import offer.offer_1_50.offer_35.CopyRandomList;

/**
 * 拼接 + 拆分实现
 * <p>
 * 在原链表每个节点后拼接当前节点
 * 组装节点random关系
 * 拆分
 *
 * @Author: zhuzw
 * @Date: 2021-04-22 14:31
 * @Version: 1.0
 */
public class CopyRandomListBySplitImpl implements CopyRandomList {
    @Override
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //拼接
        Node p = head;
        while (p != null) {
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        p = head;
        Node result = head.next;
//        Node q;
//        //拆分
//        while (p != null) {
//            q = p.next;
//            p.next = p.next.next;
//            if (q.next != null) {
//                q.next = q.next.next;
//            }
//            p = p.next;
//        }

        Node q = head.next;
        while (p != null) {
            p.next = q.next;
            p = q.next;
            if (p == null) {
                break;
            }
            q.next = p.next;
            q = p.next;
        }

        return result;
    }
}
