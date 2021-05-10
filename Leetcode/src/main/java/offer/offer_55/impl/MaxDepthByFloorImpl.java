package offer.offer_55.impl;

import mode.TreeNode;
import offer.offer_55.MaxDepth;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 层序遍历实现
 *
 * @Author: zhuzw
 * @Date: 2021-04-25 16:03
 * @Version: 1.0
 */
public class MaxDepthByFloorImpl implements MaxDepth {
    @Override
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<TreeNode> nextFlor = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode remove = stack.pop();
            if (remove.left != null) {
                nextFlor.add(remove.left);
            }
            if (remove.right != null) {
                nextFlor.add(remove.right);
            }
            if (stack.isEmpty()) {
                //加入下一层
                for (TreeNode treeNode : nextFlor) {
                    stack.push(treeNode);
                }
                nextFlor = new ArrayList<>();
                depth++;
            }
        }
        return depth;
    }
}
