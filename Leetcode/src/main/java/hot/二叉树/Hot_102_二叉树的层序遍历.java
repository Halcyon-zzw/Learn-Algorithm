package hot.二叉树;

import mode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * 中等
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * @author zhuzhiwei
 * @date 2024/1/31 11:53
 */
public class Hot_102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        return levelOrder1(root);
    }

    /**
     * 队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> resultList = new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> levelList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pop();
                //保存当前层的结果
                levelList.add(node.val);
                //将下一层结果加入到队列
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            resultList.add(levelList);
        }
        return resultList;
    }
}
