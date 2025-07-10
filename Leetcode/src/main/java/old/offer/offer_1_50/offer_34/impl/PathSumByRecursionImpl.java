package old.offer.offer_1_50.offer_34.impl;

import mode.TreeNode;
import old.offer.offer_1_50.offer_34.PathSum;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 递归回溯法
 *
 * @Author: zhuzw
 * @Date: 2021-04-22 10:50
 * @Version: 1.0
 */
public class PathSumByRecursionImpl implements PathSum {
    private List<List<Integer>> result = new ArrayList<>();;

    @Override
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        LinkedList<Integer> list = new LinkedList<>();
        recursion(root, target, list);
        return result;
    }

    private void recursion(TreeNode root, int target, LinkedList<Integer> linkedList) {
        if (root == null) {
            return;
        }
        linkedList.addLast(root.val);
        if (root.right == null && root.left == null) {
            int listSum = listSum(linkedList);
            //叶子节点
            if (listSum == target) {
                result.add(linkedList);
            }
        }
        recursion(root.left, target, linkedList);
        recursion(root.right, target, linkedList);
        linkedList.removeLast();
    }

    public int listSum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {

        TestUtils.test(PathSumByRecursionImpl.class, TreeNode.create(new int[]{5,4,8,11,-1,13,4,7,2,-1,-1,5,1}), 22);
    }
}
