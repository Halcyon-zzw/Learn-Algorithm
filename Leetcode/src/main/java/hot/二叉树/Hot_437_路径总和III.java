package hot.二叉树;

import mode.TreeNode;

/**
 * 437. 路径总和 III
 * 中等
 *
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * @author zhuzhiwei
 * @date 2024/2/1 17:09
 */
public class Hot_437_路径总和III {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        findPath(root, targetSum);
        //从子节点开始寻找
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }

    public void findPath(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        if (targetSum == 0) {
            count++;
        }
        //探索左子树
        findPath(root.left, targetSum);
        //探索右子树
        findPath(root.right, targetSum);
    }


    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return findPath2(root, targetSum) + pathSum2(root.left, targetSum) + pathSum2(root.right, targetSum);
    }

    public int findPath2(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        targetSum -= root.val;
        int count = targetSum == 0 ? 1 : 0;
        //探索子树
        return count + findPath2(root.left, targetSum) + findPath2(root.right, targetSum);
    }
}
