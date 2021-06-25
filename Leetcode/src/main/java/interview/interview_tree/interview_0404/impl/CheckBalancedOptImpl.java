package interview.interview_tree.interview_0404.impl;

import interview.interview_tree.interview_0404.CheckBalanced;
import mode.TreeNode;

/**
 * 计算树深度的时候同时计算平衡性
 *
 * @Author: zhuzw
 * @Date: 2021-06-22 15:54
 * @Version: 1.0
 */
public class CheckBalancedOptImpl implements CheckBalanced {
    @Override
    public boolean isBalanced(TreeNode root) {
        return depth(root) >= 0;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
