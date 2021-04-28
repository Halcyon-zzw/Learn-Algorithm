package offer.offer_1_50.offer_32.impl;

import offer.mode.TreeNode;
import offer.offer_1_50.offer_32.LevelOrderII;

import java.util.*;

/**
 *
 * 通过队列记录下一层
 * @Author: zhuzw
 * @Date: 2021-04-21 18:44
 * @Version: 1.0
 */
public class LevelOrderIIIByNextFloorZImpl implements LevelOrderII {
    @Override
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<TreeNode> nextQueue = new LinkedList<>();
        //下一层节点队列
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        results.add(new ArrayList<Integer>(){{add(root.val);}});
        //正序标识
        boolean positiveFlag = false;

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            addNextToQueue(treeNode, nextQueue, positiveFlag);

            if (stack.isEmpty()) {
                //换层后换序
                positiveFlag = !positiveFlag;
                List<Integer> nextFloors = new ArrayList<>();
                while (!nextQueue.isEmpty()) {
                    TreeNode temp = nextQueue.removeLast();
                    nextFloors.add(temp.val);
                    stack.push(temp);
                }
                if (nextFloors.size() != 0) {
                    results.add(nextFloors);
                }
            }
        }
        return results;
    }

    private void addNextToQueue(TreeNode treeNode, LinkedList<TreeNode> nextQueue, boolean positiveFlag) {
        //加入下一层节点
        if (positiveFlag) {
            if (treeNode.left != null) {
                nextQueue.addFirst(treeNode.left);
            }
            if (treeNode.right != null) {
                nextQueue.addFirst(treeNode.right);
            }
        }else {
            if (treeNode.right != null) {
                nextQueue.addFirst(treeNode.right);
            }
            if (treeNode.left != null) {
                nextQueue.addFirst(treeNode.left);
            }
        }
    }
}
