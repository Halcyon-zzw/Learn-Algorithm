package offer.offer_1_50.offer_35;

import mode.Node;

/**
 * 复杂链表的复制
 * <p>
 *     在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 *     还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * </p>
 * @Author: zhuzw
 * @Date: 2021-04-22 14:04
 * @Version: 1.0
 */
public interface CopyRandomList {
    Node copyRandomList(Node head);
}
