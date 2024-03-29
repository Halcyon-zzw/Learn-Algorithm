package mode;

import java.util.LinkedList;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-20 16:13
 * @Version: 1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * 层序赋值生成二叉树，值为-1时表示节点为空
     * @param arr
     * @return
     */
    public static TreeNode create(int... arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        final TreeNode root = new TreeNode(arr[0]);
        linkedList.addFirst(root);
        int index = 1;
        while (!linkedList.isEmpty() && index < arr.length) {
            final TreeNode treeNode = linkedList.removeLast();
            //赋值左右子节点
            int curVal = arr[index++];
            if (curVal != -1) {
                treeNode.left = new TreeNode(curVal);
                linkedList.addFirst(treeNode.left);
            }
            if (index >= arr.length) {
                break;
            }
            curVal = arr[index++];
            if (curVal != -1) {
                treeNode.right = new TreeNode(curVal);
                linkedList.addFirst(treeNode.right);
            }
        }
        return root;
    }
}
