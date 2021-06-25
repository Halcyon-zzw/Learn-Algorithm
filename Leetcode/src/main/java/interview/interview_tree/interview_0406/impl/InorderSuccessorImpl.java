package interview.interview_tree.interview_0406.impl;

import interview.interview_tree.interview_0406.InorderSuccessor;
import mode.TreeNode;
import utils.TestUtils;

/**
 * 普通树 + 递归
 *
 * 适合普通树
 *
 * @Author: zhuzw
 * @Date: 2021-05-12 16:10
 * @Version: 1.0
 */
public class InorderSuccessorImpl implements InorderSuccessor {
    private TreeNode next = null;
    private boolean flag = false;
    @Override
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        findNext(root, p);
        return next;
    }

    private void findNext(TreeNode root, TreeNode p) {
        if (root == null || next != null) {
            return;
        }
        findNext(root.left, p);
        if (flag && next == null) {
            next = root;
            return;
        }
        if (root.val == p.val) {
            flag = true;
        }
        findNext(root.right, p);
    }

    public static void main(String[] args) {
        TestUtils.test(InorderSuccessorImpl.class,
                TreeNode.create(new int[]{5, 3, 6, 2, 4, -1, -1, 1}),
                TreeNode.create(new int[]{1}));
    }
}
