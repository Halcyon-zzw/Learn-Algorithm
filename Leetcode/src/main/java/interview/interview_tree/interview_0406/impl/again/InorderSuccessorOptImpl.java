package interview.interview_tree.interview_0406.impl.again;

import interview.interview_tree.interview_0406.InorderSuccessor;
import mode.TreeNode;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-23 14:53
 * @Version: 1.0
 */
public class InorderSuccessorOptImpl implements InorderSuccessor {
    @Override
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        if (p.val < root.val ) {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }else {
            return inorderSuccessor(root.right, p);
        }
    }
}
