package interview.interview_tree.interview_0402.impl;

import interview.interview_tree.interview_0402.SortedArrayToBST;
import mode.TreeNode;
import utils.TestUtils;

/**
 * 先序遍历递归实现
 *
 * @Author: zhuzw
 * @Date: 2021-05-11 14:52
 * @Version: 1.0
 */
public class SortedArrayToBSTImpl implements SortedArrayToBST {
    @Override
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return bst(nums, 0, nums.length - 1);
    }

    /**
     * 二分搜索树实现
     * @param nums
     * @param start 构建二分搜索树的起始位置
     * @param end 构建二分搜索树的结束位置
     * @return
     */
    public TreeNode bst(int[] nums, int start, int end) {
        if (start < 0 || end >= nums.length || start > end) {
            return null;
        }
        int rootIndex = (start + end) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = bst(nums, start, rootIndex - 1);
        root.right = bst(nums, rootIndex + 1, end);
        return root;
    }

    public static void main(String[] args) {
        TestUtils.test(SortedArrayToBSTImpl.class, new int[]{-10,-3,0,5,9});
    }
}
