package offer.offer_68.impl.normal_tree;

import mode.TreeNode;
import offer.offer_68.LowestCommonAncestor;
import utils.TestUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 用map记录每个节点的父节点。
 * 从p开始遍历父节点，再从q开始遍历父节点，如果遇到访问过的父节点。则是共同的公共节点。第一个访问的为最深的公共节点
 *
 * @Author: zhuzw
 * @Date: 2021-04-28 10:24
 * @Version: 1.0
 */
public class NormalLowestCommonAncestorByMapImpl implements LowestCommonAncestor {
    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        dfs(root);
        while (p != null) {
            set.add(p.val);
            p = map.get(p.val);
        }
        while (q != null) {
            if (set.contains(q.val)) {
                return q;
            }
            q = map.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create(new int[]{3,5,1,6,2,0,8,-1,-1,7,4});
        TreeNode p = TreeNode.create(new int[]{5});
        TreeNode q = TreeNode.create(new int[]{1});
        Class<NormalLowestCommonAncestorByMapImpl> clazz = NormalLowestCommonAncestorByMapImpl.class;
        TestUtils.test(clazz, treeNode, p, q);
    }



}
