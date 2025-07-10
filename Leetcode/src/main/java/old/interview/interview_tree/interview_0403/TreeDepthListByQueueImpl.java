package interview.interview_tree.interview_0403;

import mode.ListNode;
import mode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 借助队列实现
 *
 * @Author: zhuzw
 * @Date: 2021-06-22 15:04
 * @Version: 1.0
 */
public class TreeDepthListByQueueImpl implements TreeDepthList {
    @Override
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode head = new ListNode(-1);
            ListNode p = head;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                p.next = new ListNode(poll.val);
                p = p.next;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            list.add(head.next);
        }
        return list.toArray(new ListNode[0]);
    }
}
