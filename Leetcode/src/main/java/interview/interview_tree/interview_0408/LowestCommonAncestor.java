package interview.interview_tree.interview_0408;

import mode.TreeNode;

/**
 *  首个共同祖先
 *  <p>
 *      找出二叉树中某两个节点的第一个共同祖先。
 *      不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
 *  </p>
 *
 * @Author: zhuzw
 * @Date: 2021-05-12 16:09
 * @Version: 1.0
 */
public interface LowestCommonAncestor {
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q);
}
