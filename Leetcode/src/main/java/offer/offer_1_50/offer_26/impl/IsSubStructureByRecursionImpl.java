package offer.offer_1_50.offer_26.impl;
import offer.offer_1_50.offer_26.IsSubStructure;

import offer.mode.TreeNode;


/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-20 16:11
 * @Version: 1.0
 */
public class IsSubStructureByRecursionImpl implements IsSubStructure {
    @Override
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        boolean root = recursion(A, B);
        if (root) {
            return true;
        }
        return isSubStructure(A.right, B) || isSubStructure(A.left, B);

    }

    public boolean recursion(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        //B不为null, A 为null
        if (A == null) {
            return false;
        }
        if (A.val == B.val) {
            return recursion(A.left, B.left) && recursion(A.right, B.right);
        }
        return false;
    }
}
