package old.offer.offer_1_50.offer_32;

import mode.TreeNode;

import java.util.List;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * @Author: zhuzw
 * @Date: 2021-04-21 15:46
 * @Version: 1.0
 */
public interface LevelOrderII {
    List<List<Integer>> levelOrder(TreeNode root);
}
