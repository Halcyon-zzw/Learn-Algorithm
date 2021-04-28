package offer.offer_1_50.offer_32.impl;

import offer.mode.TreeNode;
import offer.offer_1_50.offer_32.LevelOrder;
import offer.offer_1_50.offer_32.LevelOrderII;

import java.util.*;

/**
 * bfs广度优先，借助队列 从上到下打印二叉树
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * @Author: zhuzw
 * @Date: 2021-04-21 15:47
 * @Version: 1.0
 */
public class LevelOrderIIByQueueImpl implements LevelOrderII {
    @Override
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        List<List<Integer>> resultArr = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            //本层数量 = 当前栈的数量
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final TreeNode treeNode = queue.removeLast();
                temp.add(treeNode.val);

                //加入下一层节点
                if (treeNode.left != null) {
                    queue.addFirst(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.addFirst(treeNode.right);
                }
            }
            resultArr.add(temp);
        }
        return resultArr;
    }

}
