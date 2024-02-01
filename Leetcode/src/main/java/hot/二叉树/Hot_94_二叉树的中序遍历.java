package hot.二叉树;

import mode.TreeNode;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

/**
 * TODO
 *
 * @author zhuzhiwei
 * @date 2024/1/30 19:58
 */
public class Hot_94_二叉树的中序遍历 {
    /**
     * 方法一：递归
     *
     * 方法二：队列
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null) {
            while (root != null) {
                deque.addLast(root);
                root = root.left;
            }
            root = deque.pollLast();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
