package interview.interview_tree.interview_0406;

import mode.TreeNode;

/**
 * 后继者
 *
 * 找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * @Author: zhuzw
 * @Date: 2021-05-12 16:09
 * @Version: 1.0
 */
public interface InorderSuccessor {
    TreeNode inorderSuccessor(TreeNode root, TreeNode p);
}
