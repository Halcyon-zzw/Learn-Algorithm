package old.offer.offer_1_50.offer_27.impl;

import mode.TreeNode;
import old.offer.offer_1_50.offer_27.MiooirTreeInterface;

/**
 * 递归实现
 *
 * @Author: zhuzw
 * @Date: 2021-04-20 17:09
 * @Version: 1.0
 */
public class MiooirTreeByRecursionImpl implements MiooirTreeInterface {
    @Override
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }


}
