package interview.interview_tree.interview_0405.impl;

import interview.interview_tree.interview_0405.ValidBST;
import mode.TreeNode;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-23 9:17
 * @Version: 1.0
 */
public class ValidBSTByRecursionImpl implements ValidBST {

    @Override
    public boolean isValidBST(TreeNode root) {
        return bfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    private boolean bfs(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return bfs(root.left, minValue, root.val) && bfs(root.right, root.val, maxValue);
    }
}
