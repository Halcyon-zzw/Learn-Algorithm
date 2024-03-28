package hot.二叉树;

import mode.TreeNode;

import java.util.Stack;

/**
 * 230. 二叉搜索树中第K小的元素
 * 中等
 *
 * 给定一个二叉搜索树的根节点 root，和一个整数 k，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * @author zhuzhiwei
 * @date 2024/2/1 17:05
 */
public class Hot_230_二叉搜索树中第K小的元素 {
    int cur = 0;

    /**
     * 中序遍历
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        return dfs(root, k);
    }

    public int dfs(TreeNode root, int k) {
        if (cur >= k) {
            return root.val;
        }

        if (root.left != null) {
            dfs(root.left, k);
            cur++;
            if (cur >= k) {
                return root.val;
            }
        }
        cur++;
        if (cur >= k) {
            return root.val;
        }
        if (root.right != null) {
            dfs(root.right, k);
            cur++;
            if (cur >= k) {
                return root.val;
            }
        }
        return 0;
    }

    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
