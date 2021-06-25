package interview.interview_tree.interview_0409.impl;

import interview.interview_tree.interview_0409.BSTSequences;
import mode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 未解答
 *
 * @Author: zhuzw
 * @Date: 2021-06-23 15:55
 * @Version: 1.0
 */
public class BSTSequencesImpl implements BSTSequences {
    @Override
    public List<List<Integer>> getBSTSequences(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> midLeftRight = new ArrayList<>();
        List<Integer> midRightLeft = new ArrayList<>();

        getMidLeftRight(root, midLeftRight);
        getMidRightLeft(root, midRightLeft);
        if (!midLeftRight.isEmpty()) {
            result.add(midLeftRight);
        }

        result.add(midRightLeft);
        return result;
    }

    private void getMidRightLeft(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        getMidRightLeft(root.right, list);
        getMidRightLeft(root.left, list);
    }

    private void getMidLeftRight(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        getMidLeftRight(root.left, list);
        getMidLeftRight(root.right, list);
    }
}
