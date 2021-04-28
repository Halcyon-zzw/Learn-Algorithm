package offer.offer_1_50.offer_35.impl;

import offer.mode.Node;
import offer.offer_1_50.offer_35.CopyRandomList;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-22 15:16
 * @Version: 1.0
 */
public class CopyRandomListByMapImpl implements CopyRandomList {
    @Override
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        //简历老 -> 新 的映射关系
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        //建立联系
        p = head;
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
}
