package hot.二叉树;

import mode.TreeNode;

/**
 * 114. 二叉树展开为链表
 * 中等
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * · 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * · 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * @author zhuzhiwei
 * @date 2024/2/1 17:07
 */
public class Hot_114_二叉树展开为链表 {
    public void flatten(TreeNode root) {
        while (root != null) {
            TreeNode p = root;
            if (root.left != null) {
                TreeNode leftNode = root.left;
                root.left = null;
                //将root的左子树移到右子树
                TreeNode tmpRightNode = root.right;
                root.right = leftNode;

                while (root.right != null) {
                    root = root.right;
                }
                root.right = tmpRightNode;
            }
            root = p.right;
        }
    }
}
