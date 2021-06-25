package offer.offer_68.impl.search_tree;

import mode.TreeNode;
import offer.offer_68.LowestCommonAncestor;

/**
 * 二叉搜索树
 * 迭代实现
 *
 * @Author: zhuzw
 * @Date: 2021-04-28 9:50
 * @Version: 1.0
 */
public class LowestCommonAncestorImpl implements LowestCommonAncestor {
    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode commonNode = root;
        while (commonNode != null) {
            //同侧
            if (p.val > commonNode.val && q.val > commonNode.val) {
                commonNode = commonNode.right;
            }else if (p.val < commonNode.val && q.val < commonNode.val) {
                commonNode = commonNode.left;
            }else {
                //两侧
                break;
            }
        }
        return commonNode;
    }

}
