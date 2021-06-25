package interview.interview_tree.interview_0410.impl;

import interview.interview_tree.interview_0410.SubTree;
import mode.TreeNode;

/**
 * 获取树的中序序列，判断主树序列是否包含子树序列
 *
 * @Author: zhuzw
 * @Date: 2021-06-23 16:12
 * @Version: 1.0
 */
public class SubTreeImpl implements SubTree {
    @Override
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        StringBuffer seq1 = new StringBuffer(), seq2 = new StringBuffer();
        dfs(t1, seq1);
        dfs(t2, seq2);
        return seq1.toString().contains(seq2);
    }

    private void dfs(TreeNode root, StringBuffer seq1) {
        if (root == null) {
            return;
        }
        dfs(root.left, seq1);
        seq1.append(root.val);
        dfs(root.right, seq1);
    }
}
