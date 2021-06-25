package interview.interview_tree.interview_0408.impl.again;

import interview.interview_tree.interview_0408.LowestCommonAncestor;
import mode.TreeNode;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-23 15:44
 * @Version: 1.0
 */
public class LowestCommonAncestorImpl implements LowestCommonAncestor {
    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftCommon = lowestCommonAncestor(root.left, p, q);
        TreeNode rightCommon = lowestCommonAncestor(root.right, p, q);
        if (leftCommon == null) {
            return rightCommon;
        }
        if (rightCommon == null) {
            return leftCommon;
        }
        return root;
    }
}
