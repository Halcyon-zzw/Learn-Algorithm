package hot.test;//给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
//
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。
//
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 树中结点数在范围 [0, 2000] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
//
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1691 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import mode.TreeNode;
import org.w3c.dom.ls.LSOutput;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        flatten1(root);
    }

    /**
     * 原地算法
     *
     * node = root
     * while node != null
     *   if node左子树不为空: 将左子树接到node的右子树
     *   难点: 怎么将左子树和原来的右子树连接（找到左子树的最右节点）
     *   node = node.right
     *
     * @param root
     */
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                //找到最右节点
                TreeNode lastRightNode = node.left;
                while (lastRightNode.right != null) {
                    lastRightNode = lastRightNode.right;
                }
                //接到右子树
                lastRightNode.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
        System.out.println();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
