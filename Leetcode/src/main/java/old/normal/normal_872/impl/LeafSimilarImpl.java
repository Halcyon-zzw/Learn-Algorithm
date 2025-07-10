package normal.normal_872.impl;

import mode.TreeNode;
import normal.normal_872.LeafSimilar;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先遍历
 *
 * 说明：使用两次深度实现，
 *      第一次获取叶子节点序列，
 *      第二次边遍历边比较，不满足时可提前终止
 *
 *
 * @Author: zhuzw
 * @Date: 2021-05-10 9:08
 * @Version: 1.0
 */
public class LeafSimilarImpl implements LeafSimilar {
    @Override
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> leafList = new ArrayList<>();
        dfs(root1, leafList);
        if (root2 == null) {
            return false;
        }
        boolean result = dfs2(root2, leafList);

        return result && leafList.isEmpty();
    }

    private void dfs(TreeNode root, List<Integer> leafList) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafList.add(root.val);
        }
        dfs(root.left, leafList);
        dfs(root.right, leafList);
    }

    private boolean dfs2(TreeNode root, List<Integer> leafList) {
        if (root.left == null && root.right == null) {
            if (leafList.isEmpty()) {
                return false;
            }
            Integer remove = leafList.remove(0);
            if (remove != root.val) {
                return false;
            }
        }
        if (root.left != null) {
            boolean leftSimilar = dfs2(root.left, leafList);
            if (!leftSimilar) {
                return false;
            }
        }
        if (root.right != null) {
            //左子树结果已经判断，返回右子树结果即可
            return dfs2(root.right, leafList);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.create(new int[]{3,5,1,6,2,9,8,-1,-1,7,4});
        TreeNode root2 = TreeNode.create(new int[]{3,5,1,6,7,4,2,-1,-1,-1,-1,-1,-1,9,8});


        TestUtils.test(LeafSimilarImpl.class, root1, root2);
    }
}
