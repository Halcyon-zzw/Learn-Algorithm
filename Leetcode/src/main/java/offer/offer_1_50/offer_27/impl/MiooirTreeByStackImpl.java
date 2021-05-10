package offer.offer_1_50.offer_27.impl;

import mode.TreeNode;
import offer.offer_1_50.offer_27.MiooirTreeInterface;

import java.util.LinkedList;

/**
 * 通过栈或队列实现
 *
 * @Author: zhuzw
 * @Date: 2021-04-20 17:22
 * @Version: 1.0
 */
public class MiooirTreeByStackImpl implements MiooirTreeInterface {
    @Override
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addFirst(root);
        while (!linkedList.isEmpty()) {
            TreeNode pop = linkedList.removeLast();
            //交换
            TreeNode temp = pop.left;
            pop.left = pop.right;
            pop.right = temp;
            if (pop.left != null) {
                linkedList.addFirst(pop.left);
            }
            if (pop.right != null) {
                linkedList.addFirst(pop.right);
            }
        }
        return root;
    }
}
