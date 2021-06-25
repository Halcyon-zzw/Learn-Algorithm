package offer.offer_1_50.offer_33.impl;

import offer.offer_1_50.offer_33.VerifyPostorder;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-21 19:49
 * @Version: 1.0
 */
public class VerifyPostorderByRecursionImpl implements VerifyPostorder {
    @Override
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null) {
            return false;
        }
        return recursion(postorder, 0, postorder.length - 1);
    }

    /**
     *
     * @param postorder
     * @param start 开始下标
     * @param end 结束下标
     * @return
     */
    private boolean recursion(int[] postorder, int start, int end) {
        if (start > end) {
            return true;
        }

        int root = postorder[end];
        //左子树
        int left = start;
        while (left < end && postorder[left] <= root) {
            left++;
        }
        left--;
        //右子树全部大于root
        for (int right = left + 1; right < end; right++) {
            if (postorder[right] < root) {
                return false;
            }
        }
        return recursion(postorder, start, left) && recursion(postorder, left + 1, end - 1);
    }



}
