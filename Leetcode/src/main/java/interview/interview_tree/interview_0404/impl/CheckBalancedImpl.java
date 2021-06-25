package interview.interview_tree.interview_0404.impl;

import interview.interview_tree.interview_0404.CheckBalanced;
import mode.TreeNode;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-22 15:39
 * @Version: 1.0
 */
public class CheckBalancedImpl implements CheckBalanced {
    @Override
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
