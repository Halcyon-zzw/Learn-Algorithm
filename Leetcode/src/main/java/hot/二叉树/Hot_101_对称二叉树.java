package hot.二叉树;

import mode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 101. 对称二叉树
 * 简单
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * @author zhuzhiwei
 * @date 2024/1/31 11:47
 */
public class Hot_101_对称二叉树 {
    /**
     * 层序遍历、模拟
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size(), index = 0;
            int[] nextArr = new int[size * 2];
            boolean[] existArr = new boolean[size * 2];
            while (size > 0) {
                TreeNode treeNode = deque.pop();
                if (treeNode.left != null) {
                    deque.offer(treeNode.left);
                    nextArr[index] = treeNode.left.val;
                    existArr[index] = true;
                }
                index++;
                if (treeNode.right != null) {
                    deque.offer(treeNode.right);
                    nextArr[index] = treeNode.right.val;
                    existArr[index] = true;
                }
                index++;
                size--;
            }
            if (!isSymmetric(nextArr, existArr)) {
                return false;
            }
        }

        return true;
    }

    private boolean isSymmetric(int[] nextArr, boolean[] existArr) {
        for (int i = 0; i < nextArr.length / 2; i++) {
            int leftIndex = i, rightIndex = nextArr.length - 1 - i;
            //都为空
            if (!existArr[leftIndex] && !existArr[rightIndex]) {
                continue;
            }
            //一个为空
            if (!existArr[leftIndex] || !existArr[rightIndex]) {
                return false;
            }
            if (nextArr[i] != nextArr[nextArr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 维护一个队列，依次保存需要比较的对称二叉树的两个节点，即
     *      左树节点的左节点、右树节点的右节点
     *      左树节点的右节点、右树节点的左节点
     * 比较时，每次从队列获取两个节点进行比较，并按上述逻辑将子节点保存到队列
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.pop();
            TreeNode right = deque.pop();
            if (left == null && right == null) {
                continue;
            }
            //其中一个节点为空 或者 节点值不相等
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            deque.offer(left.left);
            deque.offer(right.right);
            deque.offer(left.right);
            deque.offer(right.left);
        }
        return true;
    }

    /**
     * 递归实现
     * @param root
     * @return
     */
    public boolean isSymmetric3(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
