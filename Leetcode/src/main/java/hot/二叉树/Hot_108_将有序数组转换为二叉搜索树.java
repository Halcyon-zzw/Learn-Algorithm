package hot.二叉树;

import mode.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 简单
 *
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * @author zhuzhiwei
 * @date 2024/2/1 17:02
 */
public class Hot_108_将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST1(nums);
    }

    /**
     * 递归实现
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST1(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mod = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mod]);
        root.left = sortedArrayToBST(nums, start, mod - 1);
        root.right = sortedArrayToBST(nums, mod + 1, end);
        return root;
    }
}
