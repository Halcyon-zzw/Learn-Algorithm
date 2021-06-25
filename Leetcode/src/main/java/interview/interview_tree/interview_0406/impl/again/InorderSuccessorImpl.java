package interview.interview_tree.interview_0406.impl.again;

import interview.interview_tree.interview_0406.InorderSuccessor;
import mode.TreeNode;
import utils.TestUtils;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-23 14:30
 * @Version: 1.0
 */
public class InorderSuccessorImpl implements InorderSuccessor {

    private TreeNode next = null;
    private boolean findFlag = false;
    @Override
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        findNext(root, p);
        return next;
    }

    private void findNext(TreeNode root, TreeNode p) {
         if (root == null || p == null || next != null) {
            return;
        }
        findNext(root.left, p);
        if (findFlag && next == null) {
            next = root;
            return;
        }
        if (root.val == p.val) {
            findFlag = true;
        }
        findNext(root.right, p);
    }

    public static void main(String[] args) {
        TestUtils.test(InorderSuccessorImpl.class,
                TreeNode.create(new int[]{5, 3, 6, 2, 4, -1, -1, 1}),
                TreeNode.create(new int[]{1}));
    }
}
