package hot.二叉树;

import mode.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * 困难
 *
 * 二叉树中的路径被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其最大路径和 。
 *
 * @author zhuzhiwei
 * @date 2024/2/1 17:11
 */
public class Hot_124_二叉树中的最大路径和 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //左子树最大贡献度
        int leftMaxGain = Math.max(maxGain(root.left), 0);
        //右子树最大贡献度
        int rightMaxGain = Math.max(maxGain(root.right), 0);

        //更新最大路径和
        int maxGain = root.val + leftMaxGain + rightMaxGain;
        maxSum = Math.max(maxSum, maxGain);
        //返回当前节点最大贡献度
        return root.val + Math.max(leftMaxGain, rightMaxGain);
    }
}
