package hot.二叉树;

import mode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 中等
 *
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 例：
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * @author zhuzhiwei
 * @date 2024/2/1 17:08
 */
public class Hot_105_从前序与中序遍历序列构造二叉树 {
    /**
     * 递归实现
     * 前序：[根节点, [左子树前序遍历], [右子树前序遍历]]
     * 中序：[[左子树中序遍历], 根节点 [右子树中序遍历]]
     *
     * @param preorder
     * @param inorder
     * @return
     */
    //val -> index
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        //根节点
        TreeNode root = new TreeNode(preorder[preStart]);
        //中序遍历中，根节点的位置
        Integer rootInIndex = map.get(root.val);
        int leftSize = rootInIndex - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootInIndex - 1);
        root.right = buildTree(preorder, preStart + 1 + leftSize, preEnd, inorder, rootInIndex + 1, inEnd);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static void main(String[] args) {
        int[] preOrder = {3,9,20,15,7}, inOrder = {9,3,15,20,7};
        TreeNode treeNode = new Hot_105_从前序与中序遍历序列构造二叉树().buildTree(preOrder, inOrder);
        System.out.println(treeNode);
    }
}
