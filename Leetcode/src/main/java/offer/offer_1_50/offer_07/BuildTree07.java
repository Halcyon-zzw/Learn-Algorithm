package offer.offer_1_50.offer_07;


import java.util.Arrays;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-16 15:16
 * @Version: 1.0
 */
public class BuildTree07 {
    /**
     * 知识点：
     * 前序遍历性质： 节点按照 [ 根节点 | 左子树 | 右子树 ] 排序。
     * 中序遍历性质： 节点按照 [ 左子树 | 根节点 | 右子树 ] 排序。
     *
     * 算法：
     * 通过前序找到根节点
     * 通过中序分出左子树和右子树
     * 递归
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder== null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int rootVal = preorder[0];
        //找出中序中根节点的位置
        int rootIndex = 0;
        for (; rootIndex < inorder.length; rootIndex++) {
            if (inorder[rootIndex] == rootVal) {
                break;
            }
        }
        TreeNode treeNode = new TreeNode(rootVal);  //根节点
        treeNode.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex + 1), Arrays.copyOfRange(inorder, 0, rootIndex));
        treeNode.right = buildTree(Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length), Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
        return treeNode;
    }

    public static void main(String[] args) {
        BuildTree07 buildTree07 = new BuildTree07();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree07.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
