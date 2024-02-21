package hot.二叉树;

import mode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * 中等
 *
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * @author zhuzhiwei
 * @date 2024/2/1 17:06
 */
public class Hot_199_二叉树的右视图 {
    /**
     * dfs深度优先
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        return rightSideView1(root);
    }

    List<Integer> resultList = new ArrayList<>();
    public List<Integer> rightSideView1(TreeNode root) {
        dfs(root, 0);
        return resultList;
    }


    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (resultList.size() <= depth) {
            resultList.add(root.val);
        } else {
            resultList.set(depth, root.val);
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    /**
     * 每次看到当前层的最右边的节点
     *
     * 层序遍历
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pop();
                if (i == size - 1) {
                    resultList.add(node.val);
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return resultList;
    }
}
