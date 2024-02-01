package hot.二叉树;

import mode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 104. 二叉树的最大深度
 *
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * @author zhuzhiwei
 * @date 2024/1/31 11:43
 */
public class Hot_104_二叉树的最大深度 {
    /**
     * 方法一：深度优先，递归
     *
     * 方法二：广度优先，队列
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return maxDepth2(root);
    }


    private int maxDepth1(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        return Math.max(maxDepth1(root.left, depth), maxDepth1(root.right, depth));
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        //加入第一层
        deque.offer(root);
        while (!deque.isEmpty()) {
            //当前层的数量
            int size = deque.size();
            while (size > 0) {
                //获取下一层
                TreeNode treeNode = deque.poll();
                if (treeNode.left != null) {
                    deque.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.offer(treeNode.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}
