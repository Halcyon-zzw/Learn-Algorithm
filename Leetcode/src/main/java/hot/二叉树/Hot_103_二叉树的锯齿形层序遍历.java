package hot.二叉树;

import mode.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 中等
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * @author zhuzhiwei
 * @date 2024/3/21 16:24
 */
public class Hot_103_二叉树的锯齿形层序遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> eachList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                if (flag) {
                    eachList.add(poll.val);
                } else {
                    eachList.add(0, poll.val);
                }
            }
            flag = !flag;
            result.add(eachList);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,-1,-1,5};
        Hot_103_二叉树的锯齿形层序遍历 hot = new Hot_103_二叉树的锯齿形层序遍历();
        List<List<Integer>> lists = hot.zigzagLevelOrder(TreeNode.create(arr));
        System.out.println(lists);
    }
}
