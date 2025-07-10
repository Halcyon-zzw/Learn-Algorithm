package old.offer.offer_1_50.offer_32.impl;

import mode.TreeNode;
import old.offer.offer_1_50.offer_32.LevelOrder;

import java.util.*;

/**
 * bfs广度优先，借助队列 从上到下打印二叉树
 *
 * @Author: zhuzw
 * @Date: 2021-04-21 15:47
 * @Version: 1.0
 */
public class LevelOrderByQueueImpl implements LevelOrder {
    @Override
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> results = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.removeLast();
            results.add(treeNode.val);
            if (treeNode.left != null) {
                queue.addFirst(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.addFirst(treeNode.right);
            }
        }
        return results.stream().mapToInt(Integer::intValue).toArray();
    }

}
