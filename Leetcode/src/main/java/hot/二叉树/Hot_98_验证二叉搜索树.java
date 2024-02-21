package hot.二叉树;

import mode.TreeNode;
import java.util.Stack;

/**
 * 98. 验证二叉搜索树
 * 中等
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @author zhuzhiwei
 * @date 2024/2/1 17:04
 */
public class Hot_98_验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST1(root);
    }


    /**
     * 递归实现
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return dfs(root.left, lower, root.val) && dfs(root.right, root.val, upper);
    }

    /**
     * 中序遍历递归
     * 二叉搜索树的中序遍历：从小到大的有序的列表
     * 如果当前节点val <= 上一个节点时，则不符合
     *
     * @param root
     * @return
     */
    long pre = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST2(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST2(root.right);
    }

    /**
     * 中序遍历栈实现
     * 二叉搜索树的中序遍历：从小到大的有序的列表
     * 如果当前节点val <= 上一个节点时，则不符合
     *
     * @param root
     * @return
     */
    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            //遍历到最左
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create(2, 1, 3);
        boolean validBST = new Hot_98_验证二叉搜索树().isValidBST(treeNode);
        System.out.println(validBST);
    }
}
