import mode.TreeNode;
import offer.offer_1_50.offer_33.VerifyPostorder;
import offer.offer_1_50.offer_33.impl.VerifyPostorderByRecursionImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-22 10:33
 * @Version: 1.0
 */
public class Offer33_VerifyPostorderTest {
    TreeNode root = null;
//    int[] arr = {1, 2, 5, 10, 6, 9, 4, 3};
    int[] arr = {1,6,3,2,5};
    @Before
    public void init() {
        root = TreeNode.create(arr);
    }
    @Test
    public void test() {
        VerifyPostorder verifyPostorder = new VerifyPostorderByRecursionImpl();
        boolean b = verifyPostorder.verifyPostorder(arr);
        System.out.println(b);
    }
}
