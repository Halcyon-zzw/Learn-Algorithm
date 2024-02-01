package hot.二叉树;

import com.sun.source.tree.Tree;
import mode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 226. 翻转二叉树
 * 简单
 *
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * @author zhuzhiwei
 * @date 2024/1/31 11:45
 */
public class Hot_226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        return invertTree1(root);
    }

    /**
     * 递归实现
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        //反转左右节点
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;

        //递归反转左节点
        dfs(root.left);
        //递归反转右节点
        dfs(root.right);
    }

    /**
     * 队列实现
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            if (node != null) {
                //反转左右节点
                TreeNode tmpNode = node.left;
                node.left = node.right;
                node.right = tmpNode;
                deque.offer(node.left);
                deque.offer(node.right);
            }
        }
        return root;
    }
}
