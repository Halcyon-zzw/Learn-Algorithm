package hot.二叉树;

import mode.TreeNode;

/**
 * 543. 二叉树的直径
 * 简单
 *
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * @author zhuzhiwei
 * @date 2024/1/31 11:50
 */
public class Hot_543_二叉树的直径 {
    int result = 0;
    /**
     * 最大直径 = 某个节点的左子树深度 + 右子树深度
     */
    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);
        return result;
    }

    private int dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int lDepth = dfs(treeNode.left);
        int rDepth = dfs(treeNode.right);
        result = Math.max(lDepth + rDepth, result);
        return Math.max(lDepth, rDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create(1, 2, 3, 4, 5);
        int diameter = new Hot_543_二叉树的直径().diameterOfBinaryTree(treeNode);
        System.out.println(diameter);
    }
}
