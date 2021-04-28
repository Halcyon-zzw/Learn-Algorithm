package offer.offer_1_50.offer_28.impl;

import offer.mode.TreeNode;
import offer.offer_1_50.offer_28.IsSymmetric;

/**
 * 通过递归判断是否是对称树
 *
 * @Author: zhuzw
 * @Date: 2021-04-21 13:31
 * @Version: 1.0
 */
public class IsSymmetricByRecursionImpl implements IsSymmetric {
    @Override
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recursion(root.left, root.right);
    }

    /**
     *
     * @param tree1
     * @param tree2
     * @return
     */
    public boolean recursion(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            //如果不是二者都为空，则返回false
            return true;
        } else if (tree1 == null || tree2 == null){
            return false;
        }
        if (tree1.val == tree2.val) {
            return recursion(tree1.left, tree2.right) && recursion(tree1.right, tree2.left);
        }
        return false;
    }
}
