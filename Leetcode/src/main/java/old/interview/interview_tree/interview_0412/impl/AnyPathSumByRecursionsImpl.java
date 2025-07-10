package interview.interview_tree.interview_0412.impl;

import interview.interview_tree.interview_0412.AnyPathSum;
import mode.TreeNode;
import utils.TestUtils;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-23 16:31
 * @Version: 1.0
 */
public class AnyPathSumByRecursionsImpl implements AnyPathSum {
    private int count = 0;
    @Override
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        findPathSum(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }

    private void findPathSum(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            count++;
        }
        findPathSum(root.left, sum);
        findPathSum(root.right, sum);
    }

    public static void main(String[] args) {
        TestUtils.test(AnyPathSumByRecursionsImpl.class, TreeNode.create(5,4,8,11,-1,13,4,7,2,-1,-1,5,1), 22);
    }
}
