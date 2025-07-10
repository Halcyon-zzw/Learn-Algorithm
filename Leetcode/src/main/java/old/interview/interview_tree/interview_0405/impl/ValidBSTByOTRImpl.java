package interview.interview_tree.interview_0405.impl;

import interview.interview_tree.interview_0405.ValidBST;
import mode.TreeNode;
import utils.TestUtils;

/**
 * 中序遍历递归实现
 *
 * @Author: zhuzw
 * @Date: 2021-06-23 10:14
 * @Version: 1.0
 */
public class ValidBSTByOTRImpl implements ValidBST {
    private TreeNode pre;
    @Override
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        TestUtils.test(ValidBSTByOTRImpl.class, TreeNode.create(new int[]{5, 1, 6, -1, -1, 3, 7}));
    }
}
