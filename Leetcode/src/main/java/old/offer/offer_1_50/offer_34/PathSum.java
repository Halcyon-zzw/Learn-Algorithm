package old.offer.offer_1_50.offer_34;

import mode.TreeNode;

import java.util.List;

/**
 * 二叉树中和为某一值的路径
 *
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径
 *
 * @Author: zhuzw
 * @Date: 2021-04-22 10:49
 * @Version: 1.0
 */
public interface PathSum {
    List<List<Integer>> pathSum(TreeNode root, int target);
}
