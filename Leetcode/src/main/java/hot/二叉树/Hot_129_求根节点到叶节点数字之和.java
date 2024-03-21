package hot.二叉树;

import mode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 129. 求根节点到叶节点数字之和
 * 中等
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 *
 * @author zhuzhiwei
 * @date 2024/3/21 14:34
 */
public class Hot_129_求根节点到叶节点数字之和 {
    /**
     * 深度优先遍历，剪枝
     *
     * @param root
     * @return
     */
    List<List<Integer>> numberList = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> eachList = new ArrayList<>();
        dfs(root, eachList);
        int sum = 0;
        for (int i = 0; i < numberList.size(); i++) {
            StringBuilder s = new StringBuilder();
            for (Integer integer : numberList.get(i)) {
                s.append(integer);
            }
            sum += Integer.parseInt(s.toString());
        }
        return sum;
    }

    private void dfs(TreeNode root, List<Integer> earchList) {
        earchList.add(root.val);
        if (root.left == null && root.right == null) {
            numberList.add(new ArrayList<>(earchList));
            return;
        }
        if (root.left != null) {
            dfs(root.left, earchList);
        }
        earchList.remove(earchList.size() - 1);
        if (root.right != null) {
            dfs(root.right, earchList);
        }
        earchList.remove(earchList.size() - 1);
    }


    public static void main(String[] args) {
        int[] arr = {4, 9, 0, 5, 1};
        Hot_129_求根节点到叶节点数字之和 obj = new Hot_129_求根节点到叶节点数字之和();
        int sum = obj.sumNumbers2(TreeNode.create(arr));
        System.out.println(sum);
    }

    /**
     * 深度遍历
     *
     * @param root
     * @return
     */
    public int sumNumbers2(TreeNode root) {
        return dfs2(root, 0);
    }

    public int dfs2(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dfs2(root.left, sum) + dfs2(root.right, sum);
    }
}
