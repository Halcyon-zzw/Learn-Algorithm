package offer.offer_68.impl.search_tree;

import mode.TreeNode;
import offer.offer_68.LowestCommonAncestor;

/**
 * 二叉搜索树
 * 递归实现
 *
 * @Author: zhuzw
 * @Date: 2021-04-28 9:56
 * @Version: 1.0
 */
public class LowestCommonAncestorByRecursionImpl implements LowestCommonAncestor {
    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //同侧
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }else {
            //两侧
            return root;
        }
    }
}
