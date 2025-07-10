package old.offer.offer_1_50.offer_32.impl;

import mode.TreeNode;
import old.offer.offer_1_50.offer_32.LevelOrderII;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * 通过队列记录下一层
 * @Author: zhuzw
 * @Date: 2021-04-21 18:44
 * @Version: 1.0
 */
public class LevelOrderIIByNextFloorImpl implements LevelOrderII {
    @Override
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        //下一层节点队列
        LinkedList<TreeNode> nextQueue = new LinkedList<>();
        queue.addFirst(root);
        int deep = 0;
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.removeLast();
            if (map.get(deep) == null) {
                map.put(deep, new ArrayList<>());
            }
            map.get(deep).add(treeNode.val);
            if (treeNode.left != null) {
                nextQueue.addFirst(treeNode.left);
            }
            if (treeNode.right != null) {
                nextQueue.addFirst(treeNode.right);
            }
            //如果本层为空,加入下层
            if (queue.isEmpty()) {
                deep++;
                while (!nextQueue.isEmpty()) {
                    queue.addFirst(nextQueue.removeLast());
                }
            }
        }

        List<List<Integer>> resultArr = new ArrayList<>();
        Set<Integer> set = map.keySet();
        for (int i = 0; i < set.size(); i++) {
            resultArr.add(map.get(i).stream().collect(Collectors.toList()));
        }
        return resultArr;
    }
}
