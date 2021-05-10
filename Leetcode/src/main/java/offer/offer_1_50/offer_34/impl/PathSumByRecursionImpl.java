package offer.offer_1_50.offer_34.impl;

import mode.TreeNode;
import offer.offer_1_50.offer_34.PathSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 递归回溯法
 *
 * @Author: zhuzw
 * @Date: 2021-04-22 10:50
 * @Version: 1.0
 */
public class PathSumByRecursionImpl implements PathSum {
    @Override
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> curStack = new Stack<>();
        recursion(root, target, result, curStack);
        return result;
    }

    private void recursion(TreeNode root, int target, List<List<Integer>> result, Stack<Integer> curStack) {
        if (root == null) {
            return;
        }
        curStack.push(root.val);
        int listSum = listSum(curStack);
        if (root.right == null && root.left == null) {
            //叶子节点
            if (listSum == target) {
                result.add(newStack(curStack));
            }
        }
        recursion(root.left, target, result, curStack);
        recursion(root.right, target, result, curStack);
        curStack.pop();
    }

    private List<Integer> newStack(Stack<Integer> curStack) {
        return curStack.stream().collect(Collectors.toList());
    }

    public int listSum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }
}
