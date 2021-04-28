import offer.mode.TreeNode;
import offer.offer_54.KthLargest;
import offer.offer_54.impl.kthLargestByMidOptImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-25 15:07
 * @Version: 1.0
 */
public class Offer54_KthLargestTest {
    TreeNode root = null;
    List<TreeNode> treeNodes = new ArrayList<>();
    int[] arr = {5,3,6,2,4,-1,-1,1};
    @Before
    public void init() {
        treeNodes.add(TreeNode.create(arr));
        root = TreeNode.create(arr);
    }
    @Test
    public void test() {
        KthLargest kthLargest = new kthLargestByMidOptImpl();
        kthLargest.kthLargest(root, 3);
    }
}
