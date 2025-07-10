package old.offer.offer_54.impl;

import mode.TreeNode;
import old.offer.offer_54.KthLargest;

/**
 * 中序遍历递归实现
 *
 * 递归优化
 *
 * @Author: zhuzw
 * @Date: 2021-04-25 14:33
 * @Version: 1.0
 */
public class kthLargestByMidOptImpl implements KthLargest {
    int k, res = 0;
    @Override
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        recursion(root);
        return res;
    }

    public void recursion(TreeNode root) {
        if (root.left == null && root.right == null) {
            if (--k == 0) {
                res = root.val;
            }
            return;
        }
        if (root.right != null) {
            recursion(root.right);
        }
        //root节点
        if (--k == 0) {
            res = root.val;
        }
        if (root.left != null) {
            recursion(root.left);
        }
    }
}
