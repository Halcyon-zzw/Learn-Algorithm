import mode.TreeNode;
import offer.offer_1_50.offer_34.PathSum;
import offer.offer_1_50.offer_34.impl.PathSumByRecursionImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-22 11:10
 * @Version: 1.0
 */
public class Offer34PathSumTest34 {
    TreeNode root = null;
    List<TreeNode> treeNodes = new ArrayList<>();
//        int[] arr = {1, 2};
        int[] arr = {-2, -1, -3,};
//    int[] arr = {5,4,8,11,-1,13,4,7,2,-1,-1,5,1};
    @Before
    public void init() {

        treeNodes.add(TreeNode.create(arr));
        root = TreeNode.create(arr);
    }

    @Test
    public void test() {
        PathSum pathSum = new PathSumByRecursionImpl();
        System.out.println(pathSum.pathSum(root, -5));
    }
}
