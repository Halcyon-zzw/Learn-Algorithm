package interview.interview_tree.interview_0412;

import mode.TreeNode;

/**
 * 求和路径
 *
 * <p>
 *     给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。
 *
 *     打印节点数值总和等于某个给定值的所有路径的数量。
 *     注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 * </p>
 *
 * @Author: zhuzw
 * @Date: 2021-06-23 16:30
 * @Version: 1.0
 */
public interface AnyPathSum {
    int pathSum(TreeNode root, int sum);
}
