package offer.offer_68.impl.normal_tree;

import offer.mode.TreeNode;
import offer.offer_68.LowestCommonAncestor;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-28 10:24
 * @Version: 1.0
 */
public class NormalLowestCommonAncestorRecursionImpl implements LowestCommonAncestor {
    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftCommon = lowestCommonAncestor(root.left, p, q);
        TreeNode rightCommon = lowestCommonAncestor(root.right, p, q);
        if (leftCommon != null && rightCommon != null) {
            //分布在两侧
            return root;
        }else if (leftCommon != null){
            //分布在左侧
            return leftCommon;
        }else {
            //分布在右侧
            return rightCommon;
        }
    }
}
