package offer.offer_55.impl;

import offer.mode.TreeNode;
import offer.offer_55.MaxDepth;

/**
 * 递归实现
 *
 * @Author: zhuzw
 * @Date: 2021-04-25 15:24
 * @Version: 1.0
 */
public class MaxDepthRecursionImpl implements MaxDepth {
    @Override
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
