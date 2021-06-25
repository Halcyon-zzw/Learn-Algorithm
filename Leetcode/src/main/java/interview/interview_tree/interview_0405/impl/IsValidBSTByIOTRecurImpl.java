package interview.interview_tree.interview_0405.impl;

import interview.interview_tree.interview_0405.IsValidBST;
import mode.TreeNode;
import utils.TestUtils;

/**
 * 中序遍历递归实现
 *
 * @Author: zhuzw
 * @Date: 2021-05-12 10:04
 * @Version: 1.0
 */
public class IsValidBSTByIOTRecurImpl implements IsValidBST {
    private TreeNode pre;
    @Override
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftIsValidBst = isValidBST(root.left);
        if (!leftIsValidBst) {
            return false;
        }
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        boolean rightIsValidBst = isValidBST(root.right);

        return rightIsValidBst;
    }

    public static void main(String[] args) {
        TestUtils.test(IsValidBSTByIOTRecurImpl.class, TreeNode.create(new int[]{5, 1, 6, -1, -1, 3, 7}));
    }
}
