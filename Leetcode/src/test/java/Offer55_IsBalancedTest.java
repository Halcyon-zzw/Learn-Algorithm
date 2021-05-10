import mode.TreeNode;
import offer.offer_55.impl.IsBalancedByRecursionImpl;
import org.junit.Before;
import org.junit.Test;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-25 16:26
 * @Version: 1.0
 */
public class Offer55_IsBalancedTest {
    TreeNode root = null;
    List<TreeNode> treeNodes = new ArrayList<>();
    int[] arr = {1,2,2,3,-1,-1,3,4,-1,-1,4};
    @Before
    public void init() {
        treeNodes.add(TreeNode.create(arr));
        root = TreeNode.create(arr);
    }
    @Test
    public void test() {
        Object testVal = TestUtils.test(IsBalancedByRecursionImpl.class, root);
        System.out.println(testVal);
    }
}
