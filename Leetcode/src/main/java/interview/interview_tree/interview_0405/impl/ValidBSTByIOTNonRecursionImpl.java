package interview.interview_tree.interview_0405.impl;

import interview.interview_tree.interview_0405.ValidBST;
import mode.TreeNode;

import java.util.Stack;

/**
 * 中序遍历非递归实现
 *
 * @Author: zhuzw
 * @Date: 2021-06-23 10:38
 * @Version: 1.0
 */
public class ValidBSTByIOTNonRecursionImpl implements ValidBST {
    private TreeNode pre;
    @Override
    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val >= root.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }

    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public int hammingWeight2(int n) {
        int res = 0;
        while(n != 0) {
            n = n & (n - 1);
            res ++;
        }
        return res;
    }

    public static void main(String[] args) {
        ValidBSTByIOTNonRecursionImpl validBSTByIOTNonRecursion = new ValidBSTByIOTNonRecursionImpl();
        validBSTByIOTNonRecursion.hammingWeight(9);
    }
}
