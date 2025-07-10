package interview.interview_tree.interview_0405.impl;

import interview.interview_tree.interview_0405.IsValidBST;
import mode.TreeNode;

/**
 * 递归实现
 *
 * @Author: zhuzw
 * @Date: 2021-05-12 9:11
 * @Version: 1.0
 */
public class IsValidBSTByRecursionImpl implements IsValidBST {
    @Override
    public boolean isValidBST(TreeNode root) {

        return bst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean bst(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return bst(root.left, min, root.val) && bst(root.right, root.val, max);
    }
}
