package interview.interview_tree.interview_0406.impl;

import interview.interview_tree.interview_0406.InorderSuccessor;
import mode.TreeNode;
import utils.TestUtils;

/**
 * bst + 递归 优化
 *
 * @Author: zhuzw
 * @Date: 2021-05-12 16:10
 * @Version: 1.0
 */
public class InorderSuccessorOptImpl implements InorderSuccessor {


    @Override
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        }else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }


    public static void main(String[] args) {
        Object test = TestUtils.test(InorderSuccessorOptImpl.class,
                TreeNode.create(new int[]{5, 3, 6, 2, 4, -1, -1, 1}),
                TreeNode.create(new int[]{1}));
        System.out.println();
    }
}
