package offer.offer_68;

import offer.mode.TreeNode;

/**
 *
 * I
 * 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先（一个节点也可以是它自己的祖先）。
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * II
 * 树为普通二叉树
 *
 * @Author: zhuzw
 * @Date: 2021-04-28 9:38
 * @Version: 1.0
 */
public interface LowestCommonAncestor {
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q);
}
