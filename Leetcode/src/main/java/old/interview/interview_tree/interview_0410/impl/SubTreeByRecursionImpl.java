package interview.interview_tree.interview_0410.impl;

import interview.interview_tree.interview_0410.SubTree;
import mode.TreeNode;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-23 16:17
 * @Version: 1.0
 */
public class SubTreeByRecursionImpl implements SubTree {
    @Override
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        }
        boolean check = check(t1, t2);
        if (check) {
            return true;
        }
        return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    private boolean check(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        if (t1.val == t2.val) {
            return check(t1.left, t2.left) && check(t1.right, t2.right);
        }
        return false;
    }
}
