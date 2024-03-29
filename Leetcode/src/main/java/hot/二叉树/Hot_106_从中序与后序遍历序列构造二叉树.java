package hot.二叉树;

import mode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 inorder 和 postorder ，
 * 其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 * inorder 和 postorder 都由 不同 的值组成
 *
 * @author zhuzhiwei
 * @date 2024/3/29 16:34
 */
public class Hot_106_从中序与后序遍历序列构造二叉树 {
    /**
     * 中序：左子树、根节点、右子树
     * 后序：左子树、右子树、根节点
     *
     * 找到中序的根节点
     * 根据左子树的中、后序列构建左子树，根据右子树的中、后序列构建右子树
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //value -> index
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        //根节点位置
        int rootIndex = 0;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == postorder[postorderEnd]) {
                rootIndex = i;
                break;
            }
        }
        //左子树数量
        int leftTreeCount = rootIndex - inorderStart;
        //右子树数量
        int rightTreeCount = postorderEnd - rootIndex;
        TreeNode root = new TreeNode(inorder[rootIndex]);
        //左子树
        root.left = buildTree(inorder, postorder, inorderStart, rootIndex - 1, postorderStart, postorderStart + leftTreeCount - 1);
        //右子树
        root.right = buildTree(inorder, postorder, rootIndex + 1, inorderEnd, postorderStart + leftTreeCount, postorderEnd - 1);
        return root;
    }
}
