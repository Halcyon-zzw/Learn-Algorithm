package old.offer.offer_54.impl;

import mode.TreeNode;
import old.offer.offer_54.KthLargest;

/**
 * 中序遍历递归实现
 *
 * @Author: zhuzw
 * @Date: 2021-04-25 14:33
 * @Version: 1.0
 */
public class kthLargestByMidImpl implements KthLargest {
    int k, cur = 0;
    @Override
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        return postRecursion(root);
    }

    public int postRecursion(TreeNode root) {
        if (root.left == null && root.right == null) {
            cur ++;
            return root.val;
        }
        int result = 0;
        if (root.right != null) {
            result = postRecursion(root.right);
        }
        if (k == cur) {
            return result;
        }
        //root节点
        cur++;
        if (k == cur) {
            return root.val;
        }
        if (root.left != null) {
            result = postRecursion(root.left);
        }
        if (k == cur) {
            return result;
        }
        return -1;
    }
}
