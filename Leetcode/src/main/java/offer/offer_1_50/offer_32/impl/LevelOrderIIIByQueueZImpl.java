package offer.offer_1_50.offer_32.impl;

import offer.mode.TreeNode;
import offer.offer_1_50.offer_32.LevelOrderII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，
 * 其他行以此类推。
 *
 * @Author: zhuzw
 * @Date: 2021-04-21 18:32
 * @Version: 1.0
 */
public class LevelOrderIIIByQueueZImpl implements LevelOrderII {
    @Override
    /**
     * 通过当前层个数
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        List<List<Integer>> resultArr = new ArrayList<>();
        int level = 0;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            //本层数量 = 当前栈的数量
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final TreeNode treeNode = queue.removeLast();
                if (level % 2 == 0) {
                    temp.add(treeNode.val);
                }else {
                    temp.add(0, treeNode.val);
                }
                //加入下一层节点
                if (treeNode.left != null) { queue.addFirst(treeNode.left); }
                if (treeNode.right != null) { queue.addFirst(treeNode.right); }
            }
            resultArr.add(temp);
            level++;
        }
        return resultArr;
    }
}
