package normal.normal_872.impl;

import mode.TreeNode;
import normal.normal_872.LeafSimilar;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先遍历
 *
 * 简洁版
 *
 *
 * @Author: zhuzw
 * @Date: 2021-05-10 9:08
 * @Version: 1.0
 */
public class LeafSimilarConciseImpl implements LeafSimilar {
    @Override
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> leafList1 = new ArrayList<>();
        dfs(root1, leafList1);
        List<Integer> leafList2 = new ArrayList<>();
        dfs(root2, leafList2);

        return leafList1.equals(leafList2);
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


    public static void main(String[] args) {
        TreeNode root1 = TreeNode.create(new int[]{3,5,1,6,2,9,8,-1,-1,7,4});
        TreeNode root2 = TreeNode.create(new int[]{3,5,1,6,7,4,2,-1,-1,-1,-1,-1,-1,9,8});


        TestUtils.test(LeafSimilarConciseImpl.class, root1, root2);
    }
}
