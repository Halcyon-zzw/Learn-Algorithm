package interview.interview_tree.interview_0405.impl;

import interview.interview_tree.interview_0405.IsValidBST;
import mode.TreeNode;
import utils.TestUtils;

import java.util.Stack;

/**
 * 中序遍历非递归实现
 *
 * @Author: zhuzw
 * @Date: 2021-05-12 10:04
 * @Version: 1.0
 */
public class IsValidBSTByIOTNonRecurImpl implements IsValidBST {
    private TreeNode pre;
    @Override
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            //左子树
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {
                TreeNode pop = stack.pop();
                if (pre != null && pre.val >= pop.val) {
                    return false;
                }
                pre = pop;
                if (pop.right != null) {
                    root = pop.right;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TestUtils.test(IsValidBSTByIOTNonRecurImpl.class, TreeNode.create(new int[]{5, 1, 7, -1, -1, 6, 8}));
    }
}
