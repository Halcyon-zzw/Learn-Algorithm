package old.offer.offer_55.impl;

import mode.TreeNode;
import old.offer.offer_55.IsBalanced;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-25 16:17
 * @Version: 1.0
 */
public class IsBalancedByRecursionImpl implements IsBalanced {
    @Override
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
