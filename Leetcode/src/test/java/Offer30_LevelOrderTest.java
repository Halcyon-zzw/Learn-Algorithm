import mode.TreeNode;
import offer.offer_1_50.offer_32.LevelOrderII;
import offer.offer_1_50.offer_32.impl.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-21 19:06
 * @Version: 1.0
 */
public class Offer30_LevelOrderTest {

    TreeNode root = null;
    @Before
    public void init() {
        int[] arr = {3,9,20,-1,-1,15,7};
        root = TreeNode.create(arr);
    }

    @Test
    public void testII() {
        LevelOrderII levelOrderII = new LevelOrderIIByRecursionImpl();
        final List<List<Integer>> lists = levelOrderII.levelOrder(root);
        System.out.println();
    }

    @Test
    public void testIII() {
        LevelOrderII levelOrderIII = new LevelOrderIIIByQueueZImpl();
        List<List<Integer>> lists = levelOrderIII.levelOrder(root);
        System.out.println();
    }
}
