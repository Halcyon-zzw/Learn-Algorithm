package offer.offer_1_50.offer_32.impl;

import mode.TreeNode;
import offer.offer_1_50.offer_32.LevelOrderII;

import java.util.ArrayList;
import java.util.List;

/**
 * bfs广度优先，递归实现 从上到下打印二叉树
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * @Author: zhuzw
 * @Date: 2021-04-21 15:47
 * @Version: 1.0
 */
public class LevelOrderIIByRecursionImpl implements LevelOrderII {
    @Override
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> resultArr = new ArrayList<>();
        recursion(root, 0, resultArr);
        return resultArr;
    }

    public void recursion(TreeNode node, int level, List<List<Integer>> results) {
        if (node == null) {
            return;
        }
        int val = node.val;
        if(results.size()==level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(val);
        recursion(node.left, level + 1, results);
        recursion(node.right, level + 1, results);
    }

}
